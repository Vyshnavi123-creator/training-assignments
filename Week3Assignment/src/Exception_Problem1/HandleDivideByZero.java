package Exception_Problem1;

import java.util.Scanner;

public class HandleDivideByZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
        String str=null;
        
    	System.out.println("Enter n1");
        int n1=sc.nextInt();
        System.out.println("Enter n2");
        int n2=sc.nextInt();
        
        try {
        	int div=n1/n2;
        	System.out.println("n1/n2= "+div);
        	System.out.println(str.length());
        }
        catch(NullPointerException e) {
        	System.out.println("String is null");
        }
        catch(ArithmeticException e) {
        	System.out.println("n2 cannot be 0");
        }
        
        finally {
        	System.out.println("End of main");
        }
	}

}

