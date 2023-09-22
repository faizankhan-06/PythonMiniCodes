import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Array {

    // * Case 1:
    void ReverseArray(int[] arr,int n,Scanner sc){
        
        System.out.println("Reverse An Array");

        for(int i = 0; i < n/2; i++){
            int temp = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = temp;
        }

        /*for(int i = 0; i < n; i++){
            System.out.print(arr[i]+" ");
        }*/

        int i=0;
        while (i<n) {
            System.out.print(arr[i++]+" ");
        }
        System.out.println();
    }

    // * Case 2:
    void MaxMinArray(int[] arr,int n,Scanner sc){
        System.out.println("Max Min Of An Array");
        int max = 0;
        int min = 9999;
        for(int i = 0; i < n ; i++){
            if(arr[i]>max){
                max=arr[i];
            }
            if(arr[i]<min){
                min=arr[i];
            }
        }
        System.out.println("Max:"+max+"\nMin:"+min);
    }

    // * Case 3:
    void SumAvgArray(int[] arr,int n,Scanner sc){
        System.out.println("Sum Avg Of An Array");
        int sum = 0;
        float avg;
        for(int i = 0; i < n ; i++){
            sum+=arr[i];
        }
        avg = sum/n * 1.0f;
        System.out.println("Sum:"+sum+"\nAvg:"+avg);
    }

    // * Case 4:
    void SecondLargestArray(int[] arr,int n,Scanner sc){
        System.out.println("Second Largest Element Of An Array");
        int largest = 0;
        int secondLargest = 0;
        for(int i = 0; i < n ; i++){
            if(arr[i]>largest){
                secondLargest = largest;
                largest=arr[i];
            }
            else if(arr[i]>secondLargest && arr[i]!=largest){
                secondLargest=arr[i];
            }
        }
        System.out.println("\n2nd Largest:"+secondLargest);
    }

    // * Case 5:
    void FrequencyArray(int[] arr,int n,Scanner sc){
        System.out.println("Frequency Of Element in An Array using HashMap");
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int element : arr){
            if(freqMap.containsKey(element)){
                freqMap.put(element, freqMap.get(element)+1);
            }else{
                freqMap.put(element, 1);
            }
        }

        for(Map.Entry<Integer,Integer> entry: freqMap.entrySet()){
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    // * Case 6:
    void RotateArray(int[] arr,int n,Scanner sc){
        System.out.println("Rotate An Array by k");
        int k = sc.nextInt();
        int[] narr = new int[n];
        int j = 0;
        for(int i = 0; i < n; i++){
           narr[i] = arr[(i+k)%n];
        }

        for (int i : narr) {
            System.out.print(i+" ");
        }

        System.out.println();
    }

    // * Case 7:
    void TwoSum(int[] arr,int n,Scanner sc){
        /*
        Example 1:
            Input: nums = [2,7,11,15], target = 9
            Output: [0,1]
            Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
        Example 2:
            Input: nums = [3,2,4], target = 6
            Output: [1,2]
        Example 3:
            Input: nums = [3,3], target = 6
            Output: [0,1] 
        */
        System.out.println("Two Sum Problem");
        System.out.println("Enter The Target Value:");
        int target = sc.nextInt();
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if( (arr[i]+arr[j]) == target ){
                    System.out.println("["+arr[i]+","+arr[j]+"]");
                }
            }
        }
    }

    // * Case 8:
    void LongestSubArrayWithSum(int[] arr, int n, Scanner sc){
        /*
        Input: ‘n’ = 7 ‘k’ = 3
        ‘a’ = [1, 2, 3, 1, 1, 1, 1]

        Output: 3

        Explanation: Subarrays whose sum = ‘3’ are:

        [1, 2], [3], [1, 1, 1] and [1, 1, 1]

        Here, the length of the longest subarray is 3, which is our final answer.
        */
        System.out.println("Longest SubArray With Sum");
        System.out.println("Enter K:");
        int k = sc.nextInt();
        int sum = 0;
        int start = 0;
        List<List<Integer>> result = new ArrayList<>();
        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];

            while (sum > k) {
                sum -= arr[start];
                start++;
            }

            if (sum == k) {
                List<Integer> subarray = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    subarray.add(arr[i]);
                }
                result.add(subarray);
            }
        }

        // Print the subarrays with sum k
        int maxLength = 0;
        for (List<Integer> subarray : result) {
            if(maxLength<subarray.size()){
                maxLength=subarray.size();
            }
            System.out.println(subarray);
        }
        System.out.println("MaxLength="+maxLength);
    }

    // * Case 9:
    void MoveZeros(int[] arr, int n, Scanner sc){
        /*
        Example 1:
            Input: nums = [0,1,0,3,12]
            Output: [1,3,12,0,0]
        Example 2:
            Input: nums = [0]
            Output: [0] 
        */
        int start = 0;
        int end = n - 1;
        while (start<=end){
            if(arr[start]==0){
                for(int i = start; i <= end-1 ; i++){
                    arr[i]=arr[i+1];
                }
                arr[end] = 0;
                end--;
            }
            start++;
        }
        for(int i = 0; i < n; i++){
            System.out.print(arr[i]+",");
        }
        System.out.println();
    }

    // * Case 10:
    void BestTimeToBuyAndSellStocks(int[] arr, int n, Scanner sc){
        /*
        Example 1:
        Input: prices = [7,1,5,3,6,4]
        Output: 5
        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
        Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
        Example 2:
        Input: prices = [7,6,4,3,1]
        Output: 0
        Explanation: In this case, no transactions are done and the max profit = 0.
        */
        int buyValue = 9999;
        int sellValue = 0;
        
        for(int i = 0; i < n; i++){
            if(arr[i]<buyValue){
                for(int j = i+1; j < n;j++){
                    if(arr[j]>sellValue && arr[j]>arr[i]){
                        buyValue = arr[i];
                        sellValue= arr[j];
                    }
                }
            }
        }

        int profit = sellValue - buyValue;
        if(profit<0) profit = 0;
        System.out.println("Profit="+profit);
    }

    // * Case 11:
    void ThreeSum(int[] arr, int n, Scanner sc){
        // * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
        int sum = 0;

        for(int i = 0; i < n; i++){
            sum+=arr[i];
            for(int j = i+1; j < n; j++){
                if(i!=j){
                    sum+=arr[j];
                    for(int k = j+1; k < n; k++){
                        if(i!=k && j!=k){
                            sum+=arr[k];
                            if(sum==0){
                                int[] narr = {arr[i],arr[j],arr[k]};
                                Arrays.sort(narr);
                                System.out.println(Arrays.toString(narr));
                            }
                            sum-=arr[k];
                        }
                    }
                    sum-=arr[j];
                }
            }
            sum-=arr[i];
        }
    }

    // * Case 12:
    void NextPermutation(int[] arr, int n, Scanner sc){ // ! Difficult
        /*
        * For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
        * For example, the next permutation of arr = [1,2,3] is [1,3,2].
        Example 1:
            Input: nums = [1,2,3]
            Output: [1,3,2]
        Example 2:
            Input: nums = [3,2,1]
            Output: [1,2,3]
        Example 3:
            Input: nums = [1,1,5]
            Output: [1,5,1]
        */
        int i = n - 2;
        while(i >= 0 && arr[i] >= arr[i+1]){
            i--;
        }
        if(i >= 0){
            int j = n - 1;
            while(arr[i] >= arr[j]){
                j--;
            }
            //swap arr[i] and arr[j]
            int temp = arr[j];arr[j] = arr[i];arr[i]= temp;
        }
        
        //reverse Array[i+1 to n-1]
        int start = i+1; int end = n-1;
        while (start<end) {
            //swap arr[start] and arr[end]
            int temp = arr[end];arr[end] = arr[start];arr[start]= temp;
            start++;end--;
        }

        System.out.println(Arrays.toString(arr));
    }

    // * Case 13:
    void TopFrequentElements(int[] arr, int n, Scanner sc){
        /*
         * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
        Example 1:
            Input: nums = [1,1,1,2,2,3], k = 2
            Output: [1,2]
        Example 2:
            Input: nums = [1], k = 1
            Output: [1]
         */
        System.out.println("Enter K:");
        int k = sc.nextInt();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }
            else{
                map.put(arr[i], 1);
            }
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        // Sort the List by values
        Collections.sort(entryList, Map.Entry.comparingByValue());
        System.out.println(k+" Frequent Elements:");
        for(int i = entryList.size()-1; i >= 0 && k > 0; i--){
            Map.Entry<Integer, Integer> entry = entryList.get(i);
            System.out.println(entry.getKey());
            k--;
        }
    }

    // * Case 14:
    void MaximumSubarray(int[] arr,int n, Scanner sc){ // ! Medimum
        /*
        * Given an integer array nums, find the subarray with the largest sum, and return its sum.
        Example 1:
            Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
            Output: 6
            Explanation: The subarray [4,-1,2,1] has the largest sum 6.
        Example 2:
            Input: nums = [1]
            Output: 1
            Explanation: The subarray [1] has the largest sum 1.
        Example 3:
            Input: nums = [5,4,-1,7,8]
            Output: 23
            Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
        */
        int maxSum = arr[0];
        int currentSum = arr[0];
        for(int i = 1; i<n; i++){
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        System.out.println("Max Sum: \n"+maxSum);
    }

    // * Case 15:
    void ContainerWithMostWater(int arr[], int n, Scanner sc){ // ! Medimum
        // * https://leetcode.com/problems/container-with-most-water/
        int maxArea = 0;
        int left = 0; int right = n-1;

        while(left<right){
            int width = right-left;
            int minHeight = Math.min(arr[left], arr[right]);
            int area = width*minHeight;

            maxArea = Math.max(maxArea, area);

            if(arr[left] < arr[right]){
                left++;
            }else{
                right--;
            }
        }
        System.out.println("Max Water Area:\n"+maxArea);
    }

    // * Case 16:
    void Subsets(int[] arr, int n, Scanner sc){ // ! Difficult
        // * https://leetcode.com/problems/next-permutation/description/
        List<List<Integer>> subset = new ArrayList<>();
        generateSubset(arr, 0, new ArrayList<>(), subset);

        System.out.println(subset);
    }
    void generateSubset(int[] arr, int index, List<Integer> currentSubset, List<List<Integer>> result){
        if(index == arr.length){
            result.add(new ArrayList<>(currentSubset));
            return;
        }
        // Include the current element at the end of the currentSubset
        generateSubset(arr, index + 1, currentSubset, result);
        currentSubset.add(arr[index]);
        
        // Include the current element and recurse
        generateSubset(arr, index + 1, currentSubset, result);
        
        // Backtrack by removing the current element from the currentSubset
        currentSubset.remove(currentSubset.size() - 1);
    }

    // * Case 17:
    void ZeroRows(Scanner sc){
        // * https://leetcode.com/problems/set-matrix-zeroes/description/

        System.out.print("Enter the number of rows: ");
        int n = sc.nextInt();
        
        System.out.print("Enter the number of columns: ");
        int m = sc.nextInt();

        int[][] matrix = new int[m][n];

        System.out.println("Enter the matrix elements:");

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        boolean[] setRowZero = new boolean[m];
        boolean[] setColsZero = new boolean[n];
        for(int i = 0 ; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j]==0){
                    setRowZero[i]=true;
                    setColsZero[j]=true;
                }
            }
        }

        for(int i = 0; i < m ; i++){
            if(setRowZero[i]){
                for(int j = 0; j < n; j ++){
                    matrix[i][j]=0;
                }
            }
        }

        for(int i = 0; i < n ; i++){
            if(setColsZero[i]){
                for(int j = 0; j < m; j ++){
                    matrix[j][i]=0;
                }
            }
        }
        
        System.out.println();

        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    // * Case 18:
    void FirstMissingPositive(int[] arr, int n, Scanner sc){ // ! Difficult
        // * https://leetcode.com/problems/first-missing-positive/description/

        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i]) {
                int temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
            }
        }

        // Step 2: Find the first missing positive integer
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                System.out.println("Smallest Missing Positive: " + (i+1));
                return;
            }
        }
        System.out.println("Smallest Missing Positive: " + (n+1));
    }

    // * Case 19:
    void BestTimeToBuyAndSellStocks2(int[] arr, int n, Scanner sc){ // ! Difficult
        int buy1 = -arr[0];
        int sell1 = 0;
        int buy2 = -arr[0];
        int sell2 = 0;
        for(int i = 1; i < n; i++){
            buy1 = Math.max(buy1, -arr[i]);
            sell1 = Math.max(sell1, buy1 + arr[i]);
            buy2 = Math.max(buy2,sell1-arr[i]);
            sell2 = Math.max(sell2,buy2+arr[i]);
        }
        System.out.println("Max Profit:"+sell2);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        //#region Initializing and user input
        /*
        int n = sc.nextInt(); //Size of array
        int[] a = new int[n]; //initializing
        
        for(int i = 0; i < n; i++){ //User Input
            a[i] = sc.nextInt();
        }
        
        for(int i = 0; i < n; i++){ //print array
            System.out.println(a[i]);
        }
        */
        //#endregion
        //#region Declaring and Deleting
        /*
        int[] b = {1,2,3,4,5,6,7,8,9,10}; //Declaring An array
        int length = b.length;
        for(int i = 0; i < length; i++){ //print array
            System.out.print(b[i]+" ");
        }
        System.out.println();
        System.out.println("Deleting an Element at a given position in an array");
        int pos = 4;
        for(int i = pos; i < length-1; i++){
            b[i] = b[i+1];
        }
        length-=1;
        for(int i = 0; i < length; i++){ //print array
            System.out.print(b[i]+" ");
        }
        */
        //#endregion
        //#region Multi-Dimensional Array
        /*
        int[][] twoDArray = new int[2][2];
        int[][] twoDArray2 = {{1,2},{1,4}};
        for(int i = 0; i < twoDArray2.length; i++){
            for(int j = 0; j < twoDArray2[i].length; j++){
                System.out.println(twoDArray2[i][j]);
            }
        }
        */
        //#endregion
        System.out.println("Enter Array Length:");
        int n = sc.nextInt(); //Size of array
        int[] arr = new int[n]; //initializing
        System.out.println("Enter Array:");                
        for(int i = 0; i < n; i++){ //User Input
            arr[i] = sc.nextInt();
        }
        Array obj = new Array();
        while (true) {
            System.out.println("Enter Choice:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    obj.ReverseArray(arr,n,sc);
                    break;
                
                case 2:
                    obj.MaxMinArray(arr, n, sc);
                    break;

                case 3:
                    obj.SumAvgArray(arr, n, sc);
                    break;

                case 4:
                    obj.SecondLargestArray(arr, n, sc);
                    break;

                case 5:
                    obj.FrequencyArray(arr, n, sc);
                    break;

                case 6:
                    obj.RotateArray(arr, n, sc);
                    break;

                case 7:
                    obj.TwoSum(arr, n, sc);
                    break;

                case 8:
                    obj.LongestSubArrayWithSum(arr, n, sc);
                    break;

                case 9:
                    obj.MoveZeros(arr, n, sc);
                    break;

                case 10:
                    obj.BestTimeToBuyAndSellStocks(arr, n, sc);
                    break;

                case 11:
                    obj.ThreeSum(arr, n, sc);
                    break;

                case 12:
                    obj.NextPermutation(arr, n, sc);
                    break;

                case 13:
                    obj.TopFrequentElements(arr, n, sc);
                    break;

                case 14:
                    obj.MaximumSubarray(arr, n, sc);
                    break;
                
                case 15:
                    obj.ContainerWithMostWater(arr, n, sc);
                    break;

                case 16:
                    obj.Subsets(arr, n, sc);
                    break;

                case 17:
                    obj.ZeroRows(sc);
                    break;

                case 18:
                    obj.FirstMissingPositive(arr, n, sc);
                    break;
                
                case 19:
                    obj.BestTimeToBuyAndSellStocks2(arr, n, sc);
                    break;
                
                default:
                    System.exit(0);
                    break;
            }
        }
    }    
}
