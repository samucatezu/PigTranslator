public class Main {
    public static String translateToPigLatin(String word) {
        boolean isCapitalized = Character.isUpperCase(word.charAt(0));
        word = word.toLowerCase();
        int firstVowelIndex = -1;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i'
             || ch == 'o' || ch == 'u' || ch == 'y'
             ) {
                firstVowelIndex = i;
                break;
            }
        }

        if ( firstVowelIndex == -1) {
            word = word + "yay";
        } else {
            String prefix = word.substring(0, firstVowelIndex);
            String stem = word.substring(firstVowelIndex);
            word = stem + prefix + "yay";
        }

        if (isCapitalized) {
            word = Character.toUpperCase(word.charAt(0)) + word.substring(1);
        }

        return word;
    }

    public static String translateSentenceToPigLatin(String sentence) {
        StringBuilder translatedSentence = new StringBuilder();

        String [] words = sentence.split("\\s+");

        for (String word : words) {
            String punctuation = "";
            if (!Character.isLetter(word.charAt(word.length() - 1))) {
                punctuation = String.valueOf(word.charAt(word.length() - 1));
                word = word.substring(0, word.length() - 1);
            }

            if (word.isEmpty()) {
                translatedSentence.append(punctuation).append(" ");
                continue;
            }

            boolean startsWithCapital = Character.isUpperCase(word.charAt(0));

            String translatedWord = translateToPigLatin(word);

            if (startsWithCapital) {
                translatedWord = Character.toUpperCase(translatedWord.charAt(0)) +
                        translatedWord.substring(1);
            }

            translatedSentence.append(translatedWord).append(punctuation).append(" ");
            
        }
        return translatedSentence.toString().trim();
    }

    public static void main(String[] args) {
        String input1 = "Stop";
        String output1 = translateToPigLatin(input1);
        System.out.println("Input: " + input1 + " Output: " + output1);

        String input2 = "No littering";
        String output2 = translateSentenceToPigLatin(input2);
        System.out.println("Input: " + input2 + " Output: " + output2);

        String input3 = "No shirts, no shoes, no service";
        String output3 = translateSentenceToPigLatin(input3);
        System.out.println("Input: " + input3 + " Output: " + output3);

        String input4 = "No persons under 14 admitted";
        String output4 = translateSentenceToPigLatin(input4);
        System.out.println("Input: " + input4 + " Output: " + output4);

        String input5 = "Hey buddy, get away from my car!";
        String output5 = translateSentenceToPigLatin(input5);
        System.out.println("Input: " + input5 + " Output: " + output5);
    }
}
