import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        try {
            File f = new File("Input\\demo.txt");
            Scanner sc = new Scanner(f);
            int size=Integer.parseInt(sc.nextLine());
            int count=Integer.parseInt(sc.nextLine());
            String[] player=new String[count];
            int[] weight=new int[count];
            int[] profit=new int[count];
            int i=0;
            while(i<count){
                String s=sc.nextLine();
                String[] st=s.split(", ");
                player[i]=st[0];
                weight[i]=Integer.parseInt(st[1]);
                profit[i]=Integer.parseInt(st[2]);
                i++;
            }
            for(int j=0; j<count-1; j++){
                for(int k=j+1; k<count; k++) {
                    //System.out.println("j: "+j+", k: "+k);
                    if (profit[j] < profit[k]) {
                        int temp = weight[j];
                        weight[j] = weight[k];
                        weight[k] = temp;
                        temp = profit[j];
                        profit[j] = profit[k];
                        profit[k] = temp;
                        String temp1 = player[j];
                        player[j] = player[k];
                        player[k] = temp1;
                    }
                }
            }
            //System.out.println(size);
            ArrayList<Integer> result=new Knapsack(size).proceed(weight, profit);
            int total=0;
            for(int iterator: result){
                if(total!=0) System.out.print("->");
                System.out.print(player[iterator]);
                total=total+profit[iterator];
            }
            System.out.println("\nMaximum Summation of form: "+total);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}