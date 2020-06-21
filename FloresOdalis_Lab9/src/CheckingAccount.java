/*
 * CheckingAccount class that extends BankAccount
 * class will get the name of account holder and the initial amount
 * in the checking account with a fee added
 * Name: Odalis R. Flores
 * Date: 06/20/2020
 * Class: CMSC 203
 * CRN: 202030
 * LAB 9
 */
public class CheckingAccount extends BankAccount {
	//declare static constant fee
	private static double FEE=0.15;
	
	/**constructor 
	@param name of account holder
	@param the beginning balance of the new account*/
	public CheckingAccount (String name, double initalAmount) {
		super(name, initalAmount);
		setAccountNumber(getAccountNumber() + "-10");
	}
	
	/**withdraw method adds the fee to the this amount and
	 * calls the super withdraw to determine its boolean state.
	@param amount the amount to withdraw from the account
	@return the state of super class withdraw method with new amount*/
	public boolean withdraw (double amount) {
		amount+=FEE;
		return (super.withdraw(amount));
	}
}
