public class Lesson_3 {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung S25", "01.02.2026", "Samsung", "Korea", 5500, true);
        productsArray[1] = new Product("iPhone 17", "10.09.2025", "Apple", "USA", 6200, false);
        productsArray[2] = new Product("Xiaomi 15", "15.03.2025", "Xiaomi", "China", 4500, true);
        productsArray[3] = new Product("Pixel 10", "13.08.2025", "Google", "USA", 3900, false);
        productsArray[4] = new Product("Sony Xperia", "20.05.2025", "Sony", "Japan", 4800, false);
        for (Product item : productsArray) {
            item.displayInfo();
        }
        Park.Attraction coaster = new Park.Attraction("Горки", "10:00-22:00", 500.0);
        coaster.displayAttractionInfo();



    }
}
