package Thread_Problem2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the amount of depositing");
		int deposit=sc.nextInt();
		System.out.println("Enter the amount of withdrawing");
		int withdraw=sc.nextInt();
		Account account=new Account();
		new Thread(()->{
			account.deposit(account.totalamount, deposit);
			account.withDraw(account.totalamount, withdraw);
		}).start();
		new Thread(()->{
			account.deposit(account.totalamount, deposit);
			account.withDraw(account.totalamount, withdraw);
		}).start();
	}
}
