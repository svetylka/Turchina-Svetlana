public class MathOperations {
    // 1. Вычисление факториала
    public long getFactorial(int number) {
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
    // 2. Площадь треугольника
    public double getTriangleArea(double base, double height) {
        return 0.5 * base * height;
    }
    // 3. Арифметические действия
    public int calculate(int a, int b, String operation) {
        if (operation.equals("+")) return a + b;
        if (operation.equals("-")) return a - b;
        if (operation.equals("*")) return a * b;
        if (operation.equals("/")) return a / b;
        return 0;
    }
    // 4. Сравнение двух чисел
    public String compareNumbers(int a, int b) {
        if (a > b) return "Первое число больше второго";
        if (a < b) return "Второе число больше первого";
        return "Числа равны";
    }

}

