//add header

public class MyDeque<E> implements DequeInterface<E> {

  Object[] data;
  int size;
  int rear;
  int front;

  public MyDeque(int initialCapacity){
    if(initialCapacity < 0){
      throw new IllegalArgumentException();
    }
    data = new Object[initialCapacity];
    rear = 0;
    front = 0;
    size = 0;

  }

  /**
   * Returns the number of elements in this DequeInterface.
   * PRECONDITION: none
   * POSTCONDITION: the DequeInterface is unchanged.
   * @return the number of elements in this DequeInterface
   */
  public int size(){
    return size;
  }

  /**
   * Doubles the capacity of this DequeInterface.
   * PRECONDITION: none
   * POSTCONDITION: the DequeInterface's capacity is now doubled and
   * maintains the same elements. No elements have changed. If the capacity
   * is 0, set capacity to some default capacity.
   */
  public void expandCapacity(){
    int newCap;
    if(data.length == 0){newCap = 10;}
    else{newCap = data.length*2;}
    Object[] newArr = new Object[newCap];

    if(front < rear){
      for(int i = front; i <= rear; i++){
        newArr[i] = data[i];
      }
    }
    else if(front > rear){
      for(int i = front; i < data.length; i++){
        newArr[newCap-(data.length-i)] = data[i]; //add the back half
      }
      for(int j = 0; j <= rear; j++){ // add the front half
        newArr[j] = data[j];
      }
    }
    else if(front == rear){}

    this.data = newArr;
  }

  /**
   * Adds the specified element to the front of this DequeInterface.
   * PRECONDITION: none
   * POSTCONDITION: if the MyDeque is at capacity, expandCapacity is called
   * to double the size of this container. The element is now the front
   * element in this DequeInterface, none of the other elements have been
   * changed, and the size is increased by 1.
   * @param element the element to add to the front of the array
   * @throws NullPointerException if the specified element is null.
   */
  public void addFirst(E element){
    if(element == null){
      throw new NullPointerException();
    }

    if(size == data.length){
      this.expandCapacity();
    }
    if(size == 0){}
    else if(front == 0){
      front = data.length - 1;
    }
    else{
      front--;
    }
    data[front] = element;
    size++;
  }

  /**
   * Adds the specified element to the back of this DequeInterface.
   * PRECONDITION: none
   * POSTCONDITION: if the MyDeque is at capacity, expandCapacity is called
   * to double the size of this container. The element is now the back element
   * in this DequeInterface, none of the other elements have been changed, and
   * the size is increased by 1.
   * @param element the element to add to the back of the attay
   * @throws NullPointerException if the specified element is null.
   */
  public void addLast(E element){
    if(element == null){
      throw new NullPointerException();
    }

    if(size == data.length){
      this.expandCapacity();
    }
    if(size == 0){}
    else if(rear == data.length - 1){
      rear = 0;
    }
    else{
      rear++;
    }
    data[rear] = element;
    size++;
  }


  /**
   * Removes the element at the front of this DequeInterface.
   * Returns the element removed, or null if there was no such element.
   * PRECONDITION: the DequeInterface's size is greater than zero.
   * POSTCONDITION: the front element in this DequeInterface has been removed,
   * none of the other elements have been changed, and
   * the size is decreased by 1.
   * @return  the element removed, or null if the size was zero.
   */
  @SuppressWarnings("unchecked")
  public E removeFirst(){
    if(size == 0){
      return null;
    }
    E ans = (E)data[front];
    data[front] = null;
    if(front == data.length - 1){
      front = 0;
    }
    else{
      front++;
    }
    size--;
    return ans;
  }

  /**
   * Removes the element at the back of this DequeInterface.
   * Returns the element removed, or null if there was no such element.
   * PRECONDITION: the DequeInterface's size is greater than zero.
   * POSTCONDITION: the back element in this DequeInterface has been removed,
   * none of the other elements have been changed, and
   * the size is decreased by 1.
   * @return  the element removed, or null if the size was zero.
   */
  @SuppressWarnings("unchecked")
  public E removeLast(){
    if(size == 0){
      return null;
    }
    E ans = (E)data[rear];
    data[rear] = null;
    if(rear == 0){
      rear = data.length - 1;
    }
    else{
      rear--;
    }
    size--;
    return ans;
  }

  /**
   * Returns the element at the front of this DequeInterface,
   * or null if there was no such element.
   * PRECONDITION: the DequeInterface's size is greater than zero.
   * POSTCONDITION: The DequeInterface is unchanged.
   * @return  the element at the front, or null if the size was zero.
   */
  @SuppressWarnings("unchecked")
  public E peekFirst(){
    return (E)data[front];
  }

  /**
   * Returns the element at the back of this DequeInterface,
   * or null if there was no such element.
   * PRECONDITION: the DequeInterface's size is greater than zero.
   * POSTCONDITION: The DequeInterface is unchanged.
   * @return  the element at the back, or null if the size was zero.
   */
  @SuppressWarnings("unchecked")
  public E peekLast(){
    return (E)data[rear];
  }
}
