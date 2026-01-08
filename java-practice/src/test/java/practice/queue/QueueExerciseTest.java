package practice.queue;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Queue;

public class QueueExerciseTest {
    static Lab qe ;
    @BeforeAll
    public static void setUp(){
        qe = new Lab();
    }

    /**
     * When a Queue is instantiated, it should not be null.
     */
    @Test
    public void createQueueTest(){
        Queue<String> queue = qe.createQueue();
        if(queue == null){
            fail();
        }else{
            assertNotNull(queue);
        }
    }

    /**
     * When a Queue is instantiated, it should start with a size of 0.
     */
    @Test
    public void getSizeTest1(){
        Queue<String> queue = qe.createQueue();
         if(queue == null){
            fail();
        }else{
            assertEquals(0, qe.getSize(queue));
        }
    }

    /**
     * When an item is added to an empty queue, it should have a size of 1.
     */
    @Test
    public void addToQueueTest1(){
        Queue<String> queue = qe.createQueue();
        if(queue == null){
            fail();
        }else{
            qe.addToEndOfQueue(queue, "Jim");
            assertEquals(1, qe.getSize(queue));
        }
    }

    /**
     * When 3 items are added to an empty queue, it should have a size of 3.
     */
    @Test
    public void addToQueueTest2(){
        Queue<String> queue = qe.createQueue();
        if(queue == null){
            fail();
        }else{
            qe.addToEndOfQueue(queue, "Jim");
            qe.addToEndOfQueue(queue, "Sally");
            qe.addToEndOfQueue(queue, "Kate");
            assertEquals(3, qe.getSize(queue));
        }
    }

    /**
     * When Jim is the first item added to a Queue, Jim should also be the first item removed from the queue.
     * The size of the queue should also reflect the removed item.
     */
    @Test
    public void removeFromStartOfQueueTest1(){
        Queue<String> queue = qe.createQueue();
         if(queue == null){
            fail();
        }else{
            qe.addToEndOfQueue(queue, "Jim");
            qe.addToEndOfQueue(queue, "Sally");
            qe.addToEndOfQueue(queue, "Kate");
            String name = qe.removeFromStartOfQueue(queue);
            assertEquals("Jim", name);
            assertEquals(2, qe.getSize(queue));
        }
    }
    /**
     * If the values "Jim", "Sally", "Kate" are added to a queue, they should be removed in the order "Jim", "Sally",
     * "Kate". The size of the queue after all values have been removed should also be 0.
     */
    @Test
    public void removeFromStartOfQueueTest2(){
        Queue<String> queue = qe.createQueue();
         if(queue == null){
            fail();
        }else{
            qe.addToEndOfQueue(queue, "Jim");
            qe.addToEndOfQueue(queue, "Sally");
            qe.addToEndOfQueue(queue, "Kate");
            String name = qe.removeFromStartOfQueue(queue);
            assertEquals("Jim", name);
            name = qe.removeFromStartOfQueue(queue);
            assertEquals("Sally", name);
            name = qe.removeFromStartOfQueue(queue);
            assertEquals("Kate", name);
            assertEquals(0, qe.getSize(queue));
        }
    }
    /**
     * If the values "Jim", "Sally", "Kate" are added to a queue, the next value to be removed should be "Jim".
     * However, if the Queue method that retrieves a value but doesn't remove it is used, "Jim" could be retrieved
     * without affecting the size of the list.
     */
    @Test
    public void getStartOfQueueWithoutRemovingTest1(){
        Queue<String> queue = qe.createQueue();
        if(queue == null){
            fail();
        }else{
            qe.addToEndOfQueue(queue, "Jim");
            qe.addToEndOfQueue(queue, "Sally");
            qe.addToEndOfQueue(queue, "Kate");
            String name = qe.getStartOfQueueWithoutRemoving(queue);
            assertEquals("Jim", name);
            assertEquals(3, qe.getSize(queue));
        }
    }
}
