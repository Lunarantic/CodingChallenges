package codility.motorola;

public class AsciiArt {

    public static void printL(int N) {
        for (int i = 1; i < N; ++i)
            System.out.println('L');
            
        for (int i = 0; i < N; ++i)
            System.out.print('L');
        
        System.out.println();
    }

}
