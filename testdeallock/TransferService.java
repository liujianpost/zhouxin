package testdeallock;

public interface TransferService {
	
	public void transfer(Account fromAccount,Account toAccount,Float money) throws BalanceInsufficentException;

}
