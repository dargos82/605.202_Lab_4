
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Utility {
	
	/** readFolder() accepts a path and accesses the files in that folder.
	 * 
	 * Ref: https://stackoverflow.com/questions/1844688/how-can-i-read-all-files-in-a-folder-from-java
	 * 
	 * @param folderPath
	 */
	public static File[] readFolder(String folderPath) {
		
		File folder = new File(folderPath);
		File[] fileList = folder.listFiles();
		
		return fileList;
	}
	
	public static void writeToFile(String outputFolder, String fileName, String strOutput) {
		
		try{
			
	        PrintWriter writer = null;
	        String dirName = outputFolder;
	        String outputFileName = "output_" + fileName;
	        File dir = new File(dirName);
	        File result = new File(dir, outputFileName);

	        writer = new PrintWriter(new FileWriter(result,  true));
	        
	        writer.write(strOutput);
	        
	        writer.close();
	        //System.out.println("File has been written");

	    }catch(Exception e){
	        System.out.println("Could not create file");
	    }
		
	} //end writeToFile()
	
	/** createDirectory() takes a string from args[1] and creates a new directory in a user-specified location.
	 * 
	 * Ref: Java - Creating and Deleting Folders (https://www.youtube.com/watch?v=WUJKivDbbAo)
	 * 
	 * @param outputFolder
	 */
	public static void createDirectory(String outputFolder) {
		
		boolean checkDir;
		
		Path outputPath = Paths.get(outputFolder);
		
		checkDir = Files.exists(outputPath);
		
		if(checkDir) {
			
			System.out.println("Directory already exists");
			return;
		}
		
		try {
			
			Files.createDirectory(outputPath);
		} catch (Exception e) {
			System.out.println("Could not create directory");
		}
		
	} //end createDirectory()
		
	/** createArray() opens the input file, determines how many integers are in the file,
	 * initializes an array, loads the array with integers from the input file, and returns
	 * the array to be used by the calling method.
	 * 
	 * @param inputFile
	 */
	public static int[] createArray(File inputFile) {
	
		try {
			//File file = new File(inputFile);
			Scanner scanner1 = new Scanner(inputFile);
			
			int inputCounter = 0;
			
			while(scanner1.hasNextInt()) {
				
				inputCounter++;
				scanner1.nextInt();
			}
			
			int[] array = new int[inputCounter];
			
			Scanner scanner2 = new Scanner(inputFile);
			
			for(int i = 0; i < array.length; i++) {
				array[i] = scanner2.nextInt();
				
			}
			
			scanner1.close();
			scanner2.close();
			
			return array;
		} catch (FileNotFoundException e) {
			System.out.println("Error opening the file.");
			return null;
		}
		
	} //end createArray()
	
}
