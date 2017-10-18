import java.util.*;

public class StringComparision {
    private static int compare(String str1, String str2, Hashtable<String, Integer> hash) {
        
        int index1 = 0, index2 = 0;
        while(index1 < str1.length() || index2 < str2.length()) {
            if(index1 >= str1.length()) return -1;
            if(index2 >= str2.length()) return 1;

            String ch1 = String.valueOf(str1.charAt(index1));
            String ch2 = String.valueOf(str2.charAt(index2));
            if(ch1.equals("n") && index1 + 1 < str1.length() && str1.charAt(index1 + 1) == 'g') {
                ch1 = "ng";
                index1++;
            } 
            if(ch2.equals("n") && index2 + 1 < str2.length() && str2.charAt(index2 + 1) == 'g') {
                ch2 = "ng";
                index2++;
            } 

            // System.out.println("ch1 " + ch1);
            // System.out.println("ch2 " + ch2);

            int hash1 = hash.get(ch1);
            int hash2 = hash.get(ch2);

            if(hash1 > hash2) return 1;
            if(hash2 > hash1) return -1;

            index1++;
            index2++;
        }


        // for(int i = 0; i < str1.length(); i++) {
        //     String ch1 = String.valueOf(str1.charAt(i));
        //     String ch2 = String.valueOf(str2.charAt(i));
        //     if(ch1.equals("n") && i + 1 < str1.length() && str1.charAt(i + 1) == 'g') {
        //         ch1 = "ng";
        //     } 
        //     if(ch2.equals("n") && i + 1 < str2.length() && str2.charAt(i + 1) == 'g') {
        //         ch1 = "ng";
        //     } 

        //     int hash1 = hash.get(ch1);
        //     int hash2 = hash.get(ch2);

        //     if(hash1 > hash2) return 1;
        //     if(hash2 > hash1) return -1;
        // }
        return 0;
    }

    public static void main(String[] args) {
        int priority = 0;
        Hashtable<String, Integer> hash = new Hashtable<String, Integer>();
        //a to n
        for(int i = 97; i <= 110; i++) {
            hash.put(Character.toString((char)i), priority++);
        }
        hash.put("ng", priority++);
        for(int i = 111; i <= 122; i++) {
            hash.put(Character.toString((char)i), priority++);
        }

        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < T; i++) {
            String[] line = scanner.nextLine().split(" ");
            String line1 = line[0];
            String line2 = line[1];
            System.out.println(compare(line1, line2, hash));
        }
        
    }
}