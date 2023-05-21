package zadanie3;

@DefaultStudent(imie = "Anna", nazwisko = "Kowalska", oceny = {5, 5, 5}, index = 222222)
public class Student2 extends Student{
    private boolean stacjonarny;

    public Student2(String imie, String nazwisko, int index, boolean stacjonarny)
    {
        super(imie, nazwisko, index);
        this.stacjonarny = stacjonarny;
    }

    public Student2()
    {
        super();
    }

    @Override
    public String toString()
    {
        return super.toString() + ", stacjonarny = " + stacjonarny;
    }
}
