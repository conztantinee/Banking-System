package jUnitTest;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import hw.bank.Deposit;
import hw.bank.Loan;



class Test {

	
	void testLoanRepay()  {
		Loan account= new Loan("test", "test");
		account.setDebt(2000);
		account.transaction(100);
		boolean result=false;
		if(account.getDebt()==1900) {
			result=true;
		}
		assertTrue(result);
	}
	
	void testDepositWithdraw()  {
		Deposit account= new Deposit("test", "test");
		account.setMoney(2000);
		account.transaction(100);
		boolean result=false;
		if(account.getMoney()==1900) {
			result=true;
		}
		assertTrue(result);
	}
	
	void testDepositTransfer() throws Exception {
		Deposit account= new Deposit("test", "test");
		Deposit account1= new Deposit("test1", "test1");
		account.setMoney(2000);
		account1.setMoney(200);
		account.transfer(100, account1.getName());
		boolean result=false;
		if(account.getMoney()==1900 && account1.getMoney()==300) {
			result=true;
		}
		assertTrue(result);
	}
	
	void testDepositTransferException1() throws Exception {
		Deposit account= new Deposit("test", "test");
		Deposit account1= new Deposit("test1", "test1");
		account.setMoney(50);
		account1.setMoney(200);
		assertThrows(Exception.class, () -> account.transfer(200, account1.getName()));
	}
	
	void testDepositTransferException2() throws Exception {
		Deposit account= new Deposit("test", "test");
		account.setMoney(250);
		assertThrows(Exception.class, () -> account.transfer(200, "account1"));
	}

}
