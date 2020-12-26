import java.util.ArrayList;

public class Knapsack {
    int size;
    public Knapsack(int size){
        this.size=size;
    }
    public ArrayList<Integer> proceed(int[] weight, int[] profit){
        ArrayList<Integer> index=new ArrayList<>();
        //int max_i=0, max_j=0, max=0;
        int[][] knapsack_array=new int[profit.length+1][size+1];
        for(int i=0; i<profit.length+1; i++){
            for(int j=0; j<size+1; j++){
                //System.out.println("i: "+i+", j: "+j);
                if(j==0||i==0) knapsack_array[i][j]=0;
                else if(weight[i-1]<=j) knapsack_array[i][j]=max(profit[i-1]+knapsack_array[i-1][j-weight[i-1]], knapsack_array[i-1][j]);
                else knapsack_array[i][j]= knapsack_array[i-1][j];
                /*if(knapsack_array[i][j]>max){
                    max=knapsack_array[i][j];
                    max_i=i;
                    max_j=j;
                }

                 */
            }
        }
        int max_i= profit.length, max_j=size;
        while(max_i>0 && max_j>0){
            if(knapsack_array[max_i][max_j]==knapsack_array[max_i-1][max_j]) max_i--;
            else if(knapsack_array[max_i][max_j]==knapsack_array[max_i][max_j-1]) max_j--;
            else{
                max_j=max_j-weight[max_i-1];
                max_i--;
                index.add(max_i);
            }
        }
        return index;
    }
    public static int max(int x, int y){
        return Math.max(x, y);
    }
}
