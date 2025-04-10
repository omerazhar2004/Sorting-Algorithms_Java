import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Random;
public class crswrk2 {
    // public int [] dailyLim;
    // public int [] weekLims =  {14, 10, 7, 7, 5, 4, 10};
    public int [] weekLims =  {1000, 5000, 10000, 50000, 75000, 100000, 500000};
    //  public int [] weekLims =  {1000, 5000, 10000, 50000, 75000, 100000, 5000000};
    // public int [] weekLims =  {1000, 5000, 1000, 5000, 7500, 1000, 5000};
    public ArrayList<ArrayList<Integer>> weeklyLimArrsSrt = new ArrayList<>();  //sorted
    public ArrayList<ArrayList<Integer>> weeklyLimArrsRand = new ArrayList<>();  //unsorted
    public ArrayList<ArrayList<Integer>> weeklyLimArrsRevSorted = new ArrayList<>();
    hybridSort hs = new hybridSort();
       //reverse sorted
    public static void main (String args[]){
        crswrk2 mod = new crswrk2();
        // srtDiffArrs newVer = new srtDiffArrs();
        mod.arrGen();
        // System.out.println("Sorted ArrayLists: ");
        // mod.test_arrGenSorted();
        // System.out.println("Unsorted ArrayLists: ");
        // mod.test_arrGenRand();
        // System.out.println("Reverse Sorted ArrayLists: ");
        // mod.test_arrGenRevSrt();

        System.out.println("Passing the three types of ArrayLists through the current Sorting Algorithm: ");
        System.out.println("Sorting Random ArrayLists: ");
        mod.arrRandSrtTst();
        System.out.println("Sorting Reverse Sorted ArrayLists: ");
        mod.arrRevSrtSrtTst();
        System.out.println("Sorting already sorted ArrayLists: ");
        mod.srtArrSrtTst();
        // System.err.println("Sorted Version: Sorted ArrayLists");
        // mod.test_arrGenSorted();
        // System.err.println("Sorted Version: Random ArrayLists");
        // mod.test_arrGenRand();
        // System.err.println("Sorted Version: Reverse Sorted ArrayLists");
        // mod.test_arrGenRevSrt(); 
    }
    public void arrGen(){
        Random random = new Random();
        weeklyLimArrsRand.clear();
        for (int i = 0; i < weekLims.length; i++){
            ArrayList<Integer> dayLim = new ArrayList<>();
            ArrayList<Integer> dayLimRand = new ArrayList<>();
                ArrayList<Integer> dayLimRevSrt = new ArrayList<>();
            // ArrayList<Integer> dayLimRand = new ArrayList<>();
            // ArrayList<Integer> dayLimRevSrt = new ArrayList<>();
            for (int j = 0; j < weekLims[i]; j++){
                int randVal = random.nextInt(500000 - 1000 + 1) + 1000;
                dayLim.add(randVal);
                dayLimRand.add(randVal);
                dayLimRevSrt.add(randVal);
            }
        
        quickSort(dayLim, 0, dayLim.size() - 1);
        quickSortRev(dayLimRevSrt, 0, dayLimRevSrt.size() - 1);
        weeklyLimArrsSrt.add(dayLim);
        weeklyLimArrsRand.add(dayLimRand);
        weeklyLimArrsRevSorted.add(dayLimRevSrt);  
        } 
    }
    public void test_arrGenSorted(){
        // System.out.println("Sorted:\n");
        for(int i = 0; i < weeklyLimArrsSrt.size(); i++){
            ArrayList<Integer> dayList = weeklyLimArrsSrt.get(i);
            System.out.println("Day " + (i + 1) + " (Size: " + dayList.size() + "): ");
            for (int j = 0; j < dayList.size(); j++){
                System.out.println(dayList.get(j)+ "");

            }
            System.out.println("\n");
        }
    }
    public void test_arrGenRand(){
        // System.out.println("Random:\n");
        for(int i = 0; i < weeklyLimArrsRand.size(); i++){
            ArrayList<Integer> dayListRand = weeklyLimArrsRand.get(i);
            System.out.println("Day " + (i + 1) + " (Size: " + dayListRand.size() + "): ");
            for (int j = 0; j < dayListRand.size(); j++){
                System.out.println(dayListRand.get(j)+ "");
            }
            System.out.println("\n");
        }
    }
    public void test_arrGenRevSrt(){
        // System.out.println("Reverse Sorted:\n");
        for(int i = 0; i < weeklyLimArrsRevSorted.size(); i++){
            ArrayList<Integer> dayListRevSrt = weeklyLimArrsRevSorted.get(i);
            System.out.println("Day " + (i + 1) + " (Size: " + dayListRevSrt.size() + "): ");
            for (int j = 0; j < dayListRevSrt.size(); j++){
                System.out.println(dayListRevSrt.get(j)+ "");
            }
            System.out.println("\n");

        }
    }
     public static void quickSort(ArrayList<Integer> list, int low, int high) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(low);
        stack.push(high);

        while (!stack.isEmpty()) {
            high = stack.pop();
            low = stack.pop();

            int p = partition(list, low, high);

            if (p - 1 > low) {
                stack.push(low);
                stack.push(p - 1);
            }
            if (p + 1 < high) {
                stack.push(p + 1);
                stack.push(high);
            }
        }
    }
    private static int partition(ArrayList<Integer> list, int low, int high) {
        int pivotIndex = low + (high - low)/ 2;
        int pivot = list.get(pivotIndex);
        Collections.swap(list, pivotIndex, high);
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
    public static void quickSortRev(ArrayList<Integer> list, int low, int high) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(low);
        stack.push(high);

        while (!stack.isEmpty()) {
            high = stack.pop();
            low = stack.pop();

            int p = partitionRev(list, low, high);

            if (p - 1 > low) {
                stack.push(low);
                stack.push(p - 1);
            }
            if (p + 1 < high) {
                stack.push(p + 1);
                stack.push(high);
            }
        }
    }
    private static int partitionRev(ArrayList<Integer> list, int low, int high) {
        int pivotIndex = low + (high - low)/ 2;
        int pivot = list.get(pivotIndex);
        Collections.swap(list, pivotIndex, high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (list.get(j) >= pivot) {
                i++;
                Collections.swap(list, i, j);
            }
        }
        Collections.swap(list, i + 1, high);
        return (i + 1);
    }
        public void test_arrGenSortedSrt(){
        System.out.println("Sorted:\n");
        for(int i = 0; i < weeklyLimArrsSrt.size(); i++){
            ArrayList<Integer> dayList = weeklyLimArrsSrt.get(i);
            System.out.println("Day " + (i + 1) + " (Size: " + dayList.size() + "): ");
            for (int j = 0; j < dayList.size(); j++){
                System.out.println(dayList.get(j)+ "");
            }
            System.out.println("\n");
        }
    }
    
    public void test_arrGenRandSrt(){
        System.out.println("Random:\n");
        for(int i = 0; i < weeklyLimArrsRand.size(); i++){
            ArrayList<Integer> dayListRand = weeklyLimArrsRand.get(i);
            System.out.println("Day " + (i + 1) + " (Size: " + dayListRand.size() + "): ");
            for (int j = 0; j < dayListRand.size(); j++){
                System.out.println(dayListRand.get(j)+ "");
            }
            System.out.println("\n");
        }
    }
    public void test_arrGenRevSrtSrt(){
        System.out.println("Reverse Sorted:\n");
        for(int i = 0; i < weeklyLimArrsRevSorted.size(); i++){
            ArrayList<Integer> dayListRevSrt = weeklyLimArrsRevSorted.get(i);
            System.out.println("Day " + (i + 1) + " (Size: " + dayListRevSrt.size() + "): ");
            for (int j = 0; j < dayListRevSrt.size(); j++){
                System.out.println(dayListRevSrt.get(j)+ "");
            }
            System.out.println("\n");
        }
    }
    public void srtArrSrtTst(){
        // System.out.println("Sorted");
        long startTime = System.currentTimeMillis();
        System.out.println("Start Time: " + startTime);
        for(int i = 0; i < weeklyLimArrsSrt.size(); i++){
            ArrayList<Integer> dayList = weeklyLimArrsSrt.get(i);
            // quickSort(dayList, 0, dayList.size() - 1);
            hs.quickInsHyb(dayList, 0, dayList.size() - 1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("System took " + (endTime - startTime) + " ms to run.");
    }
    public void arrRandSrtTst(){
        // System.out.println("Random");
        long startTime = System.currentTimeMillis();
        System.out.println("Start Time: " + startTime);
        for(int i = 0; i < weeklyLimArrsRand.size(); i++){
            ArrayList<Integer> dayListRand = weeklyLimArrsRand.get(i);
            // quickSort(dayListRand, 0, dayListRand.size() - 1);
            hs.quickInsHyb(dayListRand, 0, dayListRand.size() - 1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("System took " + (endTime - startTime) + " ms to run.");
    }
    public void arrRevSrtSrtTst(){
        // System.out.println("Reverse Sorted");
        long startTime = System.currentTimeMillis();
        System.out.println("Start Time: " +  startTime);
        for(int i = 0; i < weeklyLimArrsRevSorted.size(); i++){
            ArrayList<Integer> dayListRevSrt = weeklyLimArrsRevSorted.get(i);
            // quickSort(dayListRevSrt, 0, dayListRevSrt.size() - 1);
            hs.quickInsHyb(dayListRevSrt, 0, dayListRevSrt.size() - 1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("System took " + (endTime - startTime) + " ms to run.");
    }
}

