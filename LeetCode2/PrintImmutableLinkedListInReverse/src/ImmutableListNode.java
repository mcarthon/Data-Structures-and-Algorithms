public class ImmutableListNode {

    ImmutableListNode next;

    int value;

    ImmutableListNode () {};

    ImmutableListNode ( int value ) {

        this.value = value;

    }

    ImmutableListNode ( int value, ImmutableListNode next ) {

        this.value = value;

        this.next = next;

    }

    public ImmutableListNode getNext () {

        return this.next;

    }

    public void printValue () {

        System.out.println ( this.value );

    }

}
