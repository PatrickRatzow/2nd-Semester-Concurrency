package model;

/**
 * The type Product.
 */
public class Product {
    private int id;
    private String name;
    private String desc;
    private Price price;

    /**
     * Instantiates a new Product.
     */
    public Product() {
    }

    /**
     * Instantiates a new Product.
     *
     * @param name  the name
     * @param desc  the desc
     * @param price the price
     */
    public Product(String name, String desc, Price price) {
        this.name = name;
        this.desc = desc;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets desc.
     *
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Sets desc.
     *
     * @param desc the desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public Price getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(Price price) {
        this.price = price;
    }
}
