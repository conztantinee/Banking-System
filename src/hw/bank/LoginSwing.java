package hw.bank;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginSwing {
	static int index;
	LoginSwing(){
		JFrame frame=new JFrame("Banking System");
		JPanel npanel=new JPanel();
		JPanel spanel=new JPanel();
		JTextArea text= new JTextArea("Log In To Your Account");
		text.setEditable(false);
		JTextArea name=new JTextArea("ENTER YOUR NAME:");
		name.setEditable(false);
		JTextField namefield=new JTextField("",20);
		JTextArea password=new JTextArea("ENTER YOUR PASSWORD : ");
		password.setEditable(false);
		JTextField passwordfield=new JTextField("",20);
		JTextArea type=new JTextArea("Select type:");
		type.setEditable(false);
		String typearr[]= {"Loan", "Deposit"};
		JComboBox typebox=new JComboBox(typearr);
		
		JButton login=new JButton("LOG IN") ;
		login.addActionListener(new ActionListener(){  
			  public void actionPerformed(ActionEvent e){ 
				boolean accexists=false;
				if(typebox.getItemAt(typebox.getSelectedIndex()).equals("Loan")) {
					for(int i=0;i<Main.loans.size(); i++) {
						if(namefield.getText().equals(Main.loans.get(i).name)&&passwordfield.getText().equals(Main.loans.get(i).password)){
							accexists=true;
							index=i;
							LoanSwing obj=new LoanSwing(index);
							frame.dispose();
						}
					}
				}
				else if(typebox.getItemAt(typebox.getSelectedIndex()).equals("Deposit")) {
					for(int i=0;i<Main.deposits.size(); i++) {
						if(namefield.getText().equals(Main.deposits.get(i).name)&&passwordfield.getText().equals(Main.deposits.get(i).password)){
							accexists=true;
							index=i;
							DepositSwing obj=new DepositSwing(index);
							frame.dispose();
						}
					}
				}
				if(!accexists) {
					JOptionPane.showMessageDialog(null, "There's no such account");
				}
			  }
			  });
		
		JButton ret=new JButton("RETURN BACK");
		ret.addActionListener(new ActionListener(){  
			  public void actionPerformed(ActionEvent e){
				  MainSwing a =new MainSwing();
				  frame.dispose();
			  }});
		
		npanel.add(text);
		npanel.add(name);
		npanel.add(namefield);
		npanel.add(password);
		npanel.add(passwordfield);
		npanel.add(type);
		npanel.add(typebox);
		spanel.add(login);
		spanel.add(ret);
		frame.add(npanel, BorderLayout.NORTH);
		frame.add(spanel, BorderLayout.SOUTH);
		
		
		frame.pack();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
