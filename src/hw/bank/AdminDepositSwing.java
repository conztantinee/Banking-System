package hw.bank;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AdminDepositSwing {
	AdminDepositSwing(){
		
		JFrame frame=new JFrame("Loan Table");
		for(int i=0; i<Main.deposits.size(); i++) {
			AdminSwing.arrd[i][0]=String.valueOf(i);
			AdminSwing.arrd[i][1]=Main.deposits.get(i).name;
			AdminSwing.arrd[i][2]=String.valueOf(Main.deposits.get(i).money);
		}
		
		
		JTable table=new JTable(AdminSwing.arrd, AdminSwing.named);
		table.setBounds(30,40,200,300);          
	    JScrollPane scroll=new JScrollPane(table);    
	    frame.add(scroll);          
	    frame.setSize(300,400);    
	    frame.setVisible(true); 
}
}