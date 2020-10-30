package model;

public class CheapestProduct {
    private Product product;
    private Price price;
    private int quantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CheapestProduct(Product product, Price price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Name: " + product.getName() + " | Price: " + price;
    }
}
