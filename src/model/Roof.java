package model;

/**
 * The type Roof.
 */

// This is supposed to calculate price for a roof, but not needed for concurrency demonstration
public class Roof extends Specification {
    @Override
    public Roof clone() {
        return new Roof();
    }

    @Override
    public boolean isValid(Product product) {
        return true;
    }

    @Override
    public Price getPrice() {
        Price price = new Price();

        price.setAmount(getQuantity() * getProduct().getPrice().getAmount());

        return price;
    }
}
