import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class crswrk2 {
    // public int [] dailyLim;
    public int [] weekLims =  {1, 7, 500, 6, 700};
    public ArrayList<ArrayList<Integer>> weeklyLimArrsSrt = new ArrayList<>();  //sorted
    public ArrayList<ArrayList<Integer>> weeklyLimArrsRand = new ArrayList<>();  //unsorted
    public ArrayList<ArrayList<Integer>> weeklyLimArrsRevSorted = new ArrayList<>();   //reverse sorted
    public static void main (String args[]){
        crswrk2 mod = new crswrk2();
        // srtDiffArrs newVer = new srtDiffArrs();
        mod.arrGen();
        // mod.test_arrGenSorted();
        // mod.test_arrGenRand();
        // mod.test_arrGenRevSrt();
        mod.srtArrSrtTst();
        mod.srtArrRandTst();
        mod.srtArrRevSrtTst();
        // mod.test_arrGenSorted();
        // mod.test_arrGenRand();
        // mod.test_arrGenRevSrt();
          //currentTimeMillis  
    }
    public void arrGen(){
        Random random = new Random();
        weeklyLimArrsRand.clear();
        for (int i = 0; i < weekLims.length; i++){
            ArrayList<Integer> dayLim = new ArrayList<>();
            ArrayList<Integer> dayLimRand = new ArrayList<>();
            ArrayList<Integer> dayLimRevSrt = new ArrayList<>();
            for (int j = 0; j < weekLims[i]; j++){
                dayLim.add(random.nextInt(500000 - 1000 + 1) + 1000);
                quickSort(dayLim, 0, dayLim.size() - 1);
                dayLimRand.add(random.nextInt(500000 - 1000 + 1) + 1000);
                // quickSort(dayLimRand, 0, dayLimRand.size() - 1);
                dayLimRevSrt.add(random.nextInt(500000 - 1000 + 1) + 1000);
                quickSortRev(dayLimRevSrt, 0, dayLimRevSrt.size() - 1);
            }
        weeklyLimArrsSrt.add(dayLim);
        weeklyLimArrsRand.add(dayLimRand);
        weeklyLimArrsRevSorted.add(dayLimRevSrt);  
        } 
    }
    public void test_arrGenSorted(){
        System.out.println("Sorted:\n");
        for(int i = 0; i < weeklyLimArrsSrt.size(); i++){
            ArrayList<Integer> dayList = weeklyLimArrsSrt.get(i);
            // quickSort(dayList, 0, dayList.size() - 1);
            System.out.println("Day " + (i + 1) + " (Size: " + dayList.size() + "): ");
            for (int j = 0; j < dayList.size(); j++){
                System.out.println(dayList.get(j)+ "");

            }
            System.out.println("\n");
        }
    }
    public void test_arrGenRand(){
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
    public void test_arrGenRevSrt(){
        System.out.println("Reverse Sorted:\n");
        for(int i = 0; i < weeklyLimArrsRevSorted.size(); i++){
            ArrayList<Integer> dayListRevSrt = weeklyLimArrsRevSorted.get(i);
            // quickSortRev(dayListRevSrt, 0, dayListRevSrt.size() - 1);
            System.out.println("Day " + (i + 1) + " (Size: " + dayListRevSrt.size() + "): ");
            for (int j = 0; j < dayListRevSrt.size(); j++){
                System.out.println(dayListRevSrt.get(j)+ "");
            }
            System.out.println("\n");

        }
    }
     public static void quickSort(ArrayList<Integer> list, int low, int high) {
        // if (low < high) {
        //     int partitionIndex = partition(list, low, high);

        //     quickSort(list, low, partitionIndex - 1);
        //     quickSort(list, partitionIndex + 1, high);
        // }
        // int my_list[] = new int[high - low + 1];
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

        // int top = -1;
        // list[top] = low;
    //     my_list[++top] = high;
    //     while (top >= 0){
    //      high = my_list[top--];
    //      low = my_list[top--];
    //      int p = partition(list, low, high);
    //      if (p - 1 > l){
    //         my_list[++top] = low;
    //         my_list[++top] = p - 1;
    //      }  
    //      if (p + 1 < high){
    //         my_list[++top] = p + 1;
    //         my_list[++top] = high;
    //      }
    //   }

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
    public static void quickSortRev(ArrayList<Integer> list, int low, int high) {
        if (list == null || list.size() < 2) return;
        if (low < high) {
            int partitionIndex = partitionRev(list, low, high);

            if (low < partitionIndex - 1) quickSortRev(list, low, partitionIndex - 1);
            if (partitionIndex + 1 < high) quickSortRev(list, partitionIndex + 1, high);
        }
    }

    private static int partitionRev(ArrayList<Integer> list, int low, int high) {
        int pivot = list.get(high);
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
            // quickSort(dayList, 0, dayList.size() - 1);
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
            // quickSort(dayListRand, 0, dayListRand.size() - 1);
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
            // quickSort(dayListRevSrt, 0, dayListRevSrt.size() - 1);
            System.out.println("Day " + (i + 1) + " (Size: " + dayListRevSrt.size() + "): ");
            for (int j = 0; j < dayListRevSrt.size(); j++){
                System.out.println(dayListRevSrt.get(j)+ "");
            }
            System.out.println("\n");

        }
    }
    public void srtArrSrtTst(){
        long startTime = System.currentTimeMillis();
        System.out.println("Sorted");
        for(int i = 0; i < weeklyLimArrsSrt.size(); i++){
            ArrayList<Integer> dayList = weeklyLimArrsSrt.get(i);
            quickSort(dayList, 0, dayList.size() - 1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("System took " + (endTime - startTime) + " ms to run.");
    }
    public void srtArrRandTst(){
        long startTime = System.currentTimeMillis();
        System.out.println("Random");
        System.out.println("Start Time: " + startTime);
        for(int i = 0; i < weeklyLimArrsRand.size(); i++){
            ArrayList<Integer> dayListRand = weeklyLimArrsRand.get(i);
            quickSort(dayListRand, 0, dayListRand.size() - 1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("System took " + (endTime - startTime) + " ms to run.");
    }
    public void srtArrRevSrtTst(){
        long startTime = System.currentTimeMillis();
        System.out.println("Reverse Sorted");
        System.out.println("Start Time: " +  startTime);
        for(int i = 0; i < weeklyLimArrsRevSorted.size(); i++){
            ArrayList<Integer> dayListRevSrt = weeklyLimArrsRevSorted.get(i);
            quickSort(dayListRevSrt, 0, dayListRevSrt.size() - 1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("System took " + (endTime - startTime) + " ms to run.");
    }
}

