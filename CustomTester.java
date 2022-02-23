/**
 * TODO: Add your file header
 * Name:
 * ID:
 * Email:
 * Sources used: Put "None" if you did not have any external help
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 *
 * 2-4 sentence file description here
 */

import org.junit.*;
import static org.junit.Assert.*;

/**
 * TODO: Add your class header
 *
 * IMPORTANT: Do not change the method names and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class CustomTester {
    // ----------------MyDeque class----------------
    private MyDeque<Integer> deque;

    @Before
    public void setUp(){
      
    }
    /**
     * Test the constructor when [initial capacity is negative]
     */
    @Test
    public void testMyDequeConstructor() {
      try{
        deque = new MyDeque<>(-2);
        fail();
      } catch(IllegalArgumentException e) {}
    }

    /**
     * Test the expandCapacity method when [initial capacity is 0]
     */
    @Test
    public void testMyDequeExpandCapacity() {

    }

    /**
     * Test the addFirst method when [the capacity needs to be expanded]
     */
    @Test
    public void testAddFirst() {

    }

    /**
     * Test the addLast method when [rear is at the last index of the data
      array]
     */
    @Test
    public void testAddLast() {

    }

    /**
     * Test the removeFirst method when [front is at the last index]
     */
    @Test
    public void testRemoveFirst() {

    }

    /**
     * Test the removeLast method when [rear is at the start of the index]
     */
    @Test
    public void testRemoveLast() {

    }

    /**
     * Test the peekFirst method when [nothing has been added to the deque]
     */
    @Test
    public void testPeekFirst(){

    }

    /**
     * Test the peekLast method when [nothing has been added to the deque]
     */
    @Test
    public void testPeekLast(){

    }

    // ----------------MyStack class----------------
    /**
     * Test MyStack when [trying to push onto a stack at capacity]
     */
    @Test
    public void testMyStack(){
        // You can test any method from MyStack or a combination of methods
    }

    // ----------------MyQueue class----------------
    /**
     * Test MyQueue when [trying to enqueue into a queue at capacity]
     */
    @Test
    public void testMyQueue(){
        // You can test any method from MyQueue or a combination of methods
    }
}
