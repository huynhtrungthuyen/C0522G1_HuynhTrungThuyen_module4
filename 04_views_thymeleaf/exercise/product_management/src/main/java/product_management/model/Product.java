package product_management.model;

public class Product {
    private int id;
    private String name;
    private double price;
    private String describe;
    private String producer;

    public Product() {
    }

    public Product(int id, String name, double price, String describe1, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.describe = describe1;
        this.producer = producer;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}