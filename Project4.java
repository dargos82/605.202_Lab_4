/**
 * 
 */

/**Project 4 uses QuickSort and Natural Merge Sort to sort input files of integers.
 * 
 * @version 1.0 / 29 Apr 2024
 * @author David Blossom
 * 
 */
public class Project4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if (args.length != 3) {
		    System.out.println("Invalid Number of Arguments");
		}
		
		//create CompareSorts object, pass filenames as arguments
		CompareSorts cs = new CompareSorts(args[0], args[1], args[2]);
		cs.runSorts();
		
	}

}
