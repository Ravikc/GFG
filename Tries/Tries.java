import java.util.*;

public class Tries {
    private class Node {
        public char data;
        public boolean isLast;
        public Hashtable<Character, Node> children;
        
        public Node(char data, boolean isLast) {
            this.data = data;
            this.isLast = isLast;          
            children = new Hashtable<Character, Node>();
        }
    }

    private Node root;
    public Tries() {
        root = new Node(' ', true);
    }

    public void Insert(String word) {
        Node tempNode = root;        
        for(int i = 0; i < word.length(); i++) {   
            char c = word.charAt(i);         
            if(!tempNode.children.containsKey(c)) {                
                Node newNode = new Node(c, i == word.length() - 1);
                tempNode.children.put(c, newNode);
            }
            tempNode = tempNode.children.get(c);
        }
    }

    public boolean isMember(String word) {
        Node tempNode = root;
        for(char c : word.toCharArray()) {            
            if(!tempNode.children.containsKey(c)) return false;
            tempNode = tempNode.children.get(c);            
        }
        return tempNode.isLast == true;
    }

    private void getSuggestions(String prefix, String currentString, Node currentNode, HashSet<String> set) {
        if(currentNode.isLast) set.add(prefix + currentString);
        Enumeration<Character> keys = currentNode.children.keys();
        while(keys.hasMoreElements()) {
            Character key = keys.nextElement();
            System.out.println("The key is : " + key);
            currentNode = currentNode.children.get(key);            
            currentString += currentNode.data;                       
            getSuggestions(prefix, currentString, currentNode, set);
            currentString = currentString.substring(0, currentString.length());
        }
    }

    public void getSuggestions(String prefix) {
        Node tempNode = root;
        for(char c : prefix.toCharArray()) {
            if(!tempNode.children.containsKey(c)) return;
            tempNode = tempNode.children.get(c);
        }
        //We have reached the node up to which the value is given by the user, now find all the suggestions.  
        HashSet<String> set = new HashSet<String>();     
        getSuggestions(prefix, "", tempNode, set);
        String[] array = set.toArray(new String[set.size()]);
        Arrays.sort(array);
        for(String str : array) System.out.println(str);
    }

    public static void main(String[] args) {
        Tries t = new Tries();
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        for(int c = 0; c < T; c++) {
            int N = Integer.parseInt(scanner.nextLine());
            String[] words = scanner.nextLine().split(" ");
            for(String word : words) {
                t.Insert(word);
                System.out.println("inserting: " + word);
            } 
            String query = scanner.nextLine();
            t.getSuggestions(query);
        }        
    }
}