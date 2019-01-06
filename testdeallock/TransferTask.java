package testdeallock;

import java.util.concurrent.BrokenBarrierException;

public class TransferTask implements Runnable {
	
	private Account fromAccount;
	
	private Account toAccount;
	
	private Float moneyAmount;
	
	public Account getFromAccount() {
		return fromAccount;
	}


	public void setFromAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
	}


	public Account getToAccount() {
		return toAccount;
	}


	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
	}


	public Float getMoneyAmount() {
		return moneyAmount;
	}


	public void setMoneyAmount(Float moneyAmount) {
		this.moneyAmount = moneyAmount;
	}


	public TransferTask(Account fromAccount, Account toAccount, Float moneyAmount) {
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.moneyAmount = moneyAmount;
	}


	@Override
	public void run() {
		
		try {
			Entrance.barrier.await();
			TransferService transferService = new TransferServiceImpl();
			transferService.transfer(fromAccount, toAccount, moneyAmount);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		} catch (BalanceInsufficentException e) {
			System.err.println(e.getMessage());
		}

	}

}
