package springboot.course.exercise3.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    Owner owner;

    @BeforeEach
    void setUp(){
        //given
        owner = new Owner(2453L,"Jacinto","Jerez");
        owner.setCity("Chinchina");
        owner.setTelephone("3214567890");
    }

    @Test
    void dependentAssertions(){
        //then

        assertAll("Inheritance properties test",
                () -> assertAll("Person properties",
                        () -> assertEquals("Jacinto",owner.getFirstName(),"First name failed"),
                        () -> assertEquals("Jerez",owner.getLastName(),"Last name failed")),
                () -> assertAll("Owner properties",
                        () -> assertEquals("Chinchina",owner.getCity(),"City has failed"),
                        () -> assertEquals("3214567890",owner.getTelephone(),"Telephone failed")));
    }
}