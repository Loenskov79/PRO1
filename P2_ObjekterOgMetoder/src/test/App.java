package test;

import model.MultipleChoiceTest;
import model.Student;
import model.Team;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Team Hold1 = new Team("Hold1", "A.128");
        Team Hold2 = new Team("Hold2", "A.119");
        Student student1 = new Student ("Mikkel", true);
        Student student2 = new Student ("Daniel", true);
        Student student3 = new Student ("Oskar", true);
        Student student4 = new Student ("Heino", false);
        Student student5 = new Student ("Mille", false);
        Student student6 = new Student ("Isabella", true);
        MultipleChoiceTest test1 = new MultipleChoiceTest();
        Hold1.addStudent(student1);
        Hold1.addStudent(student2);
        Hold1.addStudent(student3);
        Hold2.addStudent(student4);
        Hold2.addStudent(student5);
        Hold2.addStudent(student6);

        student1.addGrade(02);
        student1.addGrade(10);
        student1.addGrade(7);
        student1.addGrade(7);
        student4.addGrade(7);
        student4.addGrade(10);
        student4.addGrade(4);
        student4.addGrade(7);

        student1.studentAnswers();
        student2.studentAnswers();
        student3.studentAnswers();
        student4.studentAnswers();
        student5.studentAnswers();
        student6.studentAnswers();

        Hold1.studentsCorrectAnswers();
        Hold1.studentTestInfo();
        Hold1.printTestInfo();

        Hold2.printTestInfo();
    }

}
