import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private ArrayList<Double> marks;
    private int totalSubjects;

    public Student(int totalSubjects) {
        this.totalSubjects = totalSubjects;
        this.marks = new ArrayList<>();
    }

    public void addMark(double mark) {
        marks.add(mark);
    }

    public double getTotalMarks() {
        return marks.stream().mapToDouble(Double::doubleValue).sum();
    }

    public double getAveragePercentage() {
        return getTotalMarks() / totalSubjects;
    }

    public String getGrade() {
        double average = getAveragePercentage();
        if (average >= 90) return "A+";
        if (average >= 80) return "A";
        if (average >= 70) return "B+";
        if (average >= 60) return "B";
        if (average >= 50) return "C+";
        if (average >= 40) return "C";
        return "F";
    }
}

public class MarksCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter number of subjects: ");
            int totalSubjects = scanner.nextInt();

            if (totalSubjects <= 0) {
                System.out.println("Subjects must be greater than zero.");
                return;
            }

            Student student = new Student(totalSubjects);

            for (int i = 1; i <= totalSubjects; i++) {
                System.out.print("Enter marks for subject " + i + ": ");
                double mark = scanner.nextDouble();
                if (mark < 0 || mark > 100) {
                    System.out.println("Marks must be between 0 and 100.");
                    return;
                }
                student.addMark(mark);
            }

            System.out.println("\nResults:");
            System.out.printf("Total Marks: %.2f\n", student.getTotalMarks());
            System.out.printf("Average Percentage: %.2f%%\n", student.getAveragePercentage());
            System.out.println("Grade: " + student.getGrade());
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter numbers only.");
        } finally {
            scanner.close();
        }
    }
}
