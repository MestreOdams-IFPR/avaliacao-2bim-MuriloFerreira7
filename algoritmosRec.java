import java.util.Scanner;

public class algoritmosRec {
    final static Scanner LER = new Scanner(System.in);
    public static void main(String[] args) {
        // System.out.println(tribonacci(LER.nextInt()));
        System.out.println(pell(LER.nextInt()));    
        // int[] nsei = {1, 2, 3, 4, 5, 6, 7, 8};
        // metodoRec02(nsei, 0, 7);
    }

    public static int pell(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return 2*pell(n-1)+pell(n-2);
    }

    public static int tribonacci(int n) {
        if (n == 1 || n == 0) {
            return 0;
        } else if(n == 2) {
            return 1;
        }
        return tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);
    }

    public static void metodoRec02(
            int v[], int e, int d) {
        int t;
        if (e >= d)
            return;
        else {
            t = v[e];
            v[e] = v[d];
            v[d] = t;
            metodoRec02(v, e + 1, d - 1);
        }
    }
}
