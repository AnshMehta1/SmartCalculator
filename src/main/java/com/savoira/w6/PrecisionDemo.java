import java.math.BigDecimal;

public class PrecisionDemo {

    public static void main(String[] args) {

        // Using double
        double doubleResult = 0.1 + 0.2;
        System.out.println("Using double: " + doubleResult);

        // Using BigDecimal
        BigDecimal a = new BigDecimal("0.1");
        BigDecimal b = new BigDecimal("0.2");

        BigDecimal bigDecimalResult = a.add(b);

        System.out.println("Using BigDecimal: " + bigDecimalResult);
    }
}