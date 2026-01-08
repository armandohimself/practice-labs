package practice.generic;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GenericExerciseTest {
    /**
     * If a GenericExercise is created that stores Strings, then it should be able to set and retrieve String values.
     */
    @Test
    public void GenericStringTest(){
        GenericExercise<String> ge = new GenericExercise<>();
        ge.loadGenericItem("generic");
        String expected = "generic";
        String actual = ge.returnGenericItem();
        assertEquals(actual, expected);
    }
    /**
     * If a GenericExercise is created that stores Objects of type Integer (a wrapper class for ints), then
     * it should be able to set and retrieve int values.
     */
    @Test
    public void GenericIntTest(){
        GenericExercise<Integer> ge = new GenericExercise<>();
        ge.loadGenericItem(5);
        int expected = 5;

        if(ge.returnGenericItem() == null){
            fail();
        }else{
            int actual = ge.returnGenericItem();
            assertEquals(actual, expected);
        }
    }
}
