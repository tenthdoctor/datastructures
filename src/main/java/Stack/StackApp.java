package chap04.Stack;

/**
 * Created by user on 19.01.2015.
 */
public class StackApp {
    public static void main(String[] args) {
        StackXLong theStack = new StackXLong(10);  // make new stack
        theStack.push(20);               // push items onto stack
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);

        while( !theStack.isEmpty() ) {     // until it's empty,
                                           // delete item from stack
            long value = theStack.pop();
            System.out.print(value);      // display it
            System.out.print(" ");
        }  // end while
        System.out.println("");
    }  // end main()
}
