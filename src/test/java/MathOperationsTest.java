import org.testng.Assert;
import org.testng.annotations.Test;

public class MathOperationsTest {
    MathOperations math = new MathOperations();

    @Test
    void testAll() {
        // 1. Проверка факториала (В TestNG: сначала полученное значение, потом ожидаемое)
        Assert.assertEquals(math.getFactorial(5), 120);

        // 2. Проверка площади треугольника
        Assert.assertEquals(math.getTriangleArea(4, 5), 10.0);

        // 3. Проверка калькулятора
        Assert.assertEquals(math.calculate(7, 3, "+"), 10);

        // 4. Проверка сравнения чисел
        Assert.assertEquals(math.compareNumbers(10, 5), "Первое число больше второго");
    }
}
