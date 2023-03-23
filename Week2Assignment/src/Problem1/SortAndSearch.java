package Problem1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class SortAndSearch {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter size of ArrayList");
		int size=sc.nextInt();
		System.out.println("Enter elements of ArrayList");
		//Take arraylist from input
		String check=sc.next();
		ArrayList<Double> a=new ArrayList<>();
		if(check.matches("\\d+") || check.matches("\\d*[.]\\d+")) {
			a.add(Double.parseDouble(check));
			for(int i=0;i<size-1;i++) {
				a.add(sc.nextDouble());
			}
			System.out.println("Enter element to be found in ArrayList");
			//Take input N
			double N=sc.nextDouble();
		     
			//remove duplicates
			HashSet<Double> set=new HashSet<>();
			for(double i:a) {
				set.add(i);
			}
			ArrayList<Double> arr=new ArrayList<>();
			for(double i:set) {
				arr.add(i);
			}
			size=arr.size();
			
			//sort the arraylist
			for (int i = 0; i < size - 1; i++) {
	            for (int j = 0; j < size - i - 1; j++) {
	                if (arr.get(j) >arr.get(j+1)) {
	                    Collections.swap(arr, j, j+1);
	                }
	            }
			}
			
			//print arraylist without duplicates
			System.out.println(arr);
			
			//Binary Search
			int low=0,high=size-1;
			while(low<=high) {
				int mid=(low+high)/2;
				if(arr.get(mid)==N) {
					System.out.println("Element found at Index "+mid);
					return;
				}
				else if(arr.get(mid)<N) {
					low=mid+1;
				}
				else {
					high=mid-1;
				}
			}
		     System.out.println("Given element doesn't exist");
		}
		else {
			System.out.println("Don't enter Alphanumeric or alphabet!");
			return;
		}
	    
	}

}
