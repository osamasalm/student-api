package student_api;

public class Student {
    private int id;
    private String name;
    private double average;

    public Student(int id, String name, double average) {
        this.id = id;
        this.name = name;
        this.average = average;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}