public class Product {
    public String name;
    public String productionDate;
    public String manufacturer;
    public String countryOfOrigin;
    public double price;
    public boolean isBooked;
    public Product(String name, String productionDate, String manufacturer, String countryOfOrigin, double price, boolean isBooked) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.isBooked = isBooked;
    }
    public void displayInfo() {
        System.out.println("Товар: " + name + ", Дата: " + productionDate + ", Цена: " + price);
    }

}
