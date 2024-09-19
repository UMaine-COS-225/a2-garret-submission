[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/NUlwhsv2)

# A2-TextAnalyzer

**Name** - Garrett Rumery

**Resources** - Boardman 138, w3schools.com

**Introspection** -

## _DO NOT EDIT BELOW THIS LINE_

In this assignment, we will practice the Java syntax seen in class to create a text analyzer. This program will take in the name of the file and provide us with details of the text such as the number of lines, number of words, and the number of characters in that file. The program will also count the frequency of each word and character and have an option to write that to the file.

In this and future assignments, we will specify the names of the classes and functions you must create so that we can automate the tests and provide you with immediate feedback. Following is a detailed description of requirements that you should use as a guide to completing the assignment.

### Create a `TextAnalyzer` class file

Create a `.java` file with the name `TextAnalyzer`. This is also known as the class file. This class file takes in 3 command line arguments which are the names of the - i) the .txt file to analyze ii) the .txt file to write character frequency to and iii) the .txt file to write word frequency to. We will assume the `.txt` file is in the same directory as the class file

### Write a function `countCharacters` to count characters

Write a function called `countCharacters`. This function will take a single String argument called `fileName` and return an integer which is the count of the characters in the file. Note that space is a character and must be counted.

### Write a function `countWords` to count words

Write a function called `countWords`. This function will take a single String argument called `fileName` and return an integer which is the count of the words in the file.

### Write a function `countLines` to count lines

Write a function called `countLines`. This function will take a single String argument called `fileName` and return an integer which is the count of the lines in the file.

### Write a function `countCharacterFrequency`

Write a function called `countCharacterFrequency` that counts the frequency of the characters in the file. It takes in a single String argument called `fileName` and returns a HashMap of type `<Character, Integer>` specifying the count of each character in the dictionary.

### Write a function `countWordFrequency`

Write a function called `countWordFrequency` that counts the frequency of the words in the file. It takes in a single String argument called `fileName` and returns a HashMap of type `<String, Integer>` specifying the count of each word in the dictionary.

### Write a function `writeCharacterFrequency`

Write a function that takes in a HashMap of type `<Character, Integer>` and the name of the file to write to. This HashMap stores the frequency of the characters seen from the original .txt file that was provided as an argument to the program. This function should then write the character and its frequency on a new line. The format of each line should be - `character, frequency`. For example, if we provide the name of the file as `characterFrequency.txt` as an argument to our `writeCharacterFrequency` function, then the `characterFrequency.txt` file should look something like below -

```txt
a,25
c,25
b,30
d,5
e,10
...
```

### Write a function `writeWordFrequency`

Write a function called `writeWordFrequency` that takes in a HashMap of type `<String, Integer>`, and the name of the file to write to. This HashMap stores the frequency of the words seen from the original .txt file that was provided as an argument to the program. This function should then write the word and its frequency on a new line. The format of each line should be - `word, frequency`. For example, if we provide the name of the file as `wordFrequency.txt` as an argument to our `writeWordFrequency` function, then the `wordFrequency.txt` file should look something like below -

```txt
the,5
of,32
is,47
there,58
in,19
...
```

### Program execution

After we compile and run the class file with the command line arguments of three .txt files, the program should analyze the first .txt file and print the number of characters, words, and lines in the file. Each of these numbers printed to `stdout` should be on a new line. Then, create a filename using the second command line argument and write the character frequency. Lastly, create another filename using the third command line argument and write the word frequency. Look at the following example for the expected input/output.

### Example

```bash
> java TextAnalyzer textFileToAnalyze.txt characterFrequency.txt wordFrequency.txt
250
50
7

> head -n 5 characterFrequency.txt
a,10
b,20
c,40
d,35
e,22

> head -n 5 wordFrequency.txt
the,30
a,50
in,60
out,55
of,24
is,30
```

### Rubric

- Created a `TextAnalyzer` text file - 5 points
- Created a function `countCharacters` - 10 points
- Created a function `countWords` - 10 points
- Created a function `countLines` - 5 points
- Created a function `countCharacterFrequency` - 15 points
- Created a function `countWordFrequency` - 15 points
- Created a function `writeCharacterFrequency` - 10 points
- Created a function `writeWordFrequency` - 10 points
- The program runs as expected - 20 points

### How to succeed

- Start early!
- Ask for help when stuck for 30 minutes or more. Do not waste more time after 30 minutes.
- Break down the problems into smaller tasks and iteratively build them in the `.java` file.
- After implementing each small task, commit changes.
- Review the code from the class available on GitHub if you cannot remember the syntax for anything.
- Run your code multiple times and vary the inputs to ensure it works as intended.
