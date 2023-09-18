package arrayListCollection;

import java.util.Arrays;
import java.util.List;

/**
 * The MyArrayListQuickSort class is designed to create an object - quick sort.
 * @author Ivan Makhorin.
 */

public class MyArrayListQuickSort {

    /**
     * QuickSort method to describe sorting logic for later use.
     */
    public static void quickSort(Integer[] array, int low, int high) {
        if (array.length == 0)
            return;
        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        int opora = array[middle];

        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }
            while (array[j] > opora) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }

    /**
     * The main method was created to create a
     * new object with the new command and
     * obtain a dynamic collection of the form ArrayList
     * to apply quick sorting of the elements contained in it.
     */

    public static void main(String[] args) {
        List<Integer> list = new MyArrayList<>();

        list.add(9);
        list.add(5);
        list.add(6);
        list.add(1);
        list.add(3);

        Integer[] list2 = list.toArray(new Integer[0]);
        System.out.println(Arrays.toString(list2));

        int low = 0;
        int high = list2.length - 1;

        quickSort(list2, low, high);
        System.out.print("\nSorted: \n");
        System.out.println(Arrays.toString(list2));
    }
}