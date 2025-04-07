import java.util.ArrayList;
import java.util.Collections;

public class hybridSort {
     public static void quickSort(ArrayList<Integer> list, int low, int high) {
        if(low < high){
            if((high - low < 9)){
                insertionSort(list);
            }
            else{
            
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
    private static void insertionSort(ArrayList<Integer> list){
        int i, j;
        for (i = 1; i < list.size(); i++){
            int tempVal = list.get(i);
            j = i;
            while(j > 0 && (list.get(j - 1) > tempVal)){
                // list.get(j + 1) = list.get(j);
                // Collections.swap(list, j + 1, j);
                list.set(j, list.get(j - 1));
                j--;
            }
            list.set(j, tempVal);
        }
    }
}    
