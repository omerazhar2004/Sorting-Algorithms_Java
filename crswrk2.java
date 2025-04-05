import java.util.ArrayList;
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
            System.out.println("Day " + (i + 1) + " (Size: " + weeklyLimArrs.get(i).size() + "): ");
            for (int j = 0; j < Math.min(10, weeklyLimArrs.get(i).size()); j++){  //remove 10 and math.min as they are only for testing purposes
                System.out.println(weeklyLimArrs.get(i).get(j) + "");
            }
            System.out.print("\n");
        }
    }

        }


