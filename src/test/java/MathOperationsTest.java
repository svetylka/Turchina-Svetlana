import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathOperationsTest {
    private final MathOperations math = new MathOperations();

    // === 1. ФАКТОРИАЛ (3 теста = 3 проверки) ===
    @Test public void testFact5() { assertEquals(120, math.getFactorial(5)); }
    @Test public void testFact0() { assertEquals(1, math.getFactorial(0)); }
    @Test public void testFact1() { assertEquals(1, math.getFactorial(1)); }

    // === 2. ПЛОЩАДЬ ТРЕУГОЛЬНИКА (3 теста = 3 проверки) ===
    @Test public void testAreaStandard() { assertEquals(10.0, math.getTriangleArea(4, 5)); }
    @Test public void testAreaSmall() { assertEquals(1.0, math.getTriangleArea(1, 2)); }
    @Test public void testAreaDecimal() { assertEquals(4.5, math.getTriangleArea(3, 3)); }

    // === 3. КАЛЬКУЛЯТОР (3 теста = 3 проверки) ===
    @Test public void testCalcPlus() { assertEquals(10, math.calculate(7, 3, "+")); }
    @Test public void testCalcMinus() { assertEquals(6, math.calculate(10, 4, "-")); }
    @Test public void testCalcMulti() { assertEquals(25, math.calculate(5, 5, "*")); }

    // === 4. СРАВНЕНИЕ (3 теста = 3 проверки) ===
    @Test public void testCompGreater() { assertEquals("Первое число больше второго", math.compareNumbers(10, 5)); }
    @Test public void testCompLess() { assertEquals("Второе число больше первого", math.compareNumbers(3, 7)); }
    @Test public void testCompEqual() { assertEquals("Числа равны", math.compareNumbers(5, 5)); }
}
