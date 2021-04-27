package springboot.course.exercise3.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import springboot.course.exercise3.CustomArgumentsProvider;
import springboot.course.exercise3.testinterfaces.ModelTests;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class OwnerTest implements ModelTests {

    Owner owner;

    @BeforeEach
    void setUp(){
        //given
        owner = new Owner(2453L,"Jacinto","Jerez");
        owner.setCity("Chinchina");
        owner.setTelephone("3214567890");
    }

    @DisplayName("Test dependent assertions")
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

    @ParameterizedTest
    @ValueSource(strings = {"Mateo","Agudelo","Garcia"})
    void testValuesSource(String val){
        System.out.println(val);
    }

    @DisplayName("Order parameterized")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"Mateo","Agudelo","Garcia"})
    void testValuesSourceModified(String val){
        System.out.println(val);
    }

    @DisplayName("Enum source - Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @EnumSource(OwnerType.class)
    void enumValuesSource(OwnerType ownerType){
        System.out.println(ownerType);
    }

    @DisplayName("CSV source - Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvSource({
            "CO, 5, 8",
            "VE, 6, 9",
            "AG, 2, 3"
    })
    void csvValuesSource(String stateName, int val1, int val2){
        System.out.println(stateName+" || "+val1+" - "+val2);
    }

    @DisplayName("CSV File source - Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvFileSource(resources = "/input-countries.csv",numLinesToSkip = 1) //numLinesToSkip -> Lines of header
    void csvFileValuesSource(String stateName, int val1, int val2){
        System.out.println(stateName+" || "+val1+" - "+val2);
    }

    static Stream<Arguments> getArgs(){
        return Stream.of(
                Arguments.of("CO", 5, 8),
                Arguments.of("VE", 6, 9),
                Arguments.of("AG", 2, 3));
    }

    @DisplayName("Class provider source - Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ArgumentsSource(CustomArgumentsProvider.class)
    void classProviderValuesSource(String stateName, int val1, int val2){
        System.out.println(stateName+" || "+val1+" - "+val2);
    }



}