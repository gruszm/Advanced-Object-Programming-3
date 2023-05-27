package zadanie3;

public class Main {
    public static void main(String[] args) {
//        Student s1 = new Student();
//        Student s2 = new Student("Jan", "Nowak", 100000);
//        Student s3 = new Student("Jan", "Nowak", 100000);
//        System.out.println("== " + (s2==s3));
//        System.out.println("equals " + s2.equals(s3));
//
//        Student2 s21 = new Student2("Adam", "Wisniewski", 10000, false);
//        Student2 s22 = new Student2();
//
//        System.out.println("Student s1 " + s1);
//        System.out.println("Student s2 " + s2);
//
//        System.out.println("Student s21 " + s21);
//        System.out.println("Student s22 " + s22);

        Student jan = new Student("Jan", "Swiatek", 221);
        Student jan2 = new Student("Jan", "Szokalski", 245);
        Student jan3 = new Student("Jan", "Swiatek", 4588);

        System.out.println("jan == jan2: " + jan.equals(jan2));
        System.out.println("jan2 == jan3: " + jan2.equals(jan3));
        System.out.println("jan == jan3: " + jan.equals(jan3));

        System.out.println("dodanie nowego pola");

        jan.nowePole = 4400;
        jan3.nowePole = 1200;

        System.out.println("jan == jan3: " + jan.equals(jan3));
    }
}