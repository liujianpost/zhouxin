package testdeallock;

public class Account {
	
	private String clientName;
	
	private String accountNum;
	
	private Float balance;
	
	
	
	public Account() {
		super();
	}

	public Account(String clientName, String accountNum, Float balance) {
		super();
		this.clientName = clientName;
		this.accountNum = accountNum;
		this.balance = balance;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	} 
	
	public void add(Float addMoneny) {
		synchronized (balance) {
			try {
				Thread.sleep(10L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			setBalance(this.balance + addMoneny);
		}
	}
	
	public void minus(Float minusMoney) throws BalanceInsufficentException {
		synchronized (balance) {
			if(balance < minusMoney) {
				throw new BalanceInsufficentException("余额不足！");
			}
			try {
				Thread.sleep(10L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			setBalance(balance - minusMoney); 
		}
	}

}
