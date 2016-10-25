import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BinSrchRec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				// variables
				List <Integer> numbers = new ArrayList<Integer>();
				Random rand = new Random();
				Scanner read = new Scanner(System.in);
				int keySearch = 0;
				String wantCont = "Y";
				boolean validInput;
					
				// outputs the original, random list of integers between
				// 1 and 1000.
				System.out.println("The original list of numbers is: ");

				for (int counter = 0; counter < 250 ;counter++) {
					
					numbers.add(rand.nextInt(1000-1) + 1);
					System.out.println(numbers.get(counter));
					
				}
					
				// Adds a line to clearly separate the unsorted list from 
				// the sorted one. 
				System.out.println("*************************************************"
						+ "******************");
					
				// calls the sort function to sort the list
				numbers = sort(numbers);
					
				// print out the list
				System.out.println("The sorted list is: ");
					
				for (int counter = 0; counter < numbers.size(); counter++) {
						
				    System.out.println(numbers.get(counter));
						
				}
					
				while (wantCont.equals("Y")) {
					
				    // the while loop below makes sure the user enters an 
				    // integer input to be searched for in the sorted list
				    // This way of validating user input was retrieved from: 
				    // https://www.youtube.com/watch?v=PWez5mVXACc
				    do {
						
					System.out.println("Enter an integer to be searched for in "
						+ "the list: ");
						
					if (read.hasNextInt()) {
					    keySearch = read.nextInt();
					    validInput = true;
					}
					else {
							
					    System.err.println("Invalid input - not integer");
					    validInput = false;
					    read.next();
					}
						
				    } while (!validInput);
					
				    // if the binary search function returns a -1, that means the
				    // entered number could not be found
				    if (binarySearch(numbers, keySearch) == -1) {
						
					System.out.println("The value you have entered could not be "
						+ "found");
						
				    }
					
				    // outputs the position of the entered key in the sorted list
				    else {
						
					System.out.println("The first occurance of the value is at "
					    	+ "position: " + binarySearch(numbers, keySearch));
					
				    }
				}

			}
	public static int binarySearch(List<Integer> numbersList, int key) {
	    return binarySearch(numbersList, 0, numbersList.size()-1, key);
	}

	public static int binarySearch(List<Integer> numbersList, int start, int end, int key) {
	    int middle = (start + end) / 2;
	    if(end < start) {
	        return -1;
	    } 

	    if(key == numbersList.get(middle)) {
	        return middle;
	    } else if(key<numbersList.get(middle)) {
	        return binarySearch(numbersList, start, middle - 1, key);
	    } else {
	        return binarySearch(numbersList, middle + 1, end, key);
	    }
	}
				
				public static List<Integer> sort (List<Integer> listToSort) {
					// sort function that sorts an entered list
						
				        for (int iterator1 = 0;iterator1 < listToSort.size(); iterator1++) {
					    // this outer loop goes through and assembles the sorted list 
				            // by continually looping through smaller intervals of the list
				            // to find the minimum in each of those intervals
				            // and place it at the end of the list.
					    int min = Collections.max(listToSort);
							
					    for (int iterator2 = 0; iterator2 < listToSort.size() - iterator1; 
								iterator2++) {
						// this loop finds the minimum of the list up to the range 
						// based on how many elements have been sorted thus far
								
						if (listToSort.get(iterator2) < min) {
						
						    min = listToSort.get(iterator2);
				                    
						}
								
					    }
							
					    // takes off the minimum from the current range in the list and 
					    // puts it at the end of the list to build the sorted list
					    listToSort.remove(listToSort.indexOf(min));
					    listToSort.add(min);
							
					}
				        
				        return listToSort;
						
				    }

	
}
