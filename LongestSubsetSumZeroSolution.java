package HashMapCodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LongestSubsetSumZeroSolution {
    public static int lengthOfLongestSubsetWithZeroSum(int arr[]) {
        // Write your code here
        if(arr.length == 0){
            return 0;
        }
        //This code doesn't work for duplicate elements.
//        int maxLength = 0;
//        int sum = 0;
//        HashMap<Integer, Integer> hashMap = new HashMap<>(); //hashMap<sum,index>
//        for (int i = 0; i < arr.length; i++){
//            sum = sum + arr[i];
//            if(hashMap.containsKey(sum)){
//                maxLength = Math.max(maxLength, i - hashMap.get(sum));
//            }else{
//                hashMap.put(sum,i);
//            }
//        }
//        return maxLength;
        int maxLength = 0, sum = 0;
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>(); //map<sum, list of index>
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        hashMap.put(0, list); //taking care of first two element sum
        for(int i = 0; i<arr.length; i++){
            sum = arr[i]+sum;
            if(hashMap.containsKey(sum)){
                List<Integer> prevIndices = hashMap.get(sum);
                for(int j : prevIndices){
                    maxLength = Math.max(maxLength, i-j);
                }
                prevIndices.add(i);
                hashMap.put(sum, prevIndices);
            }else {
                List<Integer> newList = new ArrayList<>();
                newList.add(i);
                hashMap.put(sum,newList);
            }
        }
        return maxLength;
    }
}
