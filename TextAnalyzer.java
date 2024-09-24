import java.util.HashMap;  //imports hashmap from java.util library
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextAnalyzer{ 
    public static void main(String[] args){ 
        if (args.length != 3){               
            System.out.println("This is a java TextAnalyzer and takes 3 arguments <inputFile> <charFreqFile> <wordFreqFile>"); 
            return;
            //entry point of the program. Args array takes cmd line arguments
            //checks if there is exactly 3 arguments
            //if not 3 arguments, exits program early
        }


        String inputFile = args[0];     //cmd line argument|text file to analyze
        String charFreqFile = args[1];  //cmd line argument|character frequency file output
        String wordFreqFile = args[2];  //cmd line argument|word frequency file output


        String fileName = readFile(inputFile);  
        //reads file and returns and stores to the content variable


        System.out.println(countCharacters(fileName));  
        System.out.println(countWords(fileName));       
        System.out.println(countLines(fileName));       
        //counts the number of characters from the file that was read and prints to console
        //counts words from the file that was read and prints to console
        //counts lines from the file that was read and prints to console


        HashMap<Character, Integer> charFreq = countCharacterFrequency(fileName);  
        writeCharacterFrequency(charFreq, charFreqFile); 
        //calls the countCharacterFrequency function, returns characters and the frequency count from the text
        //saves the frequency count and saves it to an output file

        HashMap<String, Integer> wordFreq = countWordFrequency(fileName);  
        writeWordFrequency(wordFreq, wordFreqFile);  
        //calls the countWordFrequency function, returns words and the frequency count from the text
        //saves the frequency count and saves it to an output file

    }
    

    //Copied from Week2 filestuff.java
    public static String readFile(String fileName){  
        StringBuilder content = new StringBuilder();  
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {  
            String line;
            while ((line = br.readLine()) != null) {  
                content.append(line).append("\n");  
            }
        } catch (IOException e) {  
            System.out.println("File not found: " + fileName);  
        }
        return content.toString();  
    }
    

    public static int countCharacters(String fileName){
        return fileName.length();                                
        
        //returns number of characters in the string
    }
    
    public static int countWords(String fileName){
        String[] words = fileName.split("\\s+");
        return words.length;                             
        
        //returns number of words in the string|splits "\\s+" content based on whitespace
    }
    
    public static int countLines(String fileName){
        String[] lines = fileName.split("\n");
        return lines.length;                          
        
        //returns how many lines in the text content| splits content base on "\n" new lines
    }


    public static HashMap<Character, Integer> countCharacterFrequency(String fileName){  
        HashMap<Character, Integer> charFreq = new HashMap<>(); 
        fileName = fileName.toLowerCase();
        for (char c : fileName.toCharArray()) { 
            if (c != ' ' && c != '\n') {  // Skip spaces and newlines
                charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);  
            }
        }
        return charFreq;
        //takes one parameter named content. returns a hashmap for each key(letter/character) and value(integer|count of letter)
        //initializes the hash map named charFreq
        //loops through characters in the content, and converts the string into an array of characters allowing the loop
        //updates the frequency count. charFreq.put updates the charFreq map.and increments by 1. if c does not exist, returns default value of 0.
        //returns charFreq hashmap that has each character found in the content
    }

    public static HashMap<String, Integer> countWordFrequency(String fileName){  
        HashMap<String, Integer> wordFreq = new HashMap<>();
        fileName = fileName.toLowerCase();
        fileName = fileName.replaceAll("[^a-zA-Z0-9\\s]", "");
        String[] words = fileName.split ("\\s+");  
        for(String word : words){  
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1); 
        }
        return wordFreq;
        //takes one parameter named content. returns a hashmap for each string (word) and value (integer)
        //intializes the hashmap named wordFreq
        //puts all to lowercase
        //replaces anything that is not a letter (a-z, A-Z), digit (0-9). removes punctuation marks.
        //declares array of string named words and splits the content based on whitespace
        //loop that goes over each word in the words array made earlier
        //udates entry in wordFreq map|gets current count for word, if none then returns default 0. then increases by 1
        //returns the hashmap containing words and how many times.
    }

    public static void writeCharacterFrequency(HashMap<Character, Integer> charFreq, String fileName) {  
        try (FileWriter writer = new FileWriter(fileName)){  
            for (HashMap.Entry<Character, Integer> entry : charFreq.entrySet()) {  
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");  
            }
        } catch (IOException e) {  
            System.out.println("Error writing characters to file " + fileName);  
        }
        /*declared a writeCharacterFrequency method that doesnt return a value
         *parameter is a HashMap where key=characters objects and values=integer objects
         *string takes name of the file to write to from the command line interface
         * followed by try and catch blocks
         */

    }
    
    public static void writeWordFrequency(HashMap<String, Integer> wordFreq, String fileName) {  
        try (FileWriter writer = new FileWriter(fileName)) {  
            for (HashMap.Entry<String, Integer> entry : wordFreq.entrySet()) {  
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");  
            }
        } catch (IOException e) {  
            System.out.println("Error writing word to file: " + fileName);  
        }
    }
}
