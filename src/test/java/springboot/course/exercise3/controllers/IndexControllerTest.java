package springboot.course.exercise3.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

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
    @DisplayName("Index simplified")
    void indexSimplified() {
        assertThat(controller.index()).isEqualTo("index");
    }


    @Test
    void oupsHandler() {
        assertTrue("notimplemented".equals(controller.oupsHandler()),() -> "Another type of message in assertion");
    }

    @Test
    @DisplayName("Test exception")
    @EnabledIfEnvironmentVariable(named = "username", matches = "magudelog")
    void oopsHandler(){
        assertThrows(ValueNotFoundException.class, () -> controller.oopsHandler());
    }

    @Test
    void testTimeOut(){
        assertTimeout(Duration.ofMillis(100),() -> Thread.sleep(5000),"Test failed with 5 seconds");
    }

    @Test
    void testTimeOutPreempt(){
        assertTimeoutPreemptively(Duration.ofMillis(100),() -> Thread.sleep(5000),"Test failed");
    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testAssumptionTrue(){
        assumeTrue("PERFICIENT".equalsIgnoreCase(System.getenv("PSL_RUNTIME")),"They're differents");
    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testAssumptionIsTrue(){
        assumeTrue("PERFICIENT".equalsIgnoreCase("PERFICIENT"));
    }
}