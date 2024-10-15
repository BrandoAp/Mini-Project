package Class;

public class Producto {
    private String products;
    private double price;

    public Producto(String products, double price){
        this.products = products;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }
}
