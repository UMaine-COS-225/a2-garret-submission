import java.util.HashMap;

public class TextAnalyzer{
    public static void main(String[] args){
        if (args.length != 3){
            System.out.println("This is java TextAnalyzer <inputFile> <charFrequencyFile> <wordFrequencyFile> ");
            return;
        }
        String inputFile = args[0];
        String charFrequencyFile = args[1];
        String wordFrequencyFile = args[2];

        String content = readFile(inputFile);

        System.out.println(countCharacters(content));
        System.out.println(countWords(content));
        System.out.println(countLines(content));
        
        HashMap<Character, Integer> charFrequency = countCharacterFrequency(content);
        writeCharacterFrequency(charFrequency, charFrequencyFile);

        HashMap<String, Integer> wordFrequency = countWordFrequency(content);
        writeWordFrequency(wordFrequency, wordFrequencyFile);

    }

    public static int countCharacters(String fileName){
        return content.length();
    }
    public static int countWords(String fileName){

    }
    public static int countLines(String fileName){

    }
    public static int countCharacterFrequency(String fileName){

    }
    public static int countWordFrequency(String fileName){

    }
    public static int writeCharacterFrequency(String fileName, int frequency){

    }
    public static int writeWordFrequency(String fileName, int frequency){

    }
}
