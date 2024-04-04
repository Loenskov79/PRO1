package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Team {

    private String name;
    private String room;
    private ArrayList<Student> students = new ArrayList<>();

    public Team(String name, String room) {
        this.name = name;
        this.room = room;
    }

    public String toString() {
        return name;
    }

    public void addStudent (Student student) {
        students.add(student);
    }

    public void printActiveStudent () {
        for (Student student : activeStudents()) {
            System.out.println(student.getName());
        }
    }

    public void printStudent () {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public ArrayList<Student> activeStudents () {
        ArrayList<Student> activeStudents = new ArrayList<>();

        for (Student student : students) {
            if (student.isActive()) {
                activeStudents.add(student);
            }
        }
        students = activeStudents;
        return activeStudents;
    }

    public void removeStudent (String name) {
        boolean found = false;
        int counter = 0;

        while (!found) {
            Student studentTemp = students.get(counter);

            if (Objects.equals(studentTemp.getName().toLowerCase(), name.toLowerCase())) {
                students.remove(counter);
                found = true;
            }
            else if (counter == students.size() - 1) {
                found = true;
            }
            else {
                counter++;
            }
        }
    }

    public double getAverageTeamGrade () {
        double avg = 0;

        for (Student student : students) {
            avg += student.getAverageGrade();
        }
        return avg / students.size();
    }

    public ArrayList<Student> highScoreStudents (double minAverage) {
        ArrayList<Student> highScoreStudents = new ArrayList<>();

        for (Student student : activeStudents()) {
            if (student.getAverageGrade() >= minAverage) {
                highScoreStudents.add(student);
            }
        }
        return highScoreStudents;
    }

    public ArrayList<Integer> studentsCorrectAnswers() {
        ArrayList<Integer> correctAnswers = new ArrayList<>();

        for (int i = 0; i < students.size(); i++) {
            correctAnswers.add(students.get(i).correctAnswersCount());
        }
        return correctAnswers;
    }

    public ArrayList<String> studentTestInfo () {
        ArrayList<String> studentTestInfo = new ArrayList<>();

        for (int i = 0; i < students.size(); i++) {
            String name = students.get(i).getName();
            String average = Double.toString(students.get(i).getAverageGrade());
            String correct = Integer.toString(students.get(i).correctAnswersCount());
            studentTestInfo.add(name + " " + average + " " + correct);
        }

        return studentTestInfo;
    }

    public void printTestInfo() {
        System.out.printf("%-15s %-10s %-10s\n", "Name", "Average", "Correct Answers");
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < students.size(); i++) {
            String name = students.get(i).getName();
            String average = Double.toString(students.get(i).getAverageGrade());
            String correct = Integer.toString(students.get(i).correctAnswersCount());

            System.out.printf("%-15s %-10s %-10s\n", name, average, correct);
        }
    }

    public ArrayList<Integer> correctAnswersPerQuestion () {
        ArrayList<Integer> correctAnswersPerQuestion = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        MultipleChoiceTest correctAnswers = new MultipleChoiceTest();
        ArrayList<Character> listOfAnswers = correctAnswers.getTestAnswers();

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            ArrayList<Character> studentTemp = student.getStudentAnswers();
            for (int j = 0; j < 10; j++) {
                if (studentTemp.get(j) == listOfAnswers.get(j)) {
                    correctAnswersPerQuestion.set(j, correctAnswersPerQuestion.get(j) + 1);
                }
            }
        }
        return correctAnswersPerQuestion;
    }
}
