import java.util.LinkedList;

public class MyQueue {

    public LinkedList<Integer> stack = new LinkedList<Integer>();

    public void push  ( int x ) {

        stack.addLast ( x );

    }

    public int pop () {

        return stack.poll();

    }

    public int peek () {

        return stack.peek();

    }

    public boolean empty () {

        return stack.size() == 0;

    }

}