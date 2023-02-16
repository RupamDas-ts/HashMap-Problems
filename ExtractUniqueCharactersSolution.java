package HashMapCodes;

import java.util.HashMap;

public class ExtractUniqueCharactersSolution {
    public static String uniqueChar(String str){
       String newString = "";
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(int i = 0; i<str.length(); i++){
            if(!hashMap.containsKey(str.charAt(i))){
                newString = newString+str.charAt(i);
                hashMap.put(str.charAt(i),1);
            }
        }
        return newString;
    }
}
