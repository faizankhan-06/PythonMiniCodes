import java.util.Scanner;

public class Searching {
    // * Case 1:
    void BinarySearch(int[] arr, int n, Scanner sc){
        System.out.println("Enter Search Element:");
        int searchElement = sc.nextInt();
        
        int left=0;
        int right=n-1;

        while(left<=right){
            int mid = (left+right)/2;

            if(arr[mid]==searchElement){
                System.out.println("Found at index="+(mid));
                return;
            }else if(arr[mid]<searchElement){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        System.out.println("Not Found");
        return;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Array Length:");
        int n = sc.nextInt(); //Size of array
        int[] arr = new int[n]; //initializing
        System.out.println("Enter Array:");                
        for(int i = 0; i < n; i++){ //User Input
            arr[i] = sc.nextInt();
        }
        Searching obj = new Searching();
        while (true) {
            System.out.println("Enter Choice:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    obj.BinarySearch(arr,n,sc);
                    break;
                
                default:
                System.exit(0);
                    break;
            }
        }
    }
}
