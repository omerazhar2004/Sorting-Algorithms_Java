import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Random;
public class Q1aQ1b {
    public int [] weekLims =  {1000, 5000, 10000, 50000, 75000, 100000, 500000};   // this array decides the size of each arrayList representing items manufactured in each day throughout the week
    public ArrayList<ArrayList<Integer>> weeklyLimArrsSrt = new ArrayList<>();  //for storing updated version of the sorted arrayLists for days in a week
    public ArrayList<ArrayList<Integer>> weeklyLimArrsRand = new ArrayList<>();  //for storing updated version of the unsorted arrayLists for days in a week
    public ArrayList<ArrayList<Integer>> weeklyLimArrsRevSorted = new ArrayList<>();  //for storing updated version of the sorted arrayLists for days in a week
    hybridSort hs = new hybridSort();
    public static void main (String args[]){
        Q1aQ1b mod = new Q1aQ1b();
        mod.arrGen();
        System.err.println("Printing out the three types of arrayLists: ");
        System.out.println("Sorted ArrayLists: ");         //these have been commented out as they are for just print statements for testing if arrayLists are being formed properly 
        mod.test_arrGenSorted();   //for printing sorted arrayLists
        System.out.println("Unsorted ArrayLists: ");
        mod.test_arrGenRand();   //for random unsorted arrayLists
        System.out.println("Reverse Sorted ArrayLists: ");
        mod.test_arrGenRevSrt();   //for reverse sorted arrayLists
        System.out.println("Passing the three types of ArrayLists through the quickSort Sorting Algorithm: ");
        System.out.println("Sorting Random ArrayLists: ");
        mod.arrRandSrtQsTst();       //for measuring and printing runTime when sorting random arrayLists
        System.out.println("Sorting Reverse Sorted ArrayLists: ");
        mod.arrRevSrtSrtQsTst();  //for measuring and printing runTime when sorting reverse sorted arrayLists
        System.out.println("Sorting already sorted ArrayLists: ");
        mod.srtArrSrtQsTst();    //for measuring and printing runTime when sorting already sorted arrayLists
        System.out.println("\n");
        System.out.println("Passing the three types of ArrayLists through the Hybrid Sorting Algorithm: ");
        System.out.println("Sorting Random ArrayLists: ");
        mod.arrRandSrtTst();       //for measuring and printing runTime when sorting random arrayLists
        System.out.println("Sorting Reverse Sorted ArrayLists: ");
        mod.arrRevSrtSrtTst();  //for measuring and printing runTime when sorting reverse sorted arrayLists
        System.out.println("Sorting already sorted ArrayLists: ");
        mod.srtArrSrtTst();    //for measuring and printing runTime when sorting already sorted arrayLists
        System.out.println("\n");
        System.err.println("Sorted Version: Sorted ArrayLists");         //these have been commented out as they are for just print statements for testing if arrayLists are being formed properly 
        mod.test_arrGenSorted();  //for printing sorted versions of the three arrayLists whos run times got measured above
        System.err.println("Sorted Version: Random ArrayLists");
        mod.test_arrGenRand();
        System.err.println("Sorted Version: Reverse Sorted ArrayLists");
        mod.test_arrGenRevSrt(); 
    }
    public void arrGen(){   //for generating the three types of arrayLists required according to the coursework requirements
        Random random = new Random();   
        weeklyLimArrsRand.clear();
        for (int i = 0; i < weekLims.length; i++){
            ArrayList<Integer> dayLim = new ArrayList<>();   //initialising sublists for days in an arrayList representing a week
            ArrayList<Integer> dayLimRand = new ArrayList<>();
                ArrayList<Integer> dayLimRevSrt = new ArrayList<>();
            for (int j = 0; j < weekLims[i]; j++){
                int randVal = random.nextInt(500000 - 1000 + 1) + 1000;
                dayLim.add(randVal);       //storing random values in these sublists
                dayLimRand.add(randVal);   
                dayLimRevSrt.add(randVal);
            }
        
        quickSort(dayLim, 0, dayLim.size() - 1);        //sorting the sublist that is stored in the weekLimsArrsSrt arrayList
        quickSortRev(dayLimRevSrt, 0, dayLimRevSrt.size() - 1);   //sorting the sublist that is stored in the weekLimsArrsRevSrt arrayList
        weeklyLimArrsSrt.add(dayLim);      //adding respective sublists to their larger arrayLists
        weeklyLimArrsRand.add(dayLimRand);
        weeklyLimArrsRevSorted.add(dayLimRevSrt);  
        } 
    }
    public void test_arrGenSorted(){     //for printing out current version of sublists for each day in a week
        for(int i = 0; i < weeklyLimArrsSrt.size(); i++){
            ArrayList<Integer> dayList = weeklyLimArrsSrt.get(i);
            System.out.println("Day " + (i + 1) + " (Size: " + dayList.size() + "): ");
            System.out.println("First item: " + dayList.get(0));
            System.out.println("Last item: " + dayList.get(dayList.size() - 1));
            System.out.println("\n");
        }
    }
    public void test_arrGenRand(){   //for printing out current version of sublists for each day in a week
        for(int i = 0; i < weeklyLimArrsRand.size(); i++){
            ArrayList<Integer> dayListRand = weeklyLimArrsRand.get(i);
            System.out.println("Day " + (i + 1) + " (Size: " + dayListRand.size() + "): ");
            System.out.println("First item: " + dayListRand.get(0));
            System.out.println("Last item: " + dayListRand.get(dayListRand.size() - 1));
            System.out.println("\n");
        }
    }
    public void test_arrGenRevSrt(){    //for printing out current version of sublists for each day in a week
        for(int i = 0; i < weeklyLimArrsRevSorted.size(); i++){
            ArrayList<Integer> dayListRevSrt = weeklyLimArrsRevSorted.get(i);
            System.out.println("Day " + (i + 1) + " (Size: " + dayListRevSrt.size() + "): ");
            System.out.println("First item: " + dayListRevSrt.get(0));
            System.out.println("Last item: " + dayListRevSrt.get(dayListRevSrt.size() - 1));
            System.out.println("\n");

        }
    }
    public static void quickSort(ArrayList<Integer> list, int low, int high) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();  //initialising a stack to implement iterative quicksort instead of recursive quicksort
        stack.push(low);
        stack.push(high);

        while (!stack.isEmpty()) {    //process the stack until all partitions are sorted
            high = stack.pop();
            low = stack.pop();

            int p = partition(list, low, high);  //process teh stack until all partitions are sorted

            if (p - 1 > low) {    //push left partition indices to stack if applicable
                stack.push(low);
                stack.push(p - 1);
            }
            if (p + 1 < high) {   //push right partition indices to stack if applicable
                stack.push(p + 1);
                stack.push(high);
            }
        }
    }
    private static int partition(ArrayList<Integer> list, int low, int high){
        int pivotIndex = low + (high - low)/ 2;    //choose middle element as pivot to optimise partitioning
        int pivot = list.get(pivotIndex);
        Collections.swap(list, pivotIndex, high);   //move pivot to end for standard partioning logic
        int i = (low - 1);      //index for smaller elements

        for (int j = low; j < high; j++) {
            if (list.get(j) <= pivot) {    //compare elements with pivot and swap if they are smaller
                i++;
                Collections.swap(list, i, j);  
            }
        }
        Collections.swap(list, i + 1, high);   //move pivot to its correct location
        return (i + 1);   //return pivot index
    }
    public static void quickSortRev(ArrayList<Integer> list, int low, int high) {
        Deque<Integer> stack = new ArrayDeque<>();  //initialising a stack to implement iterative quicksort instead of recursive quicksort
        stack.push(low);
        stack.push(high);

        while (!stack.isEmpty()) {    //process the stack until all partitions are sorted
            high = stack.pop();
            low = stack.pop();

            int p = partitionRev(list, low, high);   //partitioning and getting the pivot index

            if (p - 1 > low) {   //push left partition indices to stack if applicable
                stack.push(low);
                stack.push(p - 1);
            }
            if (p + 1 < high) {  //push right partition indices to stack if applicable
                stack.push(p + 1);
                stack.push(high);
            }
        }
    }
    private static int partitionRev(ArrayList<Integer> list, int low, int high) {
        int pivotIndex = low + (high - low)/ 2;   //choose middle element as pivot to optimise partitioning
        int pivot = list.get(pivotIndex);
        Collections.swap(list, pivotIndex, high);  //move pivot to end for standard partioning logic
        int i = (low - 1);   //index for smaller elements
        for (int j = low; j < high; j++) {
            if (list.get(j) >= pivot) {   //compare elements with pivot and swap if they are greater
                i++;
                Collections.swap(list, i, j); 
            }
        }
        Collections.swap(list, i + 1, high);  //move pivot to its correct location
        return (i + 1);  //return pivot index
    }
    public void srtArrSrtTst(){
        long startTime = System.currentTimeMillis();   //measures starting time before for loop
        for(int i = 0; i < weeklyLimArrsSrt.size(); i++){
            ArrayList<Integer> dayList = weeklyLimArrsSrt.get(i);
            hs.quickInsHyb(dayList, 0, dayList.size() - 1);   //for testing HybridSort runTimes
        }
        long endTime = System.currentTimeMillis();   //measures end time
        System.out.println("System took " + (endTime - startTime) + " ms to run.");   //prints out time it took for sorting algorithm to run in milli second.
    }
    public void arrRandSrtTst(){    //similar mechanism as method above 
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < weeklyLimArrsRand.size(); i++){
            ArrayList<Integer> dayListRand = weeklyLimArrsRand.get(i);
            hs.quickInsHyb(dayListRand, 0, dayListRand.size() - 1);    //for testing HybridSort runTimes
        }
        long endTime = System.currentTimeMillis();
        System.out.println("System took " + (endTime - startTime) + " ms to run.");
    }
    public void arrRevSrtSrtTst(){    //similar mechanism as method above
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < weeklyLimArrsRevSorted.size(); i++){
            ArrayList<Integer> dayListRevSrt = weeklyLimArrsRevSorted.get(i);
            hs.quickInsHyb(dayListRevSrt, 0, dayListRevSrt.size() - 1);    //for testing HybridSort runTimes
        }
        long endTime = System.currentTimeMillis();
        System.out.println("System took " + (endTime - startTime) + " ms to run.");
    }
    public void srtArrSrtQsTst(){
        long startTime = System.currentTimeMillis();   //measures starting time before for loop
        for(int i = 0; i < weeklyLimArrsSrt.size(); i++){
            ArrayList<Integer> dayList = weeklyLimArrsSrt.get(i);
            quickSort(dayList, 0, dayList.size() - 1);   //for testing quicksort algorithm runTimes
        }
        long endTime = System.currentTimeMillis();   //measures end time
        System.out.println("System took " + (endTime - startTime) + " ms to run.");   //prints out time it took for sorting algorithm to run in milli second.
    }
    public void arrRandSrtQsTst(){    //similar mechanism as method above 
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < weeklyLimArrsRand.size(); i++){
            ArrayList<Integer> dayListRand = weeklyLimArrsRand.get(i);
            quickSort(dayListRand, 0, dayListRand.size() - 1);    //for testing quicksort algorithm runTimes
        }
        long endTime = System.currentTimeMillis();
        System.out.println("System took " + (endTime - startTime) + " ms to run.");
    }
    public void arrRevSrtSrtQsTst(){    //similar mechanism as method above
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < weeklyLimArrsRevSorted.size(); i++){
            ArrayList<Integer> dayListRevSrt = weeklyLimArrsRevSorted.get(i);
            quickSort(dayListRevSrt, 0, dayListRevSrt.size() - 1);     //for testing quicksort algorithm runTimes
        }
        long endTime = System.currentTimeMillis();
        System.out.println("System took " + (endTime - startTime) + " ms to run.");
    }
}

