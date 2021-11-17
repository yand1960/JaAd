package my.dal;

public class Product {

    private int id;
    private String name;
    private String code;
    private Double price;

    public Product(int id, String name, String code, Double price) {
        this.setId(id);
        this.setName(name);
        this.setCode(code);
        this.setPrice(price);
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
