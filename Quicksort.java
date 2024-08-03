/**
 * 
 */

import java.util.Arrays;

/**
 * 
 */
public class Quicksort {
	
	public int countComparisons;
	public int countSwaps;
	public String strOutput;
	public String strSwap;
	public String strComp;
	public String outputFolder;
	public String fileName;
	public int[] arrayToSort;
	public String sortFileName;
	
	public void QuicksortTest(int countComparisons, int countSwaps) {
		
		this.setCountComparisons(countComparisons);
		this.setCountSwaps(countSwaps);
	}
	
	public Quicksort(String outputFolder, String fileName, int[] arrayToSort) {
		
		this.countComparisons = 0;
		this.countSwaps = 0;
		this.outputFolder = outputFolder;
		this.fileName = fileName;
		this.arrayToSort = arrayToSort;
		
	}
	
	public int getCountComparisons() {
		return countComparisons;
	}

	public void setCountComparisons(int countComparisons) {
		this.countComparisons = countComparisons;
	}

	public int getCountSwaps() {
		return countSwaps;
	}

	public void setCountSwaps(int countSwaps) {
		this.countSwaps = countSwaps;
	}
	
	/** quicksort() uses the quicksort algorithm to sort the provided array.
	 * 
	 *  Ref: Quicksort Sort Algorithm in Java - Full Tutorial With Source (https://www.youtube.com/watch?v=h8eyY7dIiN4)
	 * 
	 * @param inputArray
	 * @param lowIndex
	 * @param highIndex
	 */
	//public void quicksort(int[] inputArray, int lowIndex, int highIndex) {
	public void quicksort(int[] arrayToSort, int lowIndex, int highIndex) {
		//base case
		if(lowIndex >= highIndex)
			return;
		
		int pivot = arrayToSort[lowIndex];
		
		int leftPointer = partition(arrayToSort, lowIndex, highIndex, pivot);
		
		quicksort(arrayToSort, lowIndex, leftPointer-2);
		quicksort(arrayToSort, leftPointer, highIndex);
		
	} //end quicksort
	
	/** quicksortMetrics() uses the quicksort algorithm to sort the provided array.  It does not print comparisons and swaps.
	 *  
	 * @param inputArray
	 * @param lowIndex
	 * @param highIndex
	 */
	//public void quicksort(int[] inputArray, int lowIndex, int highIndex) {
	public void quicksortMetrics(int[] arrayToSort, int lowIndex, int highIndex) {
		//base case
		if(lowIndex >= highIndex)
			return;
		
		int pivot = arrayToSort[lowIndex];
		
		int leftPointer = partitionMetrics(arrayToSort, lowIndex, highIndex, pivot);
		
		quicksortMetrics(arrayToSort, lowIndex, leftPointer-2);
		quicksortMetrics(arrayToSort, leftPointer, highIndex);
		
	} //end quicksort
	
	/** quicksort50() sorts partitions of size <= 50 with insertion sort
	 * 
	 * @param inputArray
	 * @param lowIndex
	 * @param highIndex
	 */
	public void quicksort50(int[] inputArray, int lowIndex, int highIndex) {
		
		//base case
		if(lowIndex >= highIndex)
			return;
		
		int pivot = inputArray[lowIndex];
		
		int leftPointer = partition(inputArray, lowIndex, highIndex, pivot);
		
		if( ((leftPointer-2) - lowIndex) <= 50) {
			
			insertionsort(inputArray);
		}
		else {
			quicksort50(inputArray, lowIndex, leftPointer-2);
		}
		
		if( (highIndex - leftPointer) <= 50) {
			
			insertionsort(inputArray);
		}
		else {
			quicksort50(inputArray, leftPointer, highIndex);
		}
		
	} //end quicksortMetrics50
	
	/** quicksort50() sorts partitions of size <= 50 with insertion sort.
	 * 
	 * @param inputArray
	 * @param lowIndex
	 * @param highIndex
	 */
	public void quicksortMetrics50(int[] inputArray, int lowIndex, int highIndex) {
		
		//base case
		if(lowIndex >= highIndex)
			return;
		
		int pivot = inputArray[lowIndex];
		
		int leftPointer = partitionMetrics(inputArray, lowIndex, highIndex, pivot);
		
		if( ((leftPointer-2) - lowIndex) <= 50) {
			
			insertionsort(inputArray);
		}
		else {
			quicksortMetrics50(inputArray, lowIndex, leftPointer-2);
		}
		
		if( (highIndex - leftPointer) <= 50) {
			
			insertionsort(inputArray);
		}
		else {
			quicksortMetrics50(inputArray, leftPointer, highIndex);
		}
		
	} //end quicksortMetrics50
	
	/** quicksort100() sorts partitions of size <= 100 with insertion sort
	 * 
	 * @param inputArray
	 * @param lowIndex
	 * @param highIndex
	 */
	public void quicksort100(int[] inputArray, int lowIndex, int highIndex) {
		
		//base case
		if(lowIndex >= highIndex)
			return;
		
		int pivot = inputArray[lowIndex];
		
		int leftPointer = partition(inputArray, lowIndex, highIndex, pivot);
		
		if( ((leftPointer-2) - lowIndex) <= 100) {
			
			insertionsort(inputArray);
		}
		else {
			quicksort100(inputArray, lowIndex, leftPointer-2);
		}
		
		if( (highIndex - leftPointer) <= 100) {
			
			insertionsort(inputArray);
		}
		else {
			quicksort100(inputArray, leftPointer, highIndex);
		}
		
	} //end quicksort100
	
	/** quicksortMetrics100() sorts partitions of size <= 100 with insertion sort.
	 * It does not print swaps.
	 * 
	 * @param inputArray
	 * @param lowIndex
	 * @param highIndex
	 */
	public void quicksortMetrics100(int[] inputArray, int lowIndex, int highIndex) {
		
		//base case
		if(lowIndex >= highIndex)
			return;
		
		int pivot = inputArray[lowIndex];
		
		int leftPointer = partitionMetrics(inputArray, lowIndex, highIndex, pivot);
		
		if( ((leftPointer-2) - lowIndex) <= 100) {
			
			insertionsort(inputArray);
		}
		else {
			quicksortMetrics100(inputArray, lowIndex, leftPointer-2);
		}
		
		if( (highIndex - leftPointer) <= 100) {
			
			insertionsort(inputArray);
		}
		else {
			quicksortMetrics100(inputArray, leftPointer, highIndex);
		}
		
	} //end quicksort100
	
	/** quicksort1Mo3() uses the median-of-3 to select the pivot
	 * 
	 * @param inputArray
	 * @param lowIndex
	 * @param highIndex
	 */
	public void quicksortMo3(int[] inputArray, int lowIndex, int highIndex) {
		
		//base case
		if(lowIndex >= highIndex)
			return;
		
		int pivot = getMedian(inputArray, lowIndex, highIndex);
		//int pivot = inputArray[lowIndex];
		
		int leftPointer = partition(inputArray, lowIndex, highIndex, pivot);
		
		quicksortMo3(inputArray, lowIndex, leftPointer-2);
		quicksortMo3(inputArray, leftPointer, highIndex);
		
	} //end quicksortMo3
	
	/** quicksort1Mo3() uses the median-of-3 to select the pivot
	 * 
	 * @param inputArray
	 * @param lowIndex
	 * @param highIndex
	 */
	public void quicksortMetricsMo3(int[] inputArray, int lowIndex, int highIndex) {
		
		//base case
		if(lowIndex >= highIndex)
			return;
		
		int pivot = getMedianMetrics(inputArray, lowIndex, highIndex);
		//int pivot = inputArray[lowIndex];
		
		int leftPointer = partitionMetrics(inputArray, lowIndex, highIndex, pivot);
		
		quicksortMetricsMo3(inputArray, lowIndex, leftPointer-2);
		quicksortMetricsMo3(inputArray, leftPointer, highIndex);
		
	} //end quicksortMo3
	
	/** getMedian() calculates and returns the value of the median of the first, middle, and last
	 * indices in the array to be used as the pivot.
	 * 
	 * Ref: https://github.com/taky2/QuickSort-Median-of-3/blob/master/QuicksortMedian3.java
	 * 
	 * @param inputArray
	 * @param lowIndex
	 * @param highIndex
	 * @return
	 */
	private int getMedian(int[] inputArray, int lowIndex, int highIndex) {
		
		int first = lowIndex;
		int middle = (lowIndex + highIndex) / 2;
		int last = highIndex;
		
		if(inputArray[first] > inputArray[middle])
			swap(inputArray, first, middle);
		if(inputArray[first] > inputArray[last])
			swap(inputArray, first, last);
		if(inputArray[middle] > inputArray[last])
			swap(inputArray, middle, last);
		
		swap(inputArray, first, middle);
		
		return inputArray[first];
	}
	
	private int getMedianMetrics(int[] inputArray, int lowIndex, int highIndex) {
		
		int first = lowIndex;
		int middle = (lowIndex + highIndex) / 2;
		int last = highIndex;
		
		if(inputArray[first] > inputArray[middle])
			swapMetrics(inputArray, first, middle);
		if(inputArray[first] > inputArray[last])
			swapMetrics(inputArray, first, last);
		if(inputArray[middle] > inputArray[last])
			swapMetrics(inputArray, middle, last);
		
		swapMetrics(inputArray, first, middle);
		
		return inputArray[first];
	}

	/** partition() selects the pivot for use by quicksort()
	 * 
	 * @param inputArray
	 * @param lowIndex
	 * @param highIndex
	 * @param pivot
	 * @return leftPointer
	 */
	private int partition(int[] inputArray, int lowIndex, int highIndex, int pivot) {
		int leftPointer = lowIndex+1;
		int rightPointer = highIndex;
		
		while (leftPointer < rightPointer) {
			
			strComp = "Comparing: " + leftPointer + " and " + rightPointer + "\n";
			Utility.writeToFile(outputFolder, fileName, strComp);
			
			this.countComparisons++;
			
			while(inputArray[leftPointer] <= pivot && leftPointer < rightPointer) {
				
				if(inputArray[rightPointer-1] > inputArray[rightPointer])
					//strOutput = "Comparing: " + (rightPointer-1) + " and " + rightPointer + "\n";
					//Utility.writeToFile(outputFolder, fileName, strOutput);
					swap(inputArray, rightPointer-1, rightPointer);
				
				leftPointer++;
			}
			
			while(inputArray[rightPointer] >= pivot && leftPointer < rightPointer) {
				
				if(inputArray[rightPointer-1] > inputArray[rightPointer])
					
					//strOutput = "Comparing: " + (rightPointer-1) + " and " + rightPointer + "\n";
					//Utility.writeToFile(outputFolder, fileName, strOutput);
					swap(inputArray, rightPointer-1, rightPointer);
				
				rightPointer--;
			}
			
			swap(inputArray, leftPointer, rightPointer);
		}
		
		swap(inputArray, lowIndex, leftPointer-1);

		return leftPointer;
	} //end partition
	
	/** partition() selects the pivot for use by quicksort()
	 * 
	 * @param inputArray
	 * @param lowIndex
	 * @param highIndex
	 * @param pivot
	 * @return leftPointer
	 */
	private int partitionMetrics(int[] inputArray, int lowIndex, int highIndex, int pivot) {
		int leftPointer = lowIndex+1;
		int rightPointer = highIndex;
		
		while (leftPointer < rightPointer) {
			
			this.countComparisons++;
			
			while(inputArray[leftPointer] <= pivot && leftPointer < rightPointer) {
				
				if(inputArray[rightPointer-1] > inputArray[rightPointer])

					swapMetrics(inputArray, rightPointer-1, rightPointer);
				
				leftPointer++;
			}
			
			while(inputArray[rightPointer] >= pivot && leftPointer < rightPointer) {
				
				if(inputArray[rightPointer-1] > inputArray[rightPointer])
					
					swapMetrics(inputArray, rightPointer-1, rightPointer);
				
				rightPointer--;
			}
			
			swapMetrics(inputArray, leftPointer, rightPointer);
		}
		
		swapMetrics(inputArray, lowIndex, leftPointer-1);

		return leftPointer;
	} //end partitionMetrics()
	
	/** swap() is used by partition() to swap elements in the array.  It prints the swaps.
	 * 
	 * @param array
	 * @param index1
	 * @param index2
	 */
	private void swap(int[] array, int index1, int index2) {
		
		strSwap = "Swapping: " + index1 + " and " + index2 + "\n";
		Utility.writeToFile(outputFolder, fileName, strSwap);
		
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
		
		this.countSwaps++;
		
	} //end swap()
	
	/** swapMetrics() is used by partition() to swap elements in the array.  It does not 
	 * print swaps.
	 * 
	 * @param array
	 * @param index1
	 * @param index2
	 */
	private void swapMetrics(int[] array, int index1, int index2) {
		
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
		
		this.countSwaps++;
		
	} //end swap()
	
	/** insertionsort() sorts an array of integers
	 * 
	 * Ref: Insertion Sort Algorithm in Java - Full Tutorial With Source (https://www.youtube.com/watch?v=0lOnnd50cGI)
	 * 
	 * @param inputArray
	 */
	private void insertionsort(int[] inputArray) {

		for(int i = 1; i < inputArray.length; i++) {
			
			this.countComparisons++;
			int currentValue = inputArray[i];
			
			int j = i - 1;
			
			while(j >= 0 && inputArray[j] > currentValue) {
				
				inputArray[j + 1] = inputArray[j];
				this.countSwaps++;
				j--;
			}
			
			inputArray[j + 1] =  currentValue;
			
		}
	} //end insertionsort()

} //end Quicksort
