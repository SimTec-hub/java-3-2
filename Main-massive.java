package geekbrain;

import java.util.Arrays;

import static java.lang.System.*;

public class Main {

    public static void main(String[] args) {
        int [] whole = {1, 2, 55, 6, 8, 0, 7, 0, 7, 8, 9, 77};
        int [] exmpl = {1, 1, 4, 4, 1 ,1};
        int [] exmpl3 = {1, 1, 1, 1, 1 ,1};
        int [] exmpl1 = {4, 4, 4, 4, 4 ,4, 4};
        int [] exmpl2 = {1, 1, 8, 8, 1 ,1, 3};

        System.out.println(Arrays.toString(cutafterfour(whole)));

        System.out.println(testdrive(exmpl));
    }

    private static boolean testdrive(int[] exmpl) {
        boolean one = false;
        boolean four = false;
        for (int i = 0; i < exmpl.length; i++) {

            if (exmpl[i] == 1) {one = true;}
            else if (exmpl[i] == 4) {four = true;}
            else if (exmpl[i] !=1 || exmpl[i] !=4) {
                throw new RuntimeException("В массиве нет 1 или 4!");
            }
        }
        return one && four;

    }

    private static int[] cutafterfour (int [] whole) {
        int index = -1 ;
        for (int i = 0; i < whole.length; i++) {
            if (whole[i] == 4)
                index = i;
        }
        if (index < 0) {
            new RuntimeException("Error!!!");
        }
        int[] afterfour = Arrays.copyOfRange(whole, index+1, whole.length);
        //System.out.println(Arrays.toString(afterfour));
        return afterfour;

    }
}
