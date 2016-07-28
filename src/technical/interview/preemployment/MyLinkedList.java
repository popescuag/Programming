package technical.interview.preemployment;

public class MyLinkedList {
  private int value;
  private MyLinkedList tail;

  public MyLinkedList(int value, MyLinkedList tail) {
    this.value = value;
    this.tail = tail;
  }
  
  public MyLinkedList reverse() {
    MyLinkedList retList = new MyLinkedList(value, null);
    MyLinkedList currTail = tail;
    while (currTail != null) {
      retList = new MyLinkedList(currTail.value, retList);
      currTail = currTail.tail;
    }
    return retList;
  }
  
  public String toString() {
    String ret = "" + value + "-";
    MyLinkedList currElem = tail;
    if (tail == null) {
      ret += "|";
    } else {
      while (currElem != null) {
        ret += currElem.value + "-";
        currElem = currElem.tail;
        if (currElem == null) {
          ret += "|";
        }
      }
    }
    return ret;
  }
  
  public static void main(String[] args) {
    MyLinkedList mll9 = new MyLinkedList(9, null);
    MyLinkedList mll8 = new MyLinkedList(8, mll9);
    MyLinkedList mll7 = new MyLinkedList(7, mll8);
    MyLinkedList mll6 = new MyLinkedList(6, mll7);
    MyLinkedList mll5 = new MyLinkedList(5, mll6);
    System.out.println(mll5);
    System.out.println(mll5.reverse());
    System.out.println(mll5);
    System.out.println(mll9.reverse());
  }
}
