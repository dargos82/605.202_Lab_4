/**
 * 
 */
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * 
 */
public class CompareSorts {
	
	private String inputFolder;
	private String outputFolder;
	private String consolidatedFile;
	private String strOutput;
	private String sortFileName;
	private String fileName;
	
	/**constructor
	 * @param input1
	 */
	CompareSorts(String inputDir, String outputDir, String consolidatedFile) {
		
		this.inputFolder = inputDir;
		this.outputFolder = outputDir;
		this.consolidatedFile = consolidatedFile;
	}
	
	public void runSorts() {
		
		//create directory outputFolder from args[1] to hold output files
		Utility.createDirectory(outputFolder);
		
		//create .csv file for sort metrics
		sortFileName = consolidatedFile;
		strOutput = "Type of Sort,Order,Size,Comparisons,Swaps";
		Utility.writeToFile(outputFolder, sortFileName, strOutput);
		
		
		//create File array inputFiles using readFolder() which is reading from the dir provided in args[0]
		File[] inputFiles = Utility.readFolder(inputFolder);
		
		for (File file : inputFiles) {
		    if (file.isFile() && (!file.getName().equals(".DS_Store"))) {
		        
		    	fileName = file.getName();
		    	int[] arr = Utility.createArray(file);
		    	
		    	if(arr.length <= 50) {
		    	
			    	//quicksort()
			    	int[] arr1 = Utility.createArray(file);
			    	
			    	sortFileName = "quicksort_" + fileName;
			    	
			    	strOutput = fileName + "\n" + "Before: \n" + Arrays.toString(arr1) + "\n\n";
			    	Utility.writeToFile(outputFolder, sortFileName, strOutput);
			    	
			    	Quicksort qs1 = new Quicksort(outputFolder, sortFileName, arr1);
			    	qs1.quicksort(arr1, 0, arr1.length-1);
			    	
			    	strOutput = "\n\n" + "After: \n" + Arrays.toString(arr1) + "\n";
			    	Utility.writeToFile(outputFolder, sortFileName, strOutput);
			    	strOutput = "\nComparisons: " + qs1.getCountComparisons();
			    	Utility.writeToFile(outputFolder, sortFileName, strOutput);
			    	strOutput = "\nSwaps: " + qs1.getCountSwaps();
			    	Utility.writeToFile(outputFolder, sortFileName, strOutput);
			    	
			    	//quicksort50()
			    	int[] arr2 = Utility.createArray(file);
			    	
			    	sortFileName = "quicksort50_" + fileName;
			    	
			    	strOutput = fileName + "\n" + "Before: \n" + Arrays.toString(arr2) + "\n\n";
			    	Utility.writeToFile(outputFolder, sortFileName, strOutput);
			    	
			    	Quicksort qs2 = new Quicksort(outputFolder, sortFileName, arr2);
			    	qs2.quicksort50(arr2, 0, arr2.length-1);
			    	
			    	strOutput = "\n\n" + "After: \n" + Arrays.toString(arr2) + "\n";
			    	Utility.writeToFile(outputFolder, sortFileName, strOutput);
			    	strOutput = "\nComparisons: " + qs2.getCountComparisons();
			    	Utility.writeToFile(outputFolder, sortFileName, strOutput);
			    	strOutput = "\nSwaps: " + qs2.getCountSwaps();
			    	Utility.writeToFile(outputFolder, sortFileName, strOutput);
			    	
			    	//quicksort100()
			    	int[] arr3 = Utility.createArray(file);
			    	sortFileName = "quicksort100_" + fileName;
			    	
			    	strOutput = fileName + "\n" + "Before: \n" + Arrays.toString(arr3) + "\n\n";
			    	Utility.writeToFile(outputFolder, sortFileName, strOutput);
			    	
			    	Quicksort qs3 = new Quicksort(outputFolder, sortFileName, arr3);
			    	qs3.quicksort100(arr3, 0, arr3.length-1);
			    	
			    	strOutput = "\n\n" + "After: \n" + Arrays.toString(arr3) + "\n";
			    	Utility.writeToFile(outputFolder, sortFileName, strOutput);
			    	strOutput = "\nComparisons: " + qs3.getCountComparisons();
			    	Utility.writeToFile(outputFolder, sortFileName, strOutput);
			    	strOutput = "\nSwaps: " + qs3.getCountSwaps();
			    	Utility.writeToFile(outputFolder, sortFileName, strOutput);
			    	
			    	//quicksortMo3()
			    	int[] arr4 = Utility.createArray(file);
			    	sortFileName = "quicksortMo3_" + fileName;
			    	
			    	strOutput = fileName + "\n" + "Before: \n" + Arrays.toString(arr4) + "\n\n";
			    	Utility.writeToFile(outputFolder, sortFileName, strOutput);
			    	
			    	Quicksort qs4 = new Quicksort(outputFolder, sortFileName, arr4);
			    	qs4.quicksortMo3(arr4, 0, arr4.length-1);
			    	
			    	strOutput = "\n\n" + "After: \n" + Arrays.toString(arr4) + "\n";
			    	Utility.writeToFile(outputFolder, sortFileName, strOutput);
			    	strOutput = "\nComparisons: " + qs4.getCountComparisons();
			    	Utility.writeToFile(outputFolder, sortFileName, strOutput);
			    	strOutput = "\nSwaps: " + qs4.getCountSwaps();
			    	Utility.writeToFile(outputFolder, sortFileName, strOutput);
		    	
		    	} //end if
		    	
		    	else {
		    		
			    	sortFileName = consolidatedFile;
		    		
		    		//quicksort()
			    	int[] arr6 = Utility.createArray(file);

			    	Quicksort qs6 = new Quicksort(outputFolder, sortFileName, arr6);
			    	qs6.quicksortMetrics(arr6, 0, arr6.length-1);
		    		
			    	fileName = file.getName();
			    	strOutput = "\nQuicksort," + fileName + "," + arr6.length + "," + qs6.getCountComparisons() + "," + qs6.getCountSwaps();
		    		Utility.writeToFile(outputFolder, sortFileName, strOutput);
		    		
		    		//quicksort50()
			    	int[] arr7 = Utility.createArray(file);

			    	Quicksort qs7 = new Quicksort(outputFolder, sortFileName, arr7);
			    	qs7.quicksortMetrics50(arr7, 0, arr7.length-1);
		    		
			    	fileName = file.getName();
			    	strOutput = "\nPartition50," + fileName + "," + arr7.length + "," + qs7.getCountComparisons() + "," + qs7.getCountSwaps();
		    		Utility.writeToFile(outputFolder, sortFileName, strOutput);
		    		
		    		//quicksort100()
			    	int[] arr8 = Utility.createArray(file);

			    	Quicksort qs8 = new Quicksort(outputFolder, sortFileName, arr8);
			    	qs8.quicksortMetrics100(arr8, 0, arr8.length-1);
		    		
			    	fileName = file.getName();
			    	strOutput = "\nPartition100," + fileName + "," + arr8.length + "," + qs8.getCountComparisons() + "," + qs8.getCountSwaps();
		    		Utility.writeToFile(outputFolder, sortFileName, strOutput);
		    		
		    		//quicksortMo3()
			    	int[] arr9 = Utility.createArray(file);

			    	Quicksort qs9 = new Quicksort(outputFolder, sortFileName, arr9);
			    	qs9.quicksortMetricsMo3(arr9, 0, arr9.length-1);
		    		
			    	fileName = file.getName();
			    	strOutput = "\nMedian of 3," + fileName + "," + arr9.length + "," + qs9.getCountComparisons() + "," + qs9.getCountSwaps();
		    		Utility.writeToFile(outputFolder, sortFileName, strOutput);
		    	
		    	} //end else

		    }
		}
		
	}

}
