import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class crswrk2 {
    // public int [] dailyLim;
    public int [] weekLims =  {1000, 5000, 10000, 50000, 75000, 100000, 500000};
    public ArrayList<ArrayList<Integer>> weeklyLimArrs = new ArrayList<>();
    public static void main (String args[]){
        crswrk2 mod = new crswrk2();
        mod.arrGen();
        mod.test_arrGen();
    }
    public void arrGen(){
        // int [] weekLims =  {1000, 5000, 10000, 50000, 75000, 100000, 500000};
        Random random = new Random();
        weeklyLimArrs.clear();
        // int[] moIt = new int[1000];
        for (int i = 0; i < weekLims.length; i++){
            ArrayList<Integer> dayLim = new ArrayList<>();
            for (int j = 0; j < weekLims[i]; j++){
                dayLim.add(random.nextInt(500000 - 1000 + 1) + 1000);
            }
        weeklyLimArrs.add(dayLim);    
        }
        
    }
    public void test_arrGen(){
        for(int i = 0; i < weeklyLimArrs.size(); i++){
            ArrayList<Integer> dayList = weeklyLimArrs.get(i);
            quickSort(dayList, 0, dayList.size() - 1);
            System.out.println("Day " + (i + 1) + " (Size: " + dayList.size() + "): ");
            for (int j = 0; j < Math.min(10, dayList.size()); j++){  //remove 10 and math.min as they are only for testing purposes
                System.out.println(dayList.get(j)+ "");

            }

    }
    }
     public static void quickSort(ArrayList<Integer> list, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(list, low, high);

            quickSort(list, low, partitionIndex - 1);
            quickSort(list, partitionIndex + 1, high);
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

    // public static void main(String[] args) {
    //     ArrayList<Integer> list = new ArrayList<>(List.of(5, 2, 9, 1, 5, 6));
    //     System.out.println("Unsorted ArrayList: " + list);

    //     quickSort(list, 0, list.size() - 1);
    //     System.out.println("Sorted ArrayList: " + list);
    // }
}

