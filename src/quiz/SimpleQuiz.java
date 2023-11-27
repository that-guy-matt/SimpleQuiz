package quiz;
import textio.TextIO;

public class SimpleQuiz {

	public static void main(String[] args) {
		
		// initialize main game loop
		while (true) {
			
			// initialize menu loop
			while (true) {
				
				// Displays a nice welcome message
				System.out.println("""
Welcome to the Simple Quiz!
Please select from the following options:
1. Start the quiz
2. Exit
				""");
				
				// prompt for menu input
				System.out.print("Menu selection: ");
				int menuSelection = TextIO.getlnInt();
				
				// handle menu input
				/* this validates almost any type of incorrect input
				 * however, due to the way TextIO handles incorrect input
				 * it catches empty strings before I can. in this case, 
				 * it does seem to still work properly with other input
				 * including catching all other incorrect input as far
				 * as I can tell */
				switch (menuSelection) {
					case 1:
						break; // breaks out of the switch down to the next break out of the menu loop
					case 2:
						System.out.println("Thank you for playing!\nGoodbye"); // thank the player for playing and say bye
						System.exit(0);
					default: // run this case if the user inputs anything other than 1 or 2
						System.out.println("Please input a valid menu item (1 or 2)");
						continue;
				}
				break; // this exists to force the program into the second loop after the switch is broken
				
			} // end menu loop
			
			// questions array
			/* questions and answers are stored in a 2 dimensional array
			 * this way the questions can be compared to the answers in the
			 * second dimension of the array */
			String[][] quizQuestions = {
				{ // array first dimension: questions
					"""
Question 1:
What is the chemical symbol for gold?

A) Ag
B) Ge
C) Au
D) Fe
						""",
						"""
Question 2:
Which gas is most abundant in Earth's atmosphere?

A) Oxygen
B) Nitrogen
C) Carbon dioxide
D) Argon
						""",
						"""
Question 3:
What is the largest planet in our solar system?

A) Earth
B) Jupiter
C) Mars
D) Saturn
						""",
						"""
Question 4:
What is the powerhouse of the cell?

A) Nucleus
B) Mitochondrion
C) Endoplasmic reticulum
D) Golgi apparatus
						""",
						"""
Question 5:
Which of the following is a renewable source of energy?

A) Coal
B) Natural gas
C) Solar
D) Nuclear
						"""
				}, // end array questions
				{ // array second dimension: answers
					"C", "B", "B", "B", "C" //these are strings because I could not put chars in the string array
				}
			}; // end questions array
			
			// initialize variables
			double scoreCounter = 0;
			double finalScore;
			
			/* this for loop prints each question of the questions array
			 * then prompts the user for their answer to the question
			 * it validates the input to make sure it contains only A, B,
			 * C, or D. then it compares the input to the corresponding
			 * answer in the 2 array dimension and if correct, adds a point
			 * to the scoreCounter variable */ 
			for (int i = 0; i <= quizQuestions[0].length-1; i++) { // note the length-1 because 5 is out of range of array indices
				System.out.println(quizQuestions[0][i]);
				
				// prompt user for input
				System.out.print("Please type your answer: ");
				String answer = TextIO.getlnWord();
				
				// validate input
				/* this validates almost any type of incorrect input
				 * however, due to the way TextIO handles incorrect input
				 * it causes a bug if blank input is given that I cannot
				 * figure out how to remedy. TextIO catches the blank and 
				 * and allows for you to input another text, which still
				 * catches multiple or incorrect letters, however it does
				 * not catch multiple numbers after entering a blank 
				 * I am out of time to figure this out... */
				if (answer.trim().length() > 1) { // checks that user input only one character 
					System.out.println("Please enter a single letter (A, B, C, or D)");
					System.out.println(quizQuestions[0][i]);
					System.out.print("Please type your answer: ");
					answer = TextIO.getlnWord();
				// checks if user input a, b, c, or d
				} else if (answer.toUpperCase().contains("A") || answer.toUpperCase().contains("B") || answer.toUpperCase().contains("C") || answer.toUpperCase().contains("D")) {
					// check if user's answer is correct, if yes, increment score counter otherwise do nothing.
					if (answer.toUpperCase().equals(quizQuestions[1][i])) {
						scoreCounter++;
					}
				} else {
					System.out.println("Please enter a single letter (A, B, C, or D)");
					System.out.println(quizQuestions[0][i]);
					System.out.print("Please type your answer: ");
					answer = TextIO.getlnWord();
				}
			} // ends question for loop

			// calculate and display the final score
			finalScore = scoreCounter/5.0*100;
			// this line prints the final score as a percentage
			System.out.printf("Final score is: %1.0f%%\n\n", finalScore);
			System.exit(0);
		} // end game loop
		
	} // end main

} // end SimpleQuiz