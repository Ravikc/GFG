public class DifficultyOfSentence {
    private static boolean isVowel(char character) {
        return character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u';
    }

    private static boolean isHard(String word) {
        int numberOfVowels, numberOfConsonants, consecutiveConsonants;
        for(Character c : word.toCharArray) {
            c = Character.toLowerCase(c);
            if(isVowel(c)) {
                numberOfVowels++;
                consecutiveConsonants = 0;
            }
            else {
                numberOfConsonants++;
                consecutiveConsonants++;
            }
        }

        return consecutiveConsonants == 4 || numberOfConsonants > numberOfVowels;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);        

        int testCases = Integer.parseInt(scanner.nextLine());
        for(int test = 0; test < testCases; test++) {
            int hardWords;
            String[] words = scanner.nextLine().split(" ");
            for(String word : words) {
                if(isHard(word)) hardWords++;
            }
            int result = (5 * hardWords) + (3 * (words.length - hardWords));
            System.out.println(result);
        }

        scanner.close();        
    }
}