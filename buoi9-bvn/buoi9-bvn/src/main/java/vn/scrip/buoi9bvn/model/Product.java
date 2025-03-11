package vn.scrip.buoi9bvn.model;
public class Product {
    private String id;
    private String name;
    private String description;
    private int price;

    private String brand;
    // Constructor không tham số
    public Product() {
    }
    // Constructor có tham số
    public Product(String id, String name, String description, int price, String brand) {
        this.id = id;
        this.name = name;
        this.description = description;

        this.price = price;
        this.brand = brand;
    }
    // Getter & Setter
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
}




