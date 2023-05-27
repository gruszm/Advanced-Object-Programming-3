package zadanie2;

public class Student extends Osoba
{
    private int ocena;

    public Student(String imie, String nazwisko, int ocena)
    {
        super(imie, nazwisko);
        this.ocena = ocena;
    }

    public int getOcena()
    {
        return ocena;
    }
}