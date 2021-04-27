package springboot.course.exercise3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepeatedTests implements SchemaRepeatedTests{
    //@RepeatedTest(value = 20, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
    @RepeatedTest(20)
    @DisplayName("Repetition number: ")
    void testRepeat(TestInfo testInfo, RepetitionInfo repetitionInfo){
        assertEquals(1,1);
    }
}
