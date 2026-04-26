// Programmer: Jason Ash
// Discription: Learn Java With Projects, Chapter 5 Exercise 4 using a while loop to allow the user to keep entering weights of dinosaurs in an enclosure until -1 is entered
// Filename: TaskAllocationSystem.java
// Creation date: 25, April 2026

import java.util.Scanner;
import java.util.InputMismatchException;
public class TotalWeight2
{
	public static void main(String args[])
	{
		double weight, totalWeight = 0;
		// tempDinoNumber is used in finding the correct ordinal suffix to use.
		int tempDinoNumber, dinoNumber = 1, weightToInt;
		String ordinalSuffix = "th";
		boolean keepGoing = true, validInput = true;
		Scanner sc = new Scanner(System.in);

		do
		{
			tempDinoNumber = dinoNumber;
			while(tempDinoNumber > 10)
            		{
                		// Dinosaurs numbered between 10 and 20 will all have the suffix "th". For example, 11th, 12th, 13th, ... 20th.
                		if(tempDinoNumber >= 10 && tempDinoNumber <= 20)
                		{
                    			ordinalSuffix = "th";
                       			break;
                		} // end if
                		else
				{
                    			tempDinoNumber = dinoNumber % 10;
				}
            		} // end nested while

            		// A switch structure that allows us to easily assign the correct ordinal suffix
            		switch(tempDinoNumber)
            		{
                		case 1:
                   			ordinalSuffix = "st";
                    			break;
                		case 2:
                    			ordinalSuffix = "nd";
                    			break;
                		case 3:
                    			ordinalSuffix = "rd";
                    			break;
                		default:
                    			ordinalSuffix = "th";
            		} // end switch
			
			do
			{
				System.out.print("Enter the weight for the " + dinoNumber + ordinalSuffix + " dinosaur in the enclosure in tons or -1 to quit --> ");

				
				/* if (sc.hasNextDouble())
				{ */
					try
					{
            					weight = sc.nextDouble();
						weightToInt= (int)weight;

						if(weightToInt >= 0)
						{
							totalWeight += weight;
							validInput = true;
						}
						else if(weightToInt == -1)
						{
							keepGoing = false;
							validInput = true;
						}
						else if(weightToInt < -1)
						{
							System.out.println("Please enter a positive number for the weight or -1 to quit");
							validInput = false;
						}
					}
					catch (InputMismatchException e)
 					{
    						sc.nextLine(); // Discard the invalid input from the buffer
						System.out.println("Invalid input. Please enter a number.");
						validInput = false;
					}

		                /* }
 				else
				{
            				System.out.println("Invalid input. Please enter a number.");
					validInput = false;
					sc.nextLine(); // Discard the invalid input from the buffer
        			} */
			} while(!validInput); // end do-while checking for valid input

		dinoNumber++; 
		} while(keepGoing); // end entering

		System.out.println("The total weight for all of the dinosaurs in the enclosure is " + totalWeight + " tons!");
		sc.close();
	} // end main
} // end TotalWeight2 class