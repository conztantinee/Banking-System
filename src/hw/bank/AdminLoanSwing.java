package hw.bank;


import javax.swing.*;

public class AdminLoanSwing {
	AdminLoanSwing(){
		JFrame frame=new JFrame("Loan Table");
		for(int i=0; i<Main.loans.size(); i++) {
			AdminSwing.arrl[i][0]=String.valueOf(i);
			AdminSwing.arrl[i][1]=Main.loans.get(i).name;
			AdminSwing.arrl[i][2]=String.valueOf(Main.loans.get(i).debt);
		}
		JTable table=new JTable(AdminSwing.arrl, AdminSwing.namel);
		table.setBounds(30,40,200,300);          
	    JScrollPane scroll=new JScrollPane(table);    
	    frame.add(scroll);          
	    frame.setSize(300,400);    
	    frame.setVisible(true); 
	}
}
