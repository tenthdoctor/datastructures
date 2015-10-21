package chap04.Queue;

/**
 * Created by Sergei Doroshenko on 19.01.2015.
 */
public class QueueO <T> {
    private int maxSize;
    private T[] queArray;
    private int front;
    private int rear;
    private int nItems;
    //--------------------------------------------------------------
    public QueueO(int s) {         // constructor
        maxSize = s;
        queArray = (T[]) new Object[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }
    //--------------------------------------------------------------
    public void insert(T j) {      // put item at rear of queue
        if (isFull()) throw new RuntimeException("Queue is full!");

        if(rear == maxSize-1) { rear = -1; }   // deal with wraparound

        queArray[++rear] = j;                 // increment rear and insert
        nItems++;                            // one more item
    }
    //--------------------------------------------------------------
    public T remove() {             // take item from front of queue
        if (isEmpty()) throw new RuntimeException("Queue is empty.");

        T temp = queArray[front++];        // get value and incr front
        if(front == maxSize) { front = 0; }   // deal with wraparound
        nItems--;                             // one less item
        return temp;
    }
    //--------------------------------------------------------------
    public T peekFront() {          // peek at front of queue
        return queArray[front];
    }
    //--------------------------------------------------------------
    public boolean isEmpty() {         // true if queue is empty
        return (nItems == 0);
    }
    //--------------------------------------------------------------
    public boolean isFull() {         // true if queue is full
        return (nItems == maxSize);
    }
    //--------------------------------------------------------------
    public int size() {             // number of items in queue
        return nItems;
    }

    @Override
    public String toString() {
        String string = "-->{";              // start string

        int ind = front;                       // start from front index
        int itemsCount = 0;                    // output counter

        while (itemsCount < nItems) {              // true, while all item doesn't print
            string += queArray[ind].toString();    // add item to result string
            if (itemsCount < nItems - 1)
                string += ", ";                // add comma if item doesn't last one
            if (ind == maxSize -1) ind = -1;   // cyclic 'transfer'
            ind++;                             // increment index
            itemsCount++;                      // increment items counter
        }

        return string += "}"; // add last item and return string  --> queArray[rear] +
    }
}
