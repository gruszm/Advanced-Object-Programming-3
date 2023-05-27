package zadanie3;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Objects;

@DefaultStudent(imie = "Jan", nazwisko = "Nowak", index = 10000, oceny = {3, 5})
public class Student
{
    private String imie, nazwisko;
    @IgnoreEquals
    private int index;
    @IgnoreEquals
    ArrayList<Double> oceny = new ArrayList<>();

    @IgnoreEquals
    public int nowePole;

    public Student(String imie, String nazwisko, int index)
    {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.index = index;
        this.nowePole = 0;
    }

    public Student()
    {
        Class c = this.getClass();
        Class<DefaultStudent> ac = DefaultStudent.class;

        if (c.isAnnotationPresent(ac))
        {
            System.out.println("Jest adnotacja");
            DefaultStudent ds = (DefaultStudent) c.getAnnotation(ac);
            imie = ds.imie();
            nazwisko = ds.nazwisko();
            index = ds.index();

            for (Double x : ds.oceny())
            {
                oceny.add(x);
            }
        }
    }

    @Override
    public String toString()
    {
        return "zadanie3.Student{" +
                "imie=" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", index=" + index +
                ", oceny=" + oceny +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        Field[] pola = this.getClass().getDeclaredFields();

        for (Field pole : pola)
        {
            pole.setAccessible(true);

            if (pole.isAnnotationPresent(IgnoreEquals.class))
            {
                continue;
            }

            try
            {
                Object wartoscTegoObiektu = pole.get(this);
                Object wartoscDrugiegoObiektu = pole.get(o);

                if (!Objects.equals(wartoscTegoObiektu, wartoscDrugiegoObiektu))
                {
                    return false;
                }
            }
            catch (IllegalAccessException e)
            {
                e.printStackTrace();
                return false;
            }
        }

        return true;
    }
}
