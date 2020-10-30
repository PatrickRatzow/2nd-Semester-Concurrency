import controller.CheapestProductController;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class main {
    private static Random random = new Random();
    private static CheapestProductController cheapestProductController = new CheapestProductController();

    public static void main(String[] args) throws InterruptedException {
        // Start time for benchmark
        long startTime = System.nanoTime();

        List<Product> products = new ArrayList<>();
        // Ensure a need seed every run
        random.setSeed(startTime);
        for (int i = 0; i < 1500; i++) {
            Product product = new Product(String.valueOf(i), "", new Price(random.nextInt(1500000)));
            products.add(product);
        }

        Specification spec = new Roof();
        CheapestProduct cheapestProduct = cheapestProductController.findCheapestProduct(spec, products);

        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1e6;

        System.out.println("Took " + duration + "ms to find cheapest product");
        System.out.println("--------Cheapest Product-------");
        System.out.println(cheapestProduct);
    }
}
