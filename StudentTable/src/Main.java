import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        // Linked list to store the data
        LinkedList<Student> data = new LinkedList<>();

        // Binary tree to perform search
        TreeMap<String, Integer> tree = new TreeMap<>();

        // Hash table to quickly access the data
        HashMap<String, Integer> hashTable = new HashMap<>();

        Scanner scan = new Scanner(System.in);
        while (true) {
            int choice = getUserChoice();
            if (choice == 1) {
                System.out.println("Enter name, surname, age, school name, grade (or 'q' to quit):");
                String input = scan.nextLine();
                if (input.equals("q")) {
                    break;
                }
                String[] inputs = input.split(",");
                String name = inputs[0];
                String surname = inputs[1];
                int age = Integer.parseInt(inputs[2]);
                String school = inputs[3];
                double grade = Double.parseDouble(inputs[4]);
                Student student = new Student(name,surname,age,school,grade);
                // Add data to linked list
                data.add(student);

                // Add data to binary tree
                tree.put(name, data.size() - 1);

                // Add data to hash table
                hashTable.put(name, data.size() - 1);
            } else if (choice == 2) {
                System.out.println("Enter a name to search:");
                String search = scan.nextLine();

                // Search in binary tree
                Integer index = tree.get(search);
                if (index != null) {
                    System.out.println("Found in binary tree at index " + index);
                    System.out.println("Information of student : "+data.get(index));
                } else {
                    System.out.println("Not found in binary tree");
                }

                // Search in hash table
                index = hashTable.get(search);
                if (index != null) {
                    System.out.println("Found in hash table at index " + index);
                    System.out.println("Information of student : "+data.get(index));
                } else {
                    System.out.println("Not found in hash table");
                }
            } else if (choice == 3) {
                break;
            }
            else if (choice == 4) {
                System.out.println("Enter a name to update:");
                String update = scan.nextLine();
                Integer index = tree.get(update);
                if (index != null) {
                    System.out.println("Enter new name, surname, age, school name, grade:");
                    String input = scan.nextLine();
                    String[] inputs = input.split(",");
                    String name = inputs[0];
                    String surname = inputs[1];
                    int age = Integer.parseInt(inputs[2]);
                    String school = inputs[3];
                    double grade = Double.parseDouble(inputs[4]);
                    Student student = new Student(name,surname,age,school,grade);
                    data.set(index, student);
                    tree.put(name, index);
                    hashTable.put(name, index);
                    System.out.println("Student information updated successfully!");
                } else {
                    System.out.println("Student not found!");
                }
            }
            else if (choice == 5) {
                System.out.println("Enter a name to delete:");
                String delete = scan.nextLine();
                Integer index = tree.get(delete);
                if (index != null) {
                    data.remove(index);
                    tree.remove(delete);
                    hashTable.remove(delete);
                    System.out.println("Student deleted successfully!");
                } else {
                    System.out.println("Student not found!");
                }
            }


        }
    }

    public static int getUserChoice() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What do you want to do?\n1. Add student\n2. Search student\n3. Quit\n4. Update student\n5. Delete student");
        int choice = scan.nextInt();
        scan.nextLine();
        return choice;
    }

}
class Student{
    String name;
    String surname;
    int age;
    String school;
    double grade;
    public Student(String name, String surname, int age, String school, double grade) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.school = school;
        this.grade = grade;
    }
    public String toString(){
        return "Name : "+name+" Surname : "+surname+" Age : "+age+" School : "+school+" Grade : "+grade;
    }
}
