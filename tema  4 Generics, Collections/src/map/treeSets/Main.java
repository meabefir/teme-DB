package map.treeSets;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<Integer, TreeSet<Student>> gradesMap = new HashMap<>();

        for (int i = 0; i <= 10; ++i) {
            gradesMap.put(i, new TreeSet<Student>());
        }

        String[] names = {"Ionel", "Gigel", "Costel", "Maricel", "Mititel", "Petricel", "Marinel"};
        int noStudents = 100;

        Random rand = new Random();
        for (int i = 0; i < noStudents; ++i) {
            Student newStudent = new Student(names[rand.nextInt(names.length)], rand.nextDouble() * 10);
            Main.addStudent(newStudent, gradesMap);
        }

//        for (int i = 0; i <= 10; ++i) {
//            System.out.println(gradesMap.get(i).size());
//        }

        Main.printByGrade(gradesMap);
    }

    static void addStudent(Student student, Map<Integer, TreeSet<Student>> gradesMap) {
        gradesMap.get(student.getRoundedGrade()).add(student);
    }

    static void printByGrade(Map<Integer, TreeSet<Student>> gradesMap) {
        for (int i = 0; i <= 10; ++i) {
            System.out.println(gradesMap.get(i).size() + " elevi cu nota " + i + ":");
            for (Student s: gradesMap.get(i)) {
                System.out.println(s);
            }
            System.out.println();
        }
    }
}
