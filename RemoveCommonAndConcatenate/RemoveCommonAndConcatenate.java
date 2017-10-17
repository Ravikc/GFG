import java.util.*;

public class RemoveCommonAndConcatenate {
   

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        for(int c = 0; c < testCases; c++) {
            
            String string1 = scanner.nextLine();
            String string2 = scanner.nextLine();
            StringBuilder sb = new StringBuilder();

            Hashtable<Character, Integer> hashTable = new Hashtable<Character, Integer>();
            for(char alphabet : string2.toCharArray()) {
                if(!hashTable.containsKey(alphabet)) hashTable.put(alphabet, 1);                
            }

            for(char alphabet : string1.toCharArray()) {
                if(!hashTable.containsKey(alphabet)) sb.append(alphabet);
                else hashTable.put(alphabet, -1);                
            }   

            for(char ch : string2.toCharArray()) if(hashTable.get(ch) != -1) sb.append(ch);      
        
            String print = sb.toString();
            if(print.equals("")) print = "-1";
            System.out.println(print);
            
        }

        scanner.close();
    }
}

