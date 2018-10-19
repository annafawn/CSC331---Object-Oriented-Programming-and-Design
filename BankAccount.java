
public class BankAccount extends Object {
	
	// Properties
	private String accountNumber;
	private double balance;
	private static int numberOfAccounts = 0;
	private BankAccount overdraftAccount = null;
	
	// Constructor (will use this if only one parameter is passed) - aid in the systematic construction of an object
	public BankAccount(String accountNumber) {
		this.accountNumber = accountNumber;
		numberOfAccounts++;
	}
	
	// Example of overloading - giving multiple meanings to the same method (will use this if two parameters are passed)
	public BankAccount(String accountNumber, double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		numberOfAccounts++;
	}
	
	// Behavior
	public void setOverdraftAccount(BankAccount other) {
		overdraftAccount = other;
	}
	
	public void deposit(double howMuch) {
		balance += howMuch;
	}
	
	public void withdraw(double amount) {
		if (balance - amount < 0 && overdraftAccount != null) {
			overdraftAccount.transfer(this, amount);
		}
		balance -= amount;
	}
	
	public void transfer(BankAccount to, double amount) {
		// this.balance -= amount;
		// to.balance += amount;
		withdraw(amount);
		to.deposit(amount);
	}
	
	public String toString() {
		return accountNumber + ":" + balance;
	}
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public double getBalance() {
		return balance;
	}
	
	// can make this static to use BankAccount.getNumOfAccounts
	public static int getNumberOfAccounts() {
		return numberOfAccounts;
	}

}
