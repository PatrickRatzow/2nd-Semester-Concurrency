package model;

/**
 * The type Price.
 */
public class Price implements Comparable<Price> {
    private int amount;

    /**
     * Instantiates a new Price.
     */
    public Price() {}

    /**
     * Instantiates a new Price.
     *
     * @param amount the amount
     */
    public Price(int amount) {
        this.amount = amount;
    }

    /**
     * Gets amount.
     *
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Sets amount.
     *
     * @param amount the amount
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return (getAmount() / 100) + " kr.";
    }

    @Override
    public int compareTo(Price price) {
        return amount - price.getAmount();
    }
}
