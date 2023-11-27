package ra.model.entity;

import ra.model.util.Formatter;

import java.io.Serializable;

public class Product implements Serializable { // lớp POJO
    // để hỗ trợ đọc ghi nhị phân thì Product phải implement Serializable
    private Long productId;
    private String name;
    private String description;
    private double price;
    private int stock;
    private boolean status;


    public Product() {
    }

    public Product(String name, String description, double price, int stock, boolean status) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.status = status;
    }

    public Product(Long productId, String name, String description, double price, int stock, boolean status) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.status = status;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "[" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + Formatter.getNumberFormatterVND().format(price) +
                ", stock=" + stock +
                ", status=" + (status? "Đang bán": "Ngừng bán") +
                ']';
    }
}
