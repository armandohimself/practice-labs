package practice.overriding;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DogTest {
    /**
     * Regular dogs should return "Woof".
     */
    @Test
    public void noiseTestDog(){
        Dog fido = new Dog();
        assertEquals("Woof", fido.sound());
    }

    /**
     * Create a new dog, but this is a more advanced implementation of Dog, which is Shiba, a subclass of Dog.
     * Shiba extends Dog, but it should override the sound() method to make any sound other than "Woof", such as
     * "Bark" or "Wow".
     */
    @Test
    public void noiseTestShiba(){
        Dog doge = new Shiba();
        assertNotEquals(doge.sound(), "Woof");
    }
}
