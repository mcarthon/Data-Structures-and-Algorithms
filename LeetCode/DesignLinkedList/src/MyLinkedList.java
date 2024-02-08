public class MyLinkedList {

    public static void main ( String [] args ) {

        MyLinkedList mll = new MyLinkedList ();

        mll.addAtHead ( 1 );

        mll.addAtTail ( 3 );

        mll.addAtIndex ( 1, 2 );

        mll.get ( 1 );

        mll.deleteAtIndex ( 1 );

        mll.get ( 1 );

        mll.get ( 3 );

        mll.deleteAtIndex ( 3 );

        mll.deleteAtIndex ( 0 );

        mll.get ( 0 );

        mll.deleteAtIndex ( 0 );

        mll.get ( 0 );

    }

    int val;

    int size;

    MyLinkedList head;

    MyLinkedList next;


    public MyLinkedList () {

        this.size = 0;

        this.head = new MyLinkedList ( 0 );

    }

    public MyLinkedList ( int val ) {

        this.val = val;

    }

    public MyLinkedList ( int val, MyLinkedList next ) {

        this.val = val;

        this.next = next;

    }

    // int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
    public int get ( int index ) {

        if ( index < 0 || index >= size || size == 0 || this.head == null ) {

            return -1;

        }

        MyLinkedList runner = this.head;

        int count = 0;

        while ( count < index ) {

            runner = runner.next;

            count ++;

        }

        return runner.val;

    }

    // void addAtHead(int val) Add a node of value val before the first element of the linked list.
    // After the insertion, the new node will be the first node of the linked list.
    public void addAtHead ( int val ) {

        MyLinkedList newHead = new MyLinkedList ( val );

        if ( this.size != 0 ) {

            newHead.next = this.head;

        }

        this.head = newHead;

        this.size ++;

    }

    // void addAtTail(int val) Append a node of value val as the last element of the linked list.
    public void addAtTail ( int val ) {

        if ( this.size == 0 ) {

            this.addAtHead ( val );

            return;

        }

        MyLinkedList runner = this.head;

        while ( runner.next != null ) {

            runner = runner.next;

        }

        MyLinkedList newTail = new MyLinkedList ( val );

        runner.next = newTail;

        this.size ++;

    }

    // void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list.
    // If index equals the length of the linked list, the node will be appended to the end of the linked list.
    // If index is greater than the length, the node will not be inserted.
    public void addAtIndex ( int index, int val ) {

        if ( index < 0 || index > this.size ) {

            return;

        }

        if ( index == this.size ) {

            this.addAtTail ( val );

            return;

        }

        if ( index == 0 ) {

            this.addAtHead ( val );

            return;

        }

        int count = 0;

        MyLinkedList runner = this.head;

        MyLinkedList previous = null;

        while ( count < index ) {

            previous = runner;

            runner = runner.next;

            count ++;

        }

        MyLinkedList newNode = new MyLinkedList ( val, runner );

        previous.next = newNode;

        this.size ++;

    }

    // void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
    public void deleteAtIndex ( int index ) {

        if ( index < 0 || index >= this.size ) {

            return;

        }

        if ( index == 0 ) {

            MyLinkedList newHead = this.head.next;

            this.head = newHead;

            return;

        }

        int count = 0;

        MyLinkedList previous = null;

        MyLinkedList runner = this.head;

        while ( count < index ) {

            previous = runner;

            runner = runner.next;

            count ++;

        }

        previous.next = runner.next;

        runner.next = null;

        this.size --;

    }

}