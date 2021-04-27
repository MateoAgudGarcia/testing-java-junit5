package springboot.course.exercise3;

import org.junit.jupiter.api.*;

@Tag("repeat")
public interface SchemaRepeatedTests {
    @BeforeEach
    default void consoleRepeatedTest(TestInfo testInfo, RepetitionInfo repetitionInfo){
        System.out.println("Running tests --> "+testInfo.getDisplayName()+" - "
        + repetitionInfo.getCurrentRepetition()+" || "+repetitionInfo.getTotalRepetitions());
    }
}
