package controller;

import model.CheapestAlgorithm;
import model.CheapestProduct;
import model.Product;
import model.Specification;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Product price calculator controller.
 */
public class CheapestProductController {
    private volatile CheapestProduct cheapest;

    private void updateCheapest(CheapestProduct cheapestProduct) {
        // Perform checks to see if a write is needed
        if (cheapest != null && cheapest.getPrice().compareTo(cheapestProduct.getPrice()) <= 0)
            return;

        // Acquire a lock as we wanna write
        synchronized(this) {
            // If we don't have a cheapest product, just set the first product to cheapest
            if (cheapest == null) {
                cheapest = cheapestProduct;

                return;
            }
            // If the difference is 0 or below that means the new product isn't cheaper
            if (cheapest.getPrice().compareTo(cheapestProduct.getPrice()) <= 0)
                return;

            cheapest = cheapestProduct;
        }
    }

    public CheapestProduct findCheapestProduct(Specification specification, List<Product> products) throws InterruptedException {
        // We need a list of our threads to later join them
        List<Thread> threads = new ArrayList<>();

        final int size = products.size();
        for (int i = 0; i < size; i++) {
            Product product = products.get(i);
            /*
             * We need to clone our specification as Java uses internal pointers.
             *
             * Meaning that if we were to manipulate the specification parameter every iteration
             * we would manipulate the same object over and over.
             *
             * By cloning it we make sure each iteration has it's own unique object.
             */
            Specification spec = specification.clone();
            spec.setProduct(product);
            // For testing we have this locked at 1
            spec.setQuantity(1);

            // Supply the specification + our consumer
            Thread thread = new CheapestAlgorithm(spec, this::updateCheapest);
            threads.add(thread);
        }

        /*
         * It's actually more performant to start the threads in a separate for loop if we have a lot of products.
         *
         * This is due to the fact that we will have a lot less interrupts on the main thread
         * when our callback comes back from a worker thread, as by now our main thread is doing nothing;
         * while it would be busy populating the threads List if we started the threads in the previous for loop.
         */
        for (Thread t : threads) {
            t.start();
        }

        // Wait for all threads to finish
        for (Thread t : threads) {
            t.join();
        }

        return cheapest;
    }
}
