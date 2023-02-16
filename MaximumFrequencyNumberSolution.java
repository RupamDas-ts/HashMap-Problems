package HashMapCodes;
import java.util.*;
public class MaximumFrequencyNumberSolution {
    public static int maxFrequencyNumber(int[] arr){
        if(arr.length == 0){
            return 0;
        }
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i=0; i< arr.length; i++){
            if(hashMap.containsKey(arr[i])){
                hashMap.put(arr[i],hashMap.get(arr[i])+1 );
                //hashMap.replace(arr[i],hashMap.get(arr[i])+1);
            }else{
                hashMap.put(arr[i],1);
            }
        }
        int maxFreq = 0;
        int maxFreqNum = arr[0];
        for(int i : hashMap.keySet()){
            if(hashMap.get(i) > maxFreq){
                maxFreq = hashMap.get(i);
                maxFreqNum = i;
            }
        }

        return maxFreqNum;
    }
}
