import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    Queue<Integer> queue = new LinkedList<Integer>();

    void push ( int x ) {

        queue.offer ( x );

        for ( int index = 1; index < queue.size(); ++ index ) {

            queue.offer ( queue.poll() );

        }

    }

    int pop () {

        return queue.poll();

    }

    int top () {

        return queue.peek();

    }

    boolean empty () {
        return queue.size() == 0;

    }

}