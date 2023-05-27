package zadanie2;

import java.lang.reflect.Method;

public class Osoba
{
    private String imie;
    private String nazwisko;

    public Osoba(String imie, String nazwisko)
    {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public String getImie()
    {
        return imie;
    }

    public String getNazwisko()
    {
        return nazwisko;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        Method[] metody = this.getClass().getMethods();

        for (Method m : metody)
        {
            if (m.getName().startsWith("get"))
            {
                try
                {
                    Object value = m.invoke(this);
                    sb.append(m.getName().substring(3)).append(": ").append(value).append("\t");
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();
    }
}