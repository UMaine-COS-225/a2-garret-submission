import java.util.HashMap;  //imports hashmap from java.util library

public class TextAnalyzer{ //
    public static void main(String[] args){  //entry point of the program. Args array takes cmd line arguments
        if (args.length != 3) {  //checks if there is exactly 3 arguments
            System.out.println("This is java TextAnalyzer <inputFile> <charFreqFile> <wordFreqFile>"); //if not 3 arguments, exits program early
            return;
        }
        String inputFile = args[0];     //cmd line argument|text file to analyze
        String charFreqFile = args[1];  //cmd line argument|character frequency file output
        String wordFreqFile = args[2];  //cmd line argument|word frequency file output

        String content = readFile(inputFile);  //reads file and returns and stores to the content variable

        System.out.println(countCharacters(content));  //counts the number of characters from the file that was read and prints to console
        System.out.println(countWords(content));  //counts words from the file that was read and prints to console
        System.out.println(countLines(content));  //counts lines from the file that was read and prints to console
        
        HashMap<Character, Integer> charFreq = countCharacterFrequency(content);
        writeCharacterFrequency(charFreq, charFreqFile);

        HashMap<String, Integer> wordFreq = countWordFrequency(content);
        writeWordFrequency(wordFreq, wordFreqFile);

    }

        public static String readFile(String fileName) {
        String content = "";
        try {
            content = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(fileName)));
        } catch (java.io.IOException e) {
            System.out.println("File not found: " + fileName);
        }
        return content;
    }

    public static int countCharacters(String content){
        return content.length();
    }
    
    public static int countWords(String content){
        String[] words = content.split("\\s+");
        return words.length;
    }
    
    public static int countLines(String content){
        String[] lines = content.split("\n");
        return lines.length;
    }

    public static HashMap<Character, Integer> countCharacterFrequency(String content) {
        HashMap<Character, Integer> charFreq = new HashMap<>();
        for(char c : content.toCharArray()) {
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        }
        return charFreq;
    }
    // public static int writeWordFrequency(String fileName, int frequency){
    //     return 0;
    // }
}
