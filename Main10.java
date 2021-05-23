package geekbrain;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        changeelement(arr);
        changearr(arr);
    }


    private static ArrayList<Integer> changearr(int... arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    private static void changeelement(int... arr) {
        int e1 = (int) (Math.random() * arr.length);
        int e2 = (int) (Math.random() * arr.length);
        int x = arr[e1];
        arr[e1] = arr[e2];
        arr[e2] = x;
    }

}