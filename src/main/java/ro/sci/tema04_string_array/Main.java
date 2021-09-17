package ro.sci.tema04_string_array;


public class Main {
    public static void main(String[] args) {
        String[] words = {"   The ", " quick", "brown", " fox", ",", "  jumps", "over", "the", "lazy", "dog", ".", ".."};
        String concatenatedString = "";

        for (String word : words) {
                concatenatedString += word.trim() + " ";
        }

        concatenatedString = concatenatedString.replaceAll("\\s+(\\p{Punct})", "$1");

        System.out.println(concatenatedString);

    }
}
