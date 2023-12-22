public class ImplementStacksUsingQueues {

    public static void main ( String [] args ) {

        System.out.println(test1());

        System.out.println(test2());

    }
    static boolean test1 () {

        MyStack myStack = new MyStack();

        myStack.push(1);

        myStack.pop();

        return myStack.empty();

    }

    static int test2 () {

        MyStack myStack = new MyStack();

        myStack.push(1);
        myStack.push(2);

        myStack.pop();

        return myStack.top();

    }

}