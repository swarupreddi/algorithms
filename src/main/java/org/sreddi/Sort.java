package org.sreddi;

import java.util.List;

/**
 * Created by swarup on 4/12/17.
 */
public class Sort {

    private static void swap(int[] nums, int pos1, int pos2) {
        int tmp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = tmp;
    }

    public static void quickSort(int[] nums, int first, int last) {

        if (first < last) {

            // use the last number as the pivot
            // and reorder the numbers: less than, pivot, greater or equal
            int toPos = first;
            int pivot = nums[last];
            for (int i = first; i < last; i++) {
                if (nums[i] < pivot) {
                    swap(nums, i, toPos);
                    toPos++;
                }
            }

            // put the pivot in the middle and sort the two sub-arrays
            swap(nums, last, toPos);
            quickSort(nums, first, toPos-1);
            quickSort(nums, toPos+1, last);

        }
    }
}
