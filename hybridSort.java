import java.util.ArrayList;
import java.util.Collections;

public class hybridSort {
     public static void quickSort(ArrayList<Integer> list, int low, int high) {
        ArrayList<Integer> stack = new ArrayList<>();
        stack.add(low);
        stack.add(high);

        while (!stack.isEmpty()) {
            high = stack.remove(stack.size() - 1);
            low = stack.remove(stack.size() - 1);

            int p = partition(list, low, high);

            if (p - 1 > low) {
                stack.add(low);
                stack.add(p - 1);
            }
            if (p + 1 < high) {
                stack.add(p + 1);
                stack.add(high);
            }
        }
    }
    private static int partition(ArrayList<Integer> list, int low, int high) {
        int pivot = list.get(high);
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (list.get(j) <= pivot) {
                i++;
                Collections.swap(list, i, j);
            }
        }
        Collections.swap(list, i + 1, high);
        return (i + 1);
    }
}
