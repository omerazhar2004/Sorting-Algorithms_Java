import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class hybridSort {
    public ArrayList<Integer> weeklyLimArrsSrt = new ArrayList<>();
    
    public static void main(String[] args) {
        hybridSort hs = new hybridSort();
        hs.tstArrForm();
        // hs.tstArrFormPrint();
        hs.tstArrFormSrt();
        // hs.tstArrFormPrint();
    }
    public void tstArrForm(){    //for testing purposes
        Random random = new Random();
        for (int j = 0; j < 10000000; j++){
            weeklyLimArrsSrt.add(random.nextInt(500000 - 1000 + 1) + 1000);
        }   
    }
    public void tstArrFormPrint(){
        for (int i = 0; i < 10; i++){
            System.err.println(weeklyLimArrsSrt.get(i));
        }   
        System.out.print("\n");
    }
    public void tstArrFormSrt(){
        long startTime = System.currentTimeMillis();
        System.out.println("Sorted");
        quickInsHyb(weeklyLimArrsSrt, 0, weeklyLimArrsSrt.size() - 1);
        // insertionSort(weeklyLimArrsSrt);
        long endTime = System.currentTimeMillis();
        System.out.println("System took " + (endTime - startTime) + " ms to run.");

    }
    
     public void quickInsHyb(ArrayList<Integer> list, int low, int high) {
        if(low < high){
            if((high - low < 9)){
                 insertionSort(list, low, high);
            }
            else{
                ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(low);
        stack.push(high);

        while (!stack.isEmpty()) {
            high = stack.pop();
            low = stack.pop();

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
    public void insertionSort(ArrayList<Integer> list, int low, int high){
        int i, j;
        for (i = low + 1; i <= high; i++){
            int tempVal = list.get(i);
            j = i;
            while(j > 0 && (list.get(j - 1) > tempVal)){
                list.set(j, list.get(j - 1));
                j--;
            }
            list.set(j, tempVal);
        }
    }
}    
