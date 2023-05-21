import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Kalkulator {
    public static double plus(double a, double b)
    {
        return a+b;
    }

    public static double sin(double x)
    {
        return Math.sin(x);
    }

    public static double pierwiastek(double x)
    {
        return Math.sqrt(x);
    }

    public static double calc(String expr) {
        String tab[] = expr.split(" ");
        Double z = 0.0;

        try {
            Double x = Double.parseDouble(tab[0]);
            Double y = Double.parseDouble(tab[2]);

            Class c = Kalkulator.class;
            Method m = c.getDeclaredMethod(tab[1], double.class, double.class);
            z = (Double) m.invoke(null, x, y);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.err.println("niepowodzenie dla dwoch argumentow");

            try
            {
                Double x = Double.parseDouble(tab[1]);
                Class c = Kalkulator.class;
                Method m = c.getDeclaredMethod(tab[0], double.class);
                z = (Double) m.invoke(null, x);
            }
            catch (NoSuchMethodException | NumberFormatException | IllegalAccessException | InvocationTargetException e2)
            {
                e2.printStackTrace();
            }
        }

        return z;
    }
}
