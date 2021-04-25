package springboot.course.exercise3.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    IndexController controller;
    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @Test
    void index() {
        assertEquals("index",controller.index());
        assertEquals("index",controller.index(),"Wrong response from index");
        assertEquals("index",controller.index(),() -> "Another way to response");
    }

    @Test
    void oupsHandler() {
        assertTrue("notimplemented".equals(controller.oupsHandler()),() -> "Another type of message in assertion");
    }
}