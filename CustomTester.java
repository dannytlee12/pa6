/**
 * TODO: Add your file header
 * Name: Danny Lee
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
    private MyDeque<Integer> deque1;

    @Before
    public void setUp(){
      deque1 = new MyDeque<>(3);
    }
    /**
     * Test the constructor when [initial capacity is negative]
     */
    @Test
    public void testMyDequeConstructor() {
      try{
        deque1 = new MyDeque<>(-2);
        fail();
      } catch(IllegalArgumentException e) {}
    }

    /**
     * Test the expandCapacity method when [initial capacity is 0]
     */
    @Test
    public void testMyDequeExpandCapacity() {
      deque1 = new MyDeque<>(0);
      deque1.expandCapacity();
      assertEquals("new capacity should be 10", 10, deque1.data.length);
    }

    /**
     * Test the addFirst method when [the capacity needs to be expanded]
     */
    @Test
    public void testAddFirst() {
      deque1.addFirst(0);
      deque1.addLast(1);
      deque1.addLast(2);
      deque1.addLast(3);
      for(int i = 0; i < 4; i++){
        assertEquals("data should be 1,2,3,4,null,null", i, deque1.data[i]);
      }
      assertEquals("capacity should be doubled to six", 6, deque1.data.length);
    }

    /**
     * Test the addLast method when [rear is at the last index of the data
      array]
     */
    @Test
    public void testAddLast() {
      deque1.addFirst(0);
      deque1.addLast(1);
      deque1.addLast(2);
      deque1.removeFirst();
      deque1.addLast(3);
      assertEquals("deque1.data should be 3,1,2", 3, deque1.data[0]);
      assertEquals("deque1.data should be 3,1,2", 1, deque1.data[1]);
      assertEquals("deque1.data should be 3,1,2", 2, deque1.data[2]);
      assertEquals("deque1.front should be 1", 1, deque1.front);
      assertEquals("deque1.rear should be 3", 3, deque1.rear);
    }

    /**
     * Test the removeFirst method when [front is at the last index]
     */
    @Test
    public void testRemoveFirst() {
      deque1.addFirst(1);
      deque1.addFirst(0);
      assertEquals("deque1.data should be 1,null,0", 1, deque1.data[0]);
      assertEquals("deque1.data should be 1,null,0", 0, deque1.data[2]);
      deque1.removeFirst();
      assertEquals("deque1.front should be 0", 0, deque1.front);
      assertEquals("deque1.data should be 1,null,null", null, deque1.data[2]);
      assertEquals("deque1.data should be 1,null,null", 1, deque1.data[0]);

    }

    /**
     * Test the removeLast method when [rear is at 0]
     */
    @Test
    public void testRemoveLast() {
      deque1.addFirst(0);
      deque1.addFirst(2);
      deque1.addFirst(1);
      deque1.removeLast();
      assertEquals("deque1.data should be null,1,2", 1, deque1.data[1]);
      assertEquals("deque1.data should be null,1,2", 2, deque1.data[2]);
      assertEquals("deque1.rear should be 2", 2, deque1.rear);
      assertEquals("deque1.front should be 1", 1, deque1.front);
    }

    /**
     * Test the peekFirst method when [nothing has been added to the deque]
     */
    @Test
    public void testPeekFirst(){
      assertEquals("null should be returned", null, deque1.peekFirst());

    }

    /**
     * Test the peekLast method when [nothing has been added to the deque]
     */
    @Test
    public void testPeekLast(){
      assertEquals("null should be returned", null, deque1.peekLast());
    }

    // ----------------MyStack class----------------
    /**
     * Test MyStack when [trying to push onto a stack at capacity]
     */
    @Test
    public void testMyStack(){
        // You can test any method from MyStack or a combination of methods
        MyStack<Integer> stack1 = new MyStack<>(3);
        stack1.push(0);
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        assertEquals("new capacity should be 6", 6,stack1.theStack.data.length);
        //elements should pop in order 3,2,1,0
        for(int i = 3; i <= 0; i--){
          assertEquals(i, stack1.pop());
        }
    }

    // ----------------MyQueue class----------------
    /**
     * Test MyQueue when [trying to enqueue into a queue at capacity]
     */
    @Test
    public void testMyQueue(){
        // You can test any method from MyQueue or a combination of methods
        MyQueue<Integer> queue1 = new MyQueue<>(3);
        queue1.enqueue(0);
        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);
        assertEquals("new capacity should be 6", 6,queue1.theQueue.data.length);
        //elements should dequeue in order 0,1,2,3
        for(int i = 0; i < 4; i++){
          assertEquals(i, queue1.dequeue());
        }

    }
}
