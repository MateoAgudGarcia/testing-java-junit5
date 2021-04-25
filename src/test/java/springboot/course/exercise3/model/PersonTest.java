package springboot.course.exercise3.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person person;
    @BeforeEach
    void setUp() {
        //given
        person = new Person(2123L,"Pepito","Perez");
    }

    @Test
    void groupedAssertions(){
        //then
        assertAll("Test person properties",
                () -> assertEquals("Pepito",person.getFirstName()),
                () -> assertEquals("Perez",person.getLastName()));
    }

    @Test
    void groupedAssertionsMessages(){
        //then
        assertAll("Test person properties with messages",
                () -> assertEquals("Pepito",person.getFirstName(),"First name failed"),
                () -> assertEquals("Perez",person.getLastName(),"Last name failed"));
    }
}