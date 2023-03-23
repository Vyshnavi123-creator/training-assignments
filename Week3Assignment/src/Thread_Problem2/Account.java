package Thread_Problem2;

public class Account {
    int totalamount=0;

	public int getAmount() {
		return totalamount;
	}

	public void setAmount(int amount) {
		this.totalamount = amount;
	}
	public synchronized void withDraw(int totalamount, int amount) {
		if(amount>totalamount) {
			System.out.println("Insufficient balance");
			return;
		}
		totalamount=totalamount-amount;
		setAmount(totalamount);
		System.out.println("With Drawing "+amount+" ,new balance is "+totalamount);
	}

	public synchronized void deposit(int totalamount, int amount) {
		if(amount<=0) {
			System.out.println("Invalid Amount");
			return;
		}
		totalamount=totalamount+amount;
		setAmount(totalamount);
		System.out.println("Depositing "+amount+" ,new balance is "+totalamount);
	}

}
