    import java.util.*;

    public class BooleanString {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int testCases = scanner.nextInt();
            scanner.nextLine();
            for(int c = 0; c < testCases; c++) {
                String input = scanner.nextLine();
                LinkedList<Character> queue = new LinkedList<Character>();
                
                
                for(char ch : input.toCharArray()) queue.add(ch);
                int result = Character.getNumericValue(queue.removeFirst());
                while(!queue.isEmpty()) {                
                    Character operator = queue.removeFirst();
                    int operand = Character.getNumericValue(queue.removeFirst());
                    System.out.println("operands: " + result + " " + operand + " operator: " + operator);
                    switch(operator) {
                        case 'A': result = result & operand;
                            break;
                        case 'B': result = result | operand;
                            break;
                        case 'C': result = result ^ operand;
                            break;
                    }

                }
                System.out.println(result);

            }

            scanner.close();
        }
    }