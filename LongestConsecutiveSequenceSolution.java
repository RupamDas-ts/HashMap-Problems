package HashMapCodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LongestConsecutiveSequenceSolution {
    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        if(arr.length == 0){
            return null;
        }
        if(arr.length == 1){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(arr[0]);
            return list;
        }
        int[] oldArr = arr;
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for(int i = 0; i<oldArr.length; i++){
            indexMap.put(oldArr[i],i);
        }
        Arrays.sort(arr);
        int maxLengthStart = arr[0];
        int prev = arr[0];
        List<Integer> nums = new ArrayList<>();
        nums.add(arr[0]);
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        hashMap.put(prev,nums);
        for(int i : arr){
            List<Integer> list = hashMap.get(prev);
            int len = list.size();
            int lastElement = list.get(len-1);
            if(lastElement == i-1){
                list.add(i);
                hashMap.put(prev,list);
                if(hashMap.get(maxLengthStart).size() < hashMap.get(prev).size()){
                    maxLengthStart = prev;
                }else if(hashMap.get(maxLengthStart).size() == hashMap.get(prev).size()){
                    if(indexMap.get(maxLengthStart) > indexMap.get(prev)){
                        maxLengthStart = prev;
                    }
                }
            }else{
                List<Integer> newList = new ArrayList<>();
                newList.add(i);
                hashMap.put(i,newList);
                if(hashMap.get(maxLengthStart).size() < hashMap.get(prev).size()){
                    maxLengthStart = prev;
                }else if(hashMap.get(maxLengthStart).size() == hashMap.get(prev).size()){
                    if(indexMap.get(maxLengthStart) > indexMap.get(prev)){
                        maxLengthStart = prev;
                    }
                }
                prev = i;
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(hashMap.get(maxLengthStart).get(0));
        arrayList.add(hashMap.get(maxLengthStart).get(hashMap.get(maxLengthStart).size()-1));
        return arrayList;
    }
}
