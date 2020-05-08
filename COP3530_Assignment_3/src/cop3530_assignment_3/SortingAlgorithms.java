//6040474
package cop3530_assignment_3;

public class SortingAlgorithms { 
    
    //Bubble sort code taken from Professor Antonio Hernandez's Week 6 Lecture
    //presentation slides.
    public static void bubbleSort(int[] list){
        int n = list.length;
        for(int i = 0; i < n - 1; i++)
            for(int j = 0; j < n - i - 1; j++)
                if(list[j] > list[j + 1]){
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
    }
    
    //Insertion sort code taken from Professor Antonio Hernandez's Week 6 Lecture
    //presentation slides.
    public static void insertionSort(int[] list){
        for(int i = 1; i < list.length; i++){
            int temp = list[i];
            int j = i - 1;
            while(j >= 0 && temp < list[j]){
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = temp;
        }
    }
    
    //Merge sort code taken from Professor Antonio Hernandez's Week 6 Lecture
    //presentation slides.
    public static void mergeSort(int[] list){
        mergeSort(list, 0, list.length-1);
    }
    
    private static void mergeSort(int[] list, int begin, int end){
        if(begin < end){
            int mid = (begin + end) / 2;
            
            mergeSort(list, begin, mid);
            mergeSort(list, mid + 1, end);
            merge(list, begin, mid, end);
        }
    }
    
    private static void merge(int[] list, int b, int m, int e){
        int[] temp = new int[e -b + 1];
        for(int i = 0; i < temp.length; i++)
            temp[i] = list[b + i];
        
        int bPtr= b;
        int ePtr= m+1;
        int i = b;
        
        while(bPtr != (m+1) && ePtr != (e+1)){
            if(temp[bPtr-b] < temp[ePtr-b]){
                list[i] = temp[bPtr-b];
                bPtr++;
            }
            else{
                list[i] = temp[ePtr-b];
                ePtr++;
            }
            
            i++;
        }
        
        if(ePtr == e+1){
            while(bPtr != (m+1)){
                list[i] = temp[bPtr-b];
                bPtr++;i++;
            }
        }
    }
    
    //Recursive quick sort code taken from Professor Antonio Hernandez's "file of
    //"assignment 3 (1)" .txt file on Canvas.
    public static void quickSort(int[] list){
        quickSort(list, 0, list.length - 1);
    }
    
    private static void quickSort(int[] list, int begin, int end){
        int temp;
        int pivot = findPivotLocation(begin, end);
        
        temp = list[pivot];
        list[pivot] = list[end];
        list[end] = temp;
        
        pivot = end;
        
        int i = begin,
                j = end - 1;
        
        boolean iterationCompleted = false;
        while (!iterationCompleted){
            while (list[i] < list[pivot])
                i++;
            while ((j >= 0) && (list[pivot] < list[j]))
                j--;
            if (i < j){
                temp = list[i];
                list[i] = list[j];
                list[j] = temp;
                i++;
                j--;
            }
            else
                iterationCompleted = true;
        }
        
        temp = list[i];
        list[i] = list[pivot];
        list[pivot] = temp;
        
        if (begin < i - 1) 
            quickSort(list, begin, i - 1);
        if (i + 1 < end) 
            quickSort(list, i + 1, end);
    }
    
    private static int findPivotLocation(int b, int e){
        return (b + e) / 2;
    }
    
    public static void selectionSort(int[] list){
        int minPos = 0;
        for(int i = 0; i < list.length - 1; i++){
            minPos = i;
            for(int j = i + 1; j < list.length; j++){
                if(list[j] < list[minPos])
                    minPos = j;
            }
            int temp = list[i];
            list[i] = list[minPos];
            list[minPos] = temp;
        }
    }
    
    public static void fillArray(int[] list){
        for(int i = 0; i < list.length; i++)
            list[i] = (int) (Math.random() * 100);
    }
    
    public static void printArray(int[] list){
        for(int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
        System.out.println();
    }
}
