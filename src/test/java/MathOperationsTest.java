import org.testng.annotations.Test;
import org.testng.Assert;

public class MathOperationsTest {
    private final MathOperations math = new MathOperations();

    // === 1. ФАКТОРИАЛ (TestNG: actual, expected) ===
    @Test public void testFact5() { Assert.assertEquals(math.getFactorial(5), 120); }
    @Test public void testFact0() { Assert.assertEquals(math.getFactorial(0), 1); }
    @Test public void testFact1() { Assert.assertEquals(math.getFactorial(1), 1); }

    // === 2. ПЛОЩАДЬ ТРЕУГОЛЬНИКА ===
    @Test public void testAreaStandard() { Assert.assertEquals(math.getTriangleArea(4, 5), 10.0); }
    @Test public void testAreaSmall() { Assert.assertEquals(math.getTriangleArea(1, 2), 1.0); }
    @Test public void testAreaDecimal() { Assert.assertEquals(math.getTriangleArea(3, 3), 4.5); }

    // === 3. КАЛЬКУЛЯТОР ===
    @Test public void testCalcPlus() { Assert.assertEquals(math.calculate(7, 3, "+"), 10); }
    @Test public void testCalcMinus() { Assert.assertEquals(math.calculate(10, 4, "-"), 6); }
    @Test public void testCalcMulti() { Assert.assertEquals(math.calculate(5, 5, "*"), 25); }

    // === 4. СРАВНЕНИЕ ===
    @Test public void testCompGreater() { Assert.assertEquals(math.compareNumbers(10, 5), "Первое число больше второго"); }
    @Test public void testCompLess() { Assert.assertEquals(math.compareNumbers(3, 7), "Второе число больше первого"); }
    @Test public void testCompEqual() { Assert.assertEquals(math.compareNumbers(5, 5), "Числа равны"); }
}
