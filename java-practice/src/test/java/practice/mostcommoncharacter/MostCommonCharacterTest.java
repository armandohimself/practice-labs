package practice.mostcommoncharacter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.util.TargetResolver;

import static org.junit.jupiter.api.Assertions.*;

public class MostCommonCharacterTest {

        

    
    private MostCommonCharacterSolution solution;

    @BeforeEach
    void setUp() throws Exception {
        solution = TargetResolver.resolve("practice.mostcommoncharacter", "MostCommonCharacter");
    }

/**
     * Within these numbers, 1 appears the most.
     */
    @Test
        public void mostCommonCharacterTest1() {
            String str = "5003196532" + "8932857241" + "1886684186" + "2095882212" + "7736052319" + "0513214100" + "9837113941" + "5535441504" + "6350518702" + "5831217238";

            assertEquals('1', solution.recurringChar(str));
        }

    /**
     * Within these numbers, 4 appears the most.
     */
    @Test
        public void mostCommonCharacterTest2() {
            String str = "3585922463" + "4564881449" + "9744344742" + "8950706750" + "4316600461" + "9728760400" + "7599995873" + "0552858863" + "6107666584" + "8137602552";

            assertEquals('4', solution.recurringChar(str));
        }

    /**
     * With these numbers, 7 appears the most.
     */
    @Test
        public void mostCommonCharacterTest3() {
            String str = "4846380793" + "4193747220n" + "9075367490" + "1180082954" + "2190728751" + "7748973893" + "1981988622n" + "5637648056" + "8515013697" + "4592237105";

            assertEquals('7', solution.recurringChar(str));
        }

    /**
     * Within these numbers, 6 appears the most.
     */
    @Test
        public void mostCommonCharacterTest4() {
            String str = "2276666678274" + "46085766663499" + "60053968666671" + "08912666667263" + "9188951666383" + "0463711695" + "8940121428" + "6030148532" + "1579113887" + "7221199733";

            assertEquals('6', solution.recurringChar(str));
        }

    /**
     * Within these numbers, 5 appears the most.
     */
        @Test
        public void mostCommonCharacterTest5() {
            String str = "5555003196532" + "8932855557241" + "18866841555586" + "20955588552212" + "7736052555319" + "0513214105550" + "983711355941" + "5535441504" + "6350518702" + "5831217238";

            assertEquals('5', solution.recurringChar(str));
        }

    /**
     * Within this string, n appears the most.
     */
        @Test
        public void mostCommonCharacterTest6() {
            String str = "nnpppppplldfdfmnnnnnnnnn";
            assertEquals('n', solution.recurringChar(str));
        }

}
