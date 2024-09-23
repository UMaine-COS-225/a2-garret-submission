import java.util.HashMap;  //imports hashmap from java.util library

public class TextAnalyzer{ //
    public static void main(String[] args){  //entry point of the program. Args array takes cmd line arguments
        if (args.length != 3){  //checks if there is exactly 3 arguments
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
        
        HashMap<Character, Integer> charFreq = countCharacterFrequency(content);  //calls the countCharacterFrequency function, returns characters and the frequency count from the text
        writeCharacterFrequency(charFreq, charFreqFile); //saves the frequency count and saves it to an output file

        HashMap<String, Integer> wordFreq = countWordFrequency(content);  //calls the countWordFrequency function, returns words and the frequency count from the text
        writeWordFrequency(wordFreq, wordFreqFile);  //saves the frequency count and saves it to an output file

    }

    public static String readFile(String fileName){  //readFile method, fileName parameter
        String content = "";   //variable to hold the text read from the file
        try{   //used because might throw exception/error.
            content = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(fileName)));
            /*
            this performs the actual reading of the file:
            
            new String(...): This converts the byte array into a string. result is assigned to the content variable.
            
            java.nio.file.Files.readAllBytes(...):reads all the bytes from the file specified by the path object and returns them as a byte array.
            
            java.nio.file.Paths.get(fileName) converts the fileName string into a path object, which represents the file location.
            */
            
        } catch (java.io.IOException e){  //if exception happens, catch executes
            System.out.println("File not found: " + fileName);  //if exception happens,prints error message
        }
        return content;  //returns content variable if file was read successfully.
    }

    public static int countCharacters(String content){
        return content.length();  //returns number of characters in the string
    }
    
    public static int countWords(String content){
        String[] words = content.split("\\s+");
        return words.length;  //returns number of words in the string|splits "\\s+" content based on whitespace
    }
    
    public static int countLines(String content){
        String[] lines = content.split("\n");
        return lines.length;  //returns how many lines in the text content| splits content base on "\n" new lines
    }

    public static HashMap<Character, Integer> countCharacterFrequency(String content){
        //takes one parameter named content. returns a hashmap for each key(letter/character) and value(integer|count of letter)
        HashMap<Character, Integer> charFreq = new HashMap<>(); //initializes the hash map named charFreq
        for(char c : content.toCharArray()) { //loops through characters in the content, and converts the string into an array of characters allowing the loop
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);  //updates the frequency count. charFreq.put updates the charFreq map.and increments by 1. if c does not exist, returns default value of 0.
        }
        return charFreq;  //returns charFreq hashmap that has each character found in the content
    }

    public static HashMap<String, Integer> countWordFrequency(String content){
        //takes one parameter named content. returns a hashmap for each string (word) and value (integer) 
        HashMap<String, Integer> wordFreq = new HashMap<>();  //intializes the hashmap named wordFreq
        String[] words = content.split ("\\s+");  //declares array of string named words and splits the content based on whitespace
        for(String word : words){  //loop that goes over each word in the words array made earlier
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1); //udates entry in wordFreq map|gets current count for word, if none then returns default 0. then increases by 1
        }
        return wordFreq;  //returns the hashmap containing words and how many times.
    }
}
