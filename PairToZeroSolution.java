package HashMapCodes;
import java.util.*;
public class PairToZeroSolution {
    public static int PairSum(int[] input, int size) {
        if (input.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int count = 0;
        for (int i : input) {
            int reqNum = 0 - i;
            if (hashMap.containsKey(reqNum)) {
                count = count + hashMap.get(reqNum);
            }
            if (!hashMap.containsKey(i)) {
                hashMap.put(i, 1);
            }else{
                hashMap.put(i, hashMap.get(i)+1);
            }
        }
        return count;
    }
}
