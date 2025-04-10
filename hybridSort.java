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
    public void tstArrForm(){    //for generating an arrayList testing purposes
        Random random = new Random();
        for (int j = 0; j < 10000000; j++){  //generates an arrayList of size 10000000
            weeklyLimArrsSrt.add(random.nextInt(500000 - 1000 + 1) + 1000);   //generates random numbers between a certain range
        }   
    }
    public void tstArrFormPrint(){    //prints out current version of arrayList
        for (int i = 0; i < 10; i++){
            System.err.println(weeklyLimArrsSrt.get(i));
        }   
        System.out.print("\n");
    }
    public void tstArrFormSrt(){
        long startTime = System.currentTimeMillis();  //measures start time before current sorting algorithm is used
        System.out.println("Sorted");
        quickInsHyb(weeklyLimArrsSrt, 0, weeklyLimArrsSrt.size() - 1);
        // insertionSort(weeklyLimArrsSrt);
        long endTime = System.currentTimeMillis();  //calculates end time after sorting algorithm has been implemented
        System.out.println("System took " + (endTime - startTime) + " ms to run.");   //prints out final time

    }
    
    public void quickInsHyb(ArrayList<Integer> list, int low, int high) {
        if(low < high){        //ensures valid indicing for sorting
            if((high - low < 60)){   //user insertion sort for smaller partitions(threshold: 60)
                    insertionSort(list, low, high);
            }
            else{
                ArrayDeque<Integer> stack = new ArrayDeque<>();  //initialising a stack for iterative quicksort
                stack.push(low);
                stack.push(high);

                while (!stack.isEmpty()) { //iteratively process partitions until sorting is complete
                    high = stack.pop();
                    low = stack.pop();

                    int p = partition(list, low, high);   //perform partitioning and get pivot index

                    if (p - 1 > low) { //push left partition indices to stack if applicable
                        stack.push(low);
                        stack.push(p - 1);
                    }
                    if (p + 1 < high) {   //push right partition indices to stack if applicable
                        stack.push(p + 1);
                        stack.push(high);
                    }
                }
            }
        }
    }
    private static int partition(ArrayList<Integer> list, int low, int high) {
        int pivotIndex = low + (high - low)/ 2; //choose middle element as pivot to optimise partitioning
        int pivot = list.get(pivotIndex);
        Collections.swap(list, pivotIndex, high); //move pivot to end for standard partioning logic
        int i = (low - 1);  //index for smaller elements

        for (int j = low; j < high; j++) {
            if (list.get(j) <= pivot) {   //compare elements with pivot and swap if they are smaller
                i++;
                Collections.swap(list, i, j);  
            }
        }
        Collections.swap(list, i + 1, high);   //move pivot to its correct location
        return (i + 1); //return pivot index
    }
    public void insertionSort(ArrayList<Integer> list, int low, int high){
        int i, j;
        for (i = low + 1; i <= high; i++){   //iterating through the arrayList
            int tempVal = list.get(i);   //assigning temporary variable to current index item
            j = i;
            while(j > 0 && (list.get(j - 1) > tempVal)){   //a while loop for swapping elements if previouse element is greater than current element
                list.set(j, list.get(j - 1));
                j--;
            }
            list.set(j, tempVal);
        }
    }
}

