package HashMapCodes;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExtractUniqueCharacters {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String takeInput() throws IOException {
        String str = br.readLine();
        return str;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {


        String str = takeInput();
        System.out.print(ExtractUniqueCharactersSolution.uniqueChar(str));


    }
}
