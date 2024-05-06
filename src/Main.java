public class Main {
    public static String translateToPigLatin(String word) {

        word = word.toLowerCase();

        int firstVowelIndex = -1;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i'
                    || ch == 'o' || ch == 'u' || ch == 'y'
            ) {
                firstVowelIndex = i;
                break;
            }
        }

        if ( firstVowelIndex == -1) {
            return word + "yay";
        }

        String prefix = word.substring(0, firstVowelIndex);
        String stem = word.substring(firstVowelIndex);

        return stem + prefix + "yay";

    }

    public static String translateSentenceToPigLatin(String sentence) {
        StringBuilder translatedSentence = new StringBuilder();

        String [] words = sentence.split("\\s+ ");

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
        System.out.println("input: " + input1 + "Output: " + output1);

        String input2 = "Away";
        String output2 = translateToPigLatin(input2);
        System.out.println("input: " + input2 + "Output: " + output2);

        String input3 = "No persons under 14 admitted\n";
        String output3 = translateSentenceToPigLatin(input3);
        System.out.println("input: " + input3 + "Output: " + output3);

    }
}