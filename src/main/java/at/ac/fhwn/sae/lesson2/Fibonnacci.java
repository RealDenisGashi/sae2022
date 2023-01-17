package at.ac.fhwn.sae.lesson2;
import java.util.Scanner;

public class Fibonnacci {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Welche Fibonnacci-Stelle soll berechnet werden?");
        String InputGetFib = in.next();
        int getFib = Integer.parseInt(InputGetFib);
        long fibonacciNumberRecursive = getFibRecursive(getFib);
        long fibonacciNumberIterative = getFibIterative(getFib);
        System.out.println("Der Wert für die " + (getFib) + "-te Stelle beträgt (rekursiv): " + (fibonacciNumberRecursive));
        System.out.println("Der Wert für die " + (getFib) + "-te Stelle beträgt (iterativ): " + (fibonacciNumberIterative));

    }


    /**
     * Iterative Berechnung der Fibonnacci-Zahl füd die n-te Stelle.
     * Datentyp long
     * @param n --> an welcher Stelle die Fibonnacci-Zahl berechnet werden soll
     * @return Die Fibonnacci-Zahl an der gewünschten Stelle
     */
    public static long getFibIterative(int n){
        long number1 = 1;
        long number2 = 1;
        if (n==0)
            return 0;
        for (int i = 1; i<n; i++){
            long number3 = number2;
            number2 = number2 + number1;
            number1 = number3;
        }
        return number1;
    }

    /**
     * Rekursive Berechnung der Fibonnaci-Zahl für die n-te Stelle.
     * Datentyp long
     * @param n --> an welcher Stelle die Fibonacci-Zahl berechnet werden soll
     * @return Die Fibonacci-Zahl an der gewünschten Stelle
     */
    public static long getFibRecursive(int n){
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return getFibRecursive(n - 1) + getFibRecursive(n - 2);
    }
}
