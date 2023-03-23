package Exception_Problem2;

import java.util.Scanner;

public class HandleArrayIndexOutofBound {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] arr= {1,5,9,7,3};
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Index");
        int index=sc.nextInt();
        try {
        	System.out.println(arr[index]);
        }catch(ArrayIndexOutOfBoundsException e) {
        	System.out.println("Enter the index correctly");
        }
        finally {
        	System.out.println("End of main");
        }
	}

}
