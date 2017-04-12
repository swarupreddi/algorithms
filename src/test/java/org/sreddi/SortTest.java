package org.sreddi;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by swarup on 4/12/17.
 */
public class SortTest {

    private void checkSorted(int[] nums) {
        Sort.quickSort(nums, 0, nums.length-1);
        for (int i = 0; i < nums.length-1; i++) {
            assertTrue(nums[i] <= nums[i+1]);
        }
    }

    @Test
    public void quickSort() throws Exception {
        int[] nums0  = new int[]{0,3,4,2,1};
        checkSorted(nums0);

        int[] nums1  = new int[]{1,2,3,4,5};
        checkSorted(nums1);

        int[] nums2  = new int[0];
        checkSorted(nums2);
    }

}