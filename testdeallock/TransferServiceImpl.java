package testdeallock;

public class TransferServiceImpl implements TransferService {

	@Override
	public void transfer(Account fromAccount, Account toAccount,Float money) throws BalanceInsufficentException {
		int fromHash = System.identityHashCode(fromAccount);
		int toHash = System.identityHashCode(toAccount);
		//对两个锁对象进行排序，否则当A给B转账的同时，B也在给A转账，就会出现死锁。
		if(fromHash > toHash || fromHash == toHash) {
			synchronized (fromAccount) {
				System.out.println("获取到了" + fromAccount.getClientName()+"的锁，等待" +toAccount.getClientName() + "的锁");
				synchronized (toAccount) {
					System.out.println("获取到了" + toAccount.getClientName()+"的锁");
					System.out.println(fromAccount.getClientName() + "开始转账给" + toAccount.getClientName());
					fromAccount.minus(money);
					toAccount.add(money);
					System.out.println(fromAccount.getClientName() + "余额：" + fromAccount.getBalance());
					System.out.println(toAccount.getClientName() + "余额：" + toAccount.getBalance());
				}
				
			}
		}else {
			synchronized (toAccount) {
				System.out.println("获取到了" + toAccount.getClientName()+"的锁，等待" +fromAccount.getClientName() + "的锁");
				synchronized (fromAccount) {
					System.out.println("获取到了" + fromAccount.getClientName()+"的锁");
					System.out.println(fromAccount.getClientName() + "开始转账给" + toAccount.getClientName());
					fromAccount.minus(money);
					toAccount.add(money);
					System.out.println(fromAccount.getClientName() + "余额：" + fromAccount.getBalance());
					System.out.println(toAccount.getClientName() + "余额：" + toAccount.getBalance());
				}
				
			}
		}
			
	}

}
