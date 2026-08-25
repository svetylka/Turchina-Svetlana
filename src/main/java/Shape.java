public interface Shape {
    double getArea();
    double getPerimeter();
    String getFillColor();
    String getBorderColor();

    default void printInfo() {
        System.out.printf("Фигура: %s [Периметр: %.2f, Площадь: %.2f, Цвет фона: %s, Цвет границ: %s]%n",
                this.getClass().getSimpleName(),
                getPerimeter(),
                getArea(),
                getFillColor(),
                getBorderColor());
    }
}
