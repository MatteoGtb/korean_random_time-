#Random Time Generator and Translator
This program generates a specified number of random times of day and has the option to translate the generated time into the korean written form.

##How to use the program
Compile the program using your preferred Java compiler
Run the program
The program will prompt you to enter the number of random times you want to generate.
The program will generate the specified number of random times in the format of hour:minute:second
The program will then prompt you to translate the time into korean.
If you choose to translate, the program will display the time written in korean.

##Requirements
Java 8 or later

##Note
The program uses the Scanner class to prompt the user for input, and the Random class to generate random numbers.
The translation feature uses the method getKoreanNumber to convert the hour, minute, and second into their korean written form.
The program doesn't consider time format or the various way to express time in korean and may not be perfect.
