/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in) ;
    Service s = new Service();

    boolean exit = false;
    while (!exit) {
      System.out.println("Wybierz opcję:");
      System.out.println("1. Dodaj studenta");
      System.out.println("2. Wyświetl listę studentów");
      System.out.println("3. Wyjdź");

      int choice = Integer.parseInt(scanner.nextLine()); // Use nextLine() to avoid input issues

      switch (choice) {
        case 1:
          System.out.println("Podaj imię studenta:");
          String firstName = scanner.nextLine();
          System.out.println("Podaj nazwisko studenta:");
          String lastName = scanner.nextLine();
          System.out.println("Podaj wiek studenta:");
          int age = Integer.parseInt(scanner.nextLine()); // Use nextLine() to read age
          System.out.println("Podaj datę urodzenia studenta (YYYY-MM-DD):");
          String dateOfBirth = scanner.nextLine();
          s.addStudent(new Student(firstName, lastName, age, dateOfBirth));
          break;
        case 2:
          var students = s.getStudents();
          for (Student current : students) {
            System.out.println(current.toString());
          }
          break;
        case 3:
          exit = true;
          break;
        default:
          System.out.println("Niepoprawny wybór.");
      }
    }
    scanner.close(); // Ensure the scanner is closed properly
  }
}

class Student {
  private String firstName;
  private String lastName;
  private int age;
  private String dateOfBirth;

  public Student(String firstName, String lastName, int age, String dateOfBirth) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.dateOfBirth = dateOfBirth;
  }

  @Override
  public String toString() {
    return "Student{firstName='" + firstName + "', lastName='" + lastName + "', age=" + age + ", dateOfBirth='" + dateOfBirth + "'}";
  }
}

class Service {
  private List<Student> students;

  public Service() {
    this.students = new ArrayList<>();
  }

  public void addStudent(Student student) {
    students.add(student);
  }

  public List<Student> getStudents() {
    return students;
  }
}