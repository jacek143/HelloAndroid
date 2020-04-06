package com.example.myfirstapp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExpressionProcessorTests {
    private SpyLog log = new SpyLog();
    private ExpressionProcessor processor = new ExpressionProcessor(log);

    @Test
    public void addition_isCorrect() {
        assertEquals("4.0", processor.run("2 + 2"));
    }

    @Test
    public void difference_isCorrect() {
        assertEquals("13.0", processor.run("15 - 2"));
    }

    @Test
    public void incorrectExpression_isUserInformed() {
        assertEquals("Invalid expression", processor.run("dupa / 4"));
    }

    @Test
    public void incorrectExpression_isLogged() {
        processor.run("foo");
        assertEquals("ExpressionProcessor", log.tag);
        assertEquals("org.mozilla.javascript.EcmaError: ReferenceError: \"foo\" is not defined. (<cmd>#1)", log.message);
    }
}