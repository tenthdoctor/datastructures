package chap04.Infix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by user on 19.01.2015.
 * Enter infix: A*(B+C)-D/(E+F)
 * Postfix is ABC+*DEF+/-
 *
 * Enter infix: 2+3*4
 * Postfix is 234*+
 */
public class InfixApp {
    public static void main(String[] args) throws IOException {
        String input, output;
        while(true) {
            System.out.print("Enter infix: ");
            System.out.flush();
            input = getString();         // read a string from kbd
            if( input.equals("") )       // quit if [Enter]
                break;
            // make a translator
            InToPost theTrans = new InToPost(input);
            output = theTrans.doTrans(); // do the translation
            System.out.println("Postfix is " + output + '\n');
        }  // end while
    }  // end main()

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
