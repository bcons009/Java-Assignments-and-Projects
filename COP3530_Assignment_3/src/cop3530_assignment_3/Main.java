//6040474
package cop3530_assignment_3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

    public Main(){
        int[] list = new int[100];
        SortingAlgorithms sa = new SortingAlgorithms();
        
        //.csv output code taken from Professor Antonio Hernandez's "file of
        //"assignment 3 (2)" .txt file on Canvas.
        String outputFileName = "output.csv";
        PrintWriter output = null;
        
        try{
            output = new PrintWriter(new FileWriter(outputFileName));
        } catch (IOException ex){
            System.exit(1);
        }
        
        for(int n = 0; n < 1101; n++){
            if(n > 0){
                int[] rt = new int[5];
                for(int i = 0; i < rt.length; i++){
                    sa.fillArray(list);
                    long start = System.nanoTime();
                    switch(i){
                        case 0:
                            sa.bubbleSort(list);
                            break;
                        case 1:
                            sa.insertionSort(list);
                            break;
                        case 2:
                            sa.selectionSort(list);
                            break;
                        case 3:
                            sa.quickSort(list);
                            break;
                        case 4:
                            sa.mergeSort(list);
                            break;
                    }
                    long stop = System.nanoTime();
                    rt[i] = (int) (stop - start);
                }
                output.println(n + "," + rt[0] + "," + rt[1] + "," + rt[2]
                        + "," + rt[3] + "," + rt[4]);
            }
            else{
                output.println("n,Bubble Sort,Insertion Sort,"
                        + "Selection Sort,Quick Sort,Merge Sort");
            }
        }
        
        output.close();
    }
        
    public static void main(String[] args) {
        Main main = new Main();
    }
    
}
