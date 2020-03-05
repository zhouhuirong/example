package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Solution {
    @Test
    public void test(){
        int[] nums = {311,3,30,34,5,9};
        String s = largestNumber(nums);
        System.out.println(s);
    }

    public String largestNumber(int[] nums){
        int length = nums.length;
        String[] str = new String[length];
        for (int i=0; i<length; i++){
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str,(o1,o2) ->(o2+o1).compareTo(o1+o2));
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<length; i++){
            sb.append(str[i]);
        }
        return sb.toString();
    }

    private static int sum(List<Integer> arr, int n) {
        if(n == 1) {
            return arr.get(0);
        }else {
            return arr.get(n-1) + sum(arr, --n);
        }
    }

    private static List sub(int []arr,int i, int j){
        int[] a = new int[10];
        List<int[]> ints = Arrays.asList(arr);
        List<int[]> ints1 = ints.subList(i, j);
        return ints1;
    }
}
