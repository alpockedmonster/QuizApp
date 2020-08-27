package com.example.quizapp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void controlQuestions_isCorrect() {
        MainActivity mainA = new MainActivity();
        int value = mainA.controlQuestions(0);
        assertEquals(1, value);
        value = mainA.controlQuestions(5);
        assertEquals(6, value);
        value = mainA.controlQuestions(6);
        assertEquals(0, value);
    }
}