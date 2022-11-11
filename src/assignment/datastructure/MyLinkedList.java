//Group Assignment
/*
- BYUKUSENGE NADINE FIONA    221001529
- NIYOMUKESHA FORELENCE      221001588
- INGABIRE IRADUKUNDA DELPHINE 221001060
- NYIRAMBARUSHIMANA CONSTANTINE 221004566
*/

package assignment.datastructure;

public class MyLinkedList {

    class Node {

        int data;
        Node next;

        public Node() {
            next = null;
        }

        public Node(int a) {
            data = a;
            next = null;
        }
    }
    Node head;
    Node tail;
    int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public MyLinkedList(int a) {
        Node newNode = new Node(a);
        head = newNode;
        tail = newNode;
        size = 1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;

    }

    public void insertAtfront(int a) {
        Node newNode = new Node(a);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;

        } else {
            newNode.next = head;
            head = newNode;

        }
        size++;
    }

    public void insertAtBack(int a) {
        Node newNode = new Node(a);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;

    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + ", ");
            current = current.next;
        }
        System.out.println(' ');

    }

    public MyLinkedList concat(MyLinkedList anotherList) {
        MyLinkedList result = new MyLinkedList();
        this.tail.next = anotherList.head;
        result.tail = anotherList.tail;
        result.tail.next=null;
        return result;
    }

    public static boolean isSorted(MyLinkedList list) {
        boolean result = false;
        Node currentNode = list.head;
        while (currentNode.next != null) {
            if (currentNode.data > currentNode.next.data) {
                return result;
            }
            currentNode = currentNode.next;
        }
        result = true;
        return result;
    }

    public static MyLinkedList mergeLinkedList(MyLinkedList listOne, MyLinkedList listTwo) {
        MyLinkedList result = new MyLinkedList();
        if (!isSorted(listOne)) {
            return null;
        }
        if (!isSorted(listTwo)) {
            return null;
        }
        Node currentOne, currentTwo, resultNode;
        if (listOne.head.data < listTwo.head.data) {
            result.head = listOne.head;
            currentOne = listOne.head.next;
            currentTwo = listTwo.head;
        } else {
            result.head = listTwo.head;
            currentTwo = listTwo.head.next;
            currentOne = listOne.head;
        }
        resultNode = result.head;
        while (currentOne != null || currentTwo != null) {
          
            if (currentOne == null) {
                resultNode.next=currentTwo;
                resultNode = currentTwo;
                currentTwo = currentTwo.next;
            } else if (currentTwo == null) {
                resultNode.next=currentOne;
                resultNode = currentOne;
                currentOne = currentOne.next;

            } else if (currentOne.data < currentTwo.data) {
                resultNode.next = currentOne;
                resultNode=currentOne;
                currentOne = currentOne.next;
            }
            else{
                resultNode.next=currentTwo;
                resultNode=currentTwo;
                currentTwo=currentTwo.next;
            }
            
        }
        
        result.tail=resultNode;
        resultNode.next=null;
        return result;

    }

    public static void main(String args[]) {
        MyLinkedList list1 = new MyLinkedList();
        list1.insertAtfront(1);
        list1.insertAtBack(9);
        list1.insertAtBack(10);
        list1.insertAtBack(19);
        list1.insertAtfront(-1);
        
        System.out.println("List one sorted:" + isSorted(list1));
        list1.print();
        MyLinkedList list2 = new MyLinkedList();
        list2.insertAtfront(5);
        list2.insertAtBack(6);
        list2.insertAtBack(7);
        list2.insertAtBack(11);
        MyLinkedList list3 = new MyLinkedList();
        list3.insertAtfront(5);
        list3.insertAtBack(6);
        list3.insertAtBack(7);
        list3.insertAtBack(11);
        
        
        System.out.println("List two sorted:" + isSorted(list2));
        list2.print();
        
        MyLinkedList listMerged=mergeLinkedList(list1, list2);
        System.out.println("MergedList");
        listMerged.print();
        System.out.println("Concatened list.");
        listMerged.concat(list3);
        listMerged.print();

    }
}
