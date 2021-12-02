package hw.bank;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Deposit extends Account implements Serializable {
	
	double money;

	public Deposit(String n, String p) {
		super(n, p);
		// TODO Auto-generated constructor stub
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	
	
	public void transaction(double amount) {
		this.money=this.money-amount;
	}
	
	public void transfer(double amount, String target) throws Exception  {
		if(this.money<amount) {
			throw new Exception("insufficient amount of money");
		}
		else {
		boolean	accountexists=false;
		for(int i=0; i<Main.deposits.size(); i++) {
			if(Main.deposits.get(i).name.equals(target)) {
				this.money=this.money-amount;
				Main.deposits.get(i).money=Main.deposits.get(i).money+amount;
				accountexists=true;
			}
		}
		if(!accountexists) {
			throw new Exception("no such account");
		}
		}
	}
	
	public static void load() {
		try {
			FileInputStream inputFile = new FileInputStream(Main.filenameDeposit);
			ObjectInputStream input = new ObjectInputStream(inputFile);
			boolean read = true;
			while(read) {
				Deposit deposit = (Deposit) input.readObject();
				if(deposit!=null) {
					Main.deposits.add(deposit);
				}
				else 
					read=false;
			}
			
			input.close();
			inputFile.close();
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
	}
	
	public static void save() throws IOException {	        
	        
       FileOutputStream fileOut =new FileOutputStream(Main.filenameDeposit, false);
       ObjectOutputStream out = new ObjectOutputStream(fileOut);
	   for(int i=0; i<Main.deposits.size(); i++) {
	   out.writeObject(Main.deposits.get(i));	   
	   }
	   out.close();
	   fileOut.close();
            
	}

}
