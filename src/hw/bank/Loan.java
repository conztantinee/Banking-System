package hw.bank;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Loan extends Account implements Serializable {
	
	double debt;

	public Loan(String n, String p) {
		super(n, p);
		// TODO Auto-generated constructor stub
	}

	public double getDebt() {
		return debt;
	}

	public void setDebt(double debt) {
		this.debt = debt;
	}

	
	
	public void transaction(double amount) {
		this.debt=this.debt-amount;
	}
	
	public static void load() {
		try {
			FileInputStream inputFile = new FileInputStream(Main.filenameLoan);
			ObjectInputStream input = new ObjectInputStream(inputFile);
			boolean read = true;
			while(read) {
				Loan loan = (Loan) input.readObject();
				if(loan!=null) {
					Main.loans.add(loan);
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
	        
       FileOutputStream fileOut =new FileOutputStream(Main.filenameLoan, false);
       ObjectOutputStream out = new ObjectOutputStream(fileOut);
	   for(int i=0; i<Main.loans.size(); i++) {
	   out.writeObject(Main.loans.get(i));
	   }          
	   out.close();
	   fileOut.close();
	}

}
