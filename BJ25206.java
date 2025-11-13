import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Calculator student_1 = new Calculator();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String info;
            while ((info = br.readLine()) != null) {
                info = info.trim();

                if (info.isEmpty()) {
                    continue;
                }
                String[] arr = info.split(" ");

                double credit = Double.parseDouble(arr[1]);

                if (arr[2].equals("P")) {
                    continue;
                }
                double grade = ScoreChecker.getScore(arr[2]);

                student_1.sum(credit, grade);
            }
            double result = student_1.divideSum();

            System.out.print(result);

        } catch (IOException | NumberFormatException e) {
            System.out.print(e.getMessage());
        }
    }
}

class Calculator {
    private double sum;
    private double totalCredit;

    public void sum(double credit, double grade) {
        sum += (credit * grade);
        totalCredit += credit;
    }

    public double divideSum() {
        if (totalCredit == 0) {
            return 0.0;
        }
        return sum / totalCredit;
    }
}

class ScoreChecker {
    public static double getScore(String grade) {
        switch (grade) {
            case "A+":
                return 4.5;
            case "A0":
                return 4.0;
            case "B+":
                return 3.5;
            case "B0":
                return 3.0;
            case "C+":
                return 2.5;
            case "C0":
                return 2.0;
            case "D+":
                return 1.5;
            case "D0":
                return 1.0;
            default:
                return 0.0;
        }
    }
}
