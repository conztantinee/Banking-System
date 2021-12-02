package hw.bank;


import java.io.IOException;
import java.util.ArrayList;

public class Main {
	
	public static ArrayList<Loan> loans= new ArrayList<Loan>();
	public static ArrayList<Deposit> deposits= new ArrayList<Deposit>();
	
	public static String filenameLoan="C:\\Users\\kamal\\eclipse-workspace\\Banking System\\src\\loan.ser";
	public static String filenameDeposit="C:\\Users\\kamal\\eclipse-workspace\\Banking System\\src\\deposit.ser";
	
	static public void main(String[] args) {
	Loan.load();
	Deposit.load();
	MainSwing a=new MainSwing();
	
	}
}
