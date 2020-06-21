/*
 * SavingsAccount class that extends BankAccount
 * class will get savings account information and
 * calculate fees
 * Name: Odalis R. Flores
 * Date: 06/20/2020
 * Class: CMSC 203
 * CRN: 202030
 * LAB 9
 */
public class SavingsAccount extends BankAccount{
	//declare instance variable rate to equal 2.5%
	private double rate = .025;
	//declare instance variable savingsNumber and initialize to 0
	private int savingsNumber = 0;
	//declare instance variable called accountNumer
	private  String accountNumber;
	
	/**constructor
	@param name the owner of the account
	@param initial balance of account*/
	public SavingsAccount(String name, double initialBalance) {
		super( name, initialBalance);
		this.accountNumber=super.getAccountNumber();
		this.setAccountNumber(this.getAccountNumber());
	}

	/**postInterest calculate the balance of the account including
	 * the annual fee in 12 months
	*/
	public void postInterest() {
		this.setBalance((this.getBalance()*rate)/12 +this.getBalance()); 
	}
	
	/**getAccountNumber will concatenate accountNumber with hyphen and
	 * savingsNumber of account holder
	*/
	public String getAccountNumber() {
		return this.accountNumber+"-"+Integer.toString(savingsNumber);
	}
	/**copy constructor
	@param original savings account number
	@param initial balance of account*/
	public SavingsAccount(BankAccount original, double initialBalance) {
		super(original,initialBalance);
		this.savingsNumber++;
		this.accountNumber=super.getAccountNumber()+"-"+Integer.toString(savingsNumber);
	}

}
