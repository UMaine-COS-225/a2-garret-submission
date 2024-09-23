import java.util.HashMap;

public class TextAnalyzer{
    public static void main(String[] args){
        if (args.length != 3) {
            System.out.println("This is java TextAnalyzer <inputFile> <charFreqFile> <wordFreqFile>");
            return;
        }
        String inputFile = args[0];
        String charFreqFile = args[1];
        String wordFreqFile = args[2];

        String content = readFile(inputFile);

        System.out.println(countCharacters(content));
        System.out.println(countWords(content));
        System.out.println(countLines(content));
        
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
    // public static int countCharacterFrequency(String content){

    // }
    // public static int countWordFrequency(String content){

    // }
    public static HashMap<Character, Integer> charFreq = countCharacterFrequency(String content);{
        return charFreq;

    }
    public static int writeWordFrequency(String fileName, int frequency){
        return 0;
    }
}
