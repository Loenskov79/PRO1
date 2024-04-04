package model;

import java.util.ArrayList;
import java.util.Random;

public class Student {

    private String name;
    private boolean active;
    private ArrayList<Integer> grades = new ArrayList<>();
    private ArrayList<Character> studentAnswers = new ArrayList<>();

    public Student(String name, boolean active) {
        this.name = name;
        this.active = active;
    }

    public String toString () {
        return name;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive () {
        return active;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Character> getStudentAnswers() {
        return studentAnswers;
    }

    public void addGrade (Integer grade) {
        grades.add(grade);
    }

    public int getHighestGrade () {
        int max = Integer.MIN_VALUE;

        for (Integer grade : grades) {
            if (grade > max) {
                max = grade;
            }
        }
        return max;
    }

    public double getAverageGrade () {
        double avg = 0;

        for (Integer grade : grades) {
            avg += grade;
        }
        avg = avg / grades.size();
        return avg;
    }

    public void studentAnswers () {
        Random r = new Random();

        for (int i = 0; i < 10; i++) {
            char c = (char)(r.nextInt(4) + 'A');
            studentAnswers.add(c);
        }
    }
    public int correctAnswersCount() {
        int correctAnswer = 0;
        MultipleChoiceTest test = new MultipleChoiceTest();
        ArrayList<Character> testAnswers = new ArrayList<>();
        testAnswers = test.getTestAnswers();

        for (int i = 0; i < 10; i++) {
            char studentAnswer = studentAnswers.get(i);
            char testAnswer = testAnswers.get(i);

            if (studentAnswer == testAnswer) {
                correctAnswer++;
            }
        }
            return correctAnswer;
    }
}
