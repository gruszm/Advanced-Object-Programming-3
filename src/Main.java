import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        System.out.println(Kalkulator.calc("20 plus 30"));
        System.out.println(Kalkulator.calc("sin 30"));
        System.out.println(Kalkulator.calc("pierwiastek 64"));
    }
}