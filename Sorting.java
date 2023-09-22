import java.util.Scanner;

public class Sorting {

    // * Case 1 O(n^2)
    static void SelectionSort(int[] arr,int n,Scanner sc){
        for(int i = 0; i < n-1; i++){
            int minValIndex = i;
            for(int j = i+1; j < n; j++){
                if(arr[minValIndex]>arr[j]){
                    minValIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minValIndex];
            arr[minValIndex] = temp;
        }
        
        System.out.println("Selection Sort");
        PrintArray(arr);
    }

    // * Case 2 O(n^2)
    static void BubbleSort(int[] arr,int n,Scanner sc){
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < n-i-1; j++){
                if(arr[j]>arr[j+1]){
                    //Swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

        }
        
        System.out.println("Bubble Sort");
        PrintArray(arr);
    }

    // * Case 3 O(n^2)
    static void InsertionSort(int[] arr,int n,Scanner sc){
        for(int i = 0; i < n; i++){
            int key = arr[i];
            int j = i - 1;

            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
                //PrintArray(arr);
            }

            arr[j+1] = key;
            //PrintArray(arr);

        }
        
        System.out.println("Bubble Sort");
        PrintArray(arr);
    }

    // * Case 4 O(n log n)
    static void MergeSort(int[] arr,int n,Scanner sc){
        divide(arr,0,n-1);
        System.out.println("Merge Sort");
        PrintArray(arr);
    }
    static void merge(int[] arr, int start, int mid, int end){
        int sorted[] = new int[end-start+1];

        int index1 = start;
        int index2 = mid+1;

        int i = 0;

        while(index1 <= mid && index2 <= end){
            if(arr[index1] <= arr[index2]){
                sorted[i++] = arr[index1++];
            }else{
                sorted[i++] = arr[index2++];
            }
        }

        while(index1 <= mid){
            sorted[i++] = arr[index1++];
        }

        while(index2 <= end){
            sorted[i++] = arr[index2++];
        }

        for (int j = 0, k=start; j < sorted.length; j++, k++) {
            arr[k] = sorted[j];
        }
    }
    static void divide(int[] arr, int start, int end){
        if(start>=end){
            return;
        }
        int mid = (start + end) / 2;
        divide(arr, start, mid);
        divide(arr, mid+1, end);
        merge(arr,start,mid,end);
    }

    // * Case 5 avg:O(n log n) worst:O(n^2)
    static void QuickSort(int[] arr,int n,Scanner sc){
        qsort(arr, 0, n-1);
        System.out.println("Quick Sort");
        PrintArray(arr);
    }
    static void qsort(int arr[], int low, int high){
        if(low < high){
            int pivotIndex = partition(arr,low,high);
            qsort(arr, low, pivotIndex-1);
            qsort(arr, pivotIndex+1, high);
        }
    }
    static int partition(int arr[], int low , int high){
        int pivot = arr[high];
        int i = low-1;

        for(int j = low; j < high; j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;
        return i;
    }

    // * Undo Sort
    static void UndoSort(int[] arr, int[] undo){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = undo[i];
        }
        PrintArray(arr);
    }

    // * Print Array
    static void PrintArray(int[] arr){
        System.out.println("Array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array Length:");
        int n = sc.nextInt(); //Size of array
        int[] arr = new int[n]; //initializing
        int[] undo = new int[n];
        System.out.println("Enter Array:");                
        for(int i = 0; i < n; i++){ //User Input
            arr[i] = sc.nextInt();
            undo[i]=arr[i];
        }

        while (true) {
            System.out.print("Enter Your Choice:");
            int choice = sc. nextInt();
            switch (choice) {
                case 1:
                    SelectionSort(arr,n,sc);
                    break;

                case 2:
                    BubbleSort(arr,n,sc);
                    break;

                case 3:
                    InsertionSort(arr,n,sc);
                    break;

                case 4:
                    MergeSort(arr,n,sc);
                    break;

                case 5:
                    QuickSort(arr,n,sc);
                    break;

                case 10:
                    UndoSort(arr,undo);
                    break;
            
                default:
                    break;
            }          
        }
    }
}
