package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MultipleChoiceTest {

    private ArrayList<Character> testAnswers = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D', 'A', 'B', 'C', 'D', 'A', 'B'));

    public ArrayList<Character> getTestAnswers() {
        return testAnswers;
    }
}
