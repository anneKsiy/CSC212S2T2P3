import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* Created by 3935415 Abdullah Adam on 2020/09/25
 * www.github.com/anneKsiy
 * SortingUtilities class containing the methods:
 * mergeSortSchool(List<School> arr) -> void
 * partitionSchool(List<School> arr, int low, int high) -> int
 * quickSortSchool(List<School> arr, int low, int high) -> void
 */
public class SortingUtilities {
    public static void mergeSortSchool(List<School> arr) {
        if (arr == null) return;

        if (arr.size() > 1) {
            int mid = arr.size() / 2;
            /* Split array into a left partition, since ArrayLists are used,
            to avoid a NullPointerException error being thrown, Collections.nCopies
            must be used to place null in each of the indices in the ArrayList
            */
            List<School> left = new ArrayList<>(Collections.nCopies(mid, null));
            for (int i = 0; i < mid; i++) {
                left.set(i, arr.get(i));
            }
            int rightInitialSize = arr.size() - mid;
            /* Split array into a right partition, since ArrayLists are used,
            to avoid a NullPointerException error being thrown, Collections.nCopies
            must be used to place null in each of the indices in the ArrayList
            */
            List<School> right = new ArrayList<>(Collections.nCopies(rightInitialSize, null));
            // iterate from the middle of the array until the length of the array
            for (int i = mid; i < arr.size(); i++) {
                right.set(i - mid, arr.get(i));
            }
            mergeSortSchool(left);
            mergeSortSchool(right);

            int i = 0, j = 0, k = 0;

            // merging the left and right subarrays
            while (i < left.size() && j < right.size()) {
                if (left.get(i).getName().compareTo(right.get(j).getName()) < 0) {
                    arr.set(k, left.get(i));
                    i++;
                } else {
                    arr.set(k, right.get(j));
                    j++;
                }
                k++;
            }
            // the leftover elems will be collected by the following two while loops
            while (i < left.size()) {
                arr.set(k, left.get(i));
                i++;
                k++;
            }
            while (j < right.size()) {
                arr.set(k, right.get(j));
                j++;
                k++;
            }
        }
    }

    public static int partitionSchool(List<School> arr, int low, int high) {
        School pivot = arr.get(high);
        int i = (low - 1); // getting the index of the smaller element
        for (int j = low; j <= high - 1; j++) {
            /* if the current elem is smaller or equal to pivot, we swap
            arr[i] and arr[j]
             */
            if (arr.get(j).getName().compareTo(pivot.getName()) < 0 || arr.get(j).getName() == pivot.getName()) {
                i++;
                School temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        // swap arr[i + 1] and arr[high] (which may be the pivot)
        School temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);
        return i + 1; // returns the partition index to be used in the quickSortSchool method
    }

    public static void quickSortSchool(List<School> arr, int low, int high) {
        // low must be less than high for quickSortSchool to run, ie, must have valid arguments
        if (low < high) {
            int partitionIndex = partitionSchool(arr, low, high);
            quickSortSchool(arr, low, partitionIndex - 1);
            quickSortSchool(arr, partitionIndex + 1, high);
        }
    }
}
