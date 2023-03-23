package Problem4;

import java.util.Arrays;
import java.util.Scanner;

public class PairsWithSum {

	public static void main(String[] args) {
		// Taking input size
        System.out.println("Enter size of the Array");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
       // Taking array elements
        System.out.println("Enter Array elements");
        for(int i=0;i<n;i++) {
        	arr[i]=sc.nextInt();
        }
        System.out.println("Enter the sum of pair");
        int sum=sc.nextInt();
        System.out.println("Elements after sorting");
        Arrays.sort(arr);
        for(int i:arr) {
        	System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("Pair of elements whose sum is "+sum+" are:");
        
        //Method-1
        method1(arr,n,sum);
        System.out.println("Method-2");
        //Method-2
        method2(arr,n,sum);      
	}
    public static void method1(int[] arr,int n,int sum) {
    	 for (int i = 0; i < (n - 1); i++) {
           for (int j = (i + 1); j < n; j++) {
               if (arr[i] + arr[j] == sum) {
               	System.out.println(arr[i]+" + "+arr[j]+" = "+sum);
               }
           }
       }
    }
    public static void method2(int[] arr,int n,int sum) {
    	int low=0,high=n-1;
        while(low<high) {
        	int check=arr[low]+arr[high];
        	if(check==sum) {
        		System.out.println(arr[low]+" + "+arr[high]+" = "+sum);
        		low++;
        		high--;
        	}
        	else if(check<sum) {
        		low++;
        	}
        	else {
        		high--;
        	}
        	
        }
    }
}
