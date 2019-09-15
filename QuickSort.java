/**
 * This class will implement the quicksort algorithm.
 */
public class QuickSort {

    /**
     * This function implements a recursive quicksort algorithm that sorts arrays of numbers.
     *
     * @param arr int array to be sorted in place
     * @param startIndex int to indicate the first index of the array
     * @param endIndex int to indicate the last index of the array
     */
    public static void quicksort(int[] arr, int startIndex, int endIndex) {

        //If the starting index is less than the ending index
        if (startIndex < endIndex) {

            // Find the partition index
            int part = QuickSort.partition(arr, startIndex, endIndex);

            // Sort the other halves of the array
            quicksort(arr, startIndex, part - 1);
            quicksort(arr, part + 1, endIndex);
        }
    }

    /**
     * This function implements the partition portion of a quicksort algorithm.
     * It will move all values less than the pivot to the left of the pivot and
     * will move all values greater than the pivot to the right of the pivot.
     *
     * @param arr int array to be sorted in place
     * @param startIndex int to indicate the first index of the array
     * @param endIndex int to indicate the last index of the array
     * @return int index of the pivot
     */
    private static int partition(int[] arr, int startIndex, int endIndex) {

        // Select first element to be the pivot
        int pivot = startIndex;
        // Select the last element to be the comparator
        int compare = endIndex;

        // For all the values in the array
        for (int i = 0; i < (endIndex - startIndex); i++) {

            // When pivot is to the left of compare and
            // the value being compared is less than pivot
            // OR when pivot is to the right of compare and
            // the value being compared is greater than pivot
            if ((pivot < compare && arr[compare] < arr[pivot]) ||
                    (compare < pivot && arr[compare] > arr[pivot])) {
                // Swap values
                int temp = arr[compare];
                arr[compare] = arr[pivot];
                arr[pivot] = temp;

                // Swap index
                temp = compare;
                compare = pivot;
                pivot = temp;
            }

            // Set new compare
            compare = (pivot < compare) ? compare - 1 : compare + 1;
        }

        return pivot;
    }

    public static void main(String [] args) {
        int[] arr = {2,7,3,0,6,9,1,8,4,5};

        QuickSort.quicksort(arr, 0, arr.length - 1);

        for (int num : arr) {
            System.out.println(num);
        }
    }
}
