package zadanie3;

import java.util.ArrayList;
import java.util.List;

@DefaultStudent(imie = "Jan", nazwisko = "Nowak", index = 10000, oceny = {3, 5})
public class Student {
    private String imie, nazwisko;
    private int index;
    ArrayList<Double> oceny = new ArrayList<>();

    public Student(String imie, String nazwisko, int index) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.index = index;
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
    public String toString() {
        return "zadanie3.Student{" +
                "imie=" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", index=" + index +
                ", oceny=" + oceny +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student temp = (Student) o;

        Class<?> c = this.getClass();
        IgnoreEquals ignoreEqualsAnnotation = c.getAnnotation(IgnoreEquals.class);
        if (ignoreEqualsAnnotation != null) {
            List<String> ignoredFields = Arrays.asList(ignoreEqualsAnnotation.fields());
            for (String ignoredField : ignoredFields) {
                try {
                    Field field = c.getDeclaredField(ignoredField);
                    field.setAccessible(true);
                    Object thisValue = field.get(this);
                    Object tempValue = field.get(temp);
                    if (!Objects.equals(thisValue, tempValue)) {
                        return false;
                    }
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return this.index == temp.index && this.imie.equals(temp.imie);
    }
}
