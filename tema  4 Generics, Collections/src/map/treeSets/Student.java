package map.treeSets;

public class Student implements Comparable<Student> {
    String name;
    double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

    public Integer getRoundedGrade() {
        return this.grade - (int)this.grade >= .5 ? (int)this.grade + 1 : (int)this.grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public int compareTo(Student o) {
        return Double.compare(o.grade, this.grade);
    }
}
