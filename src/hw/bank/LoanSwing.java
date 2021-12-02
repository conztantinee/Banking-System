package hw.bank;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class LoanSwing {
	LoanSwing(int index){
		JFrame frame= new JFrame("Banking System");
		JPanel npanel=new JPanel();
		JPanel spanel=new JPanel();
		JTextArea text= new JTextArea("Account Details");
		text.setEditable(false);
		JTextArea name=new JTextArea(" NAME: ");
		name.setEditable(false);
		JTextField namefield=new JTextField(Main.loans.get(index).name);
		namefield.setEditable(false);
		JTextArea debt=new JTextArea(" DEBT: ");
		debt.setEditable(false);
		JTextField debtfield=new JTextField(String.valueOf(Main.loans.get(index).debt));
		debtfield.setEditable(false);
		
		if(Main.loans.get(index).debt==0) {
			JButton take=new JButton("TAKE A LOAN");					
					JLabel amount=new JLabel(" AMOUNT: ");
					JTextField amountfield=new JTextField("",20);
					take.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e){
							Main.loans.get(index).debt=Main.loans.get(index).debt+Double.parseDouble(amountfield.getText());
							LoanSwing newobj=new LoanSwing(index);
							frame.dispose();
						
							
						}});
					spanel.add(take);
					spanel.add(amount);
					spanel.add(amountfield);
				}
			
		
		else {
		JButton repay=new JButton("REPAY");
		JLabel amount=new JLabel(" AMOUNT: ");
		JTextField amountfield=new JTextField("", 20);
		repay.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e){
						if(Double.parseDouble(amountfield.getText())>0 && Double.parseDouble(amountfield.getText())<Main.loans.get(index).debt){
							Main.loans.get(index).transaction(Double.parseDouble(amountfield.getText()));
						LoanSwing newobj=new LoanSwing(index);
						frame.dispose();
						
						}
						else if(Double.parseDouble(amountfield.getText())>0  && Double.parseDouble(amountfield.getText())>Main.loans.get(index).debt){
							amountfield.setText(String.valueOf(Main.loans.get(index).debt));
							Main.loans.get(index).transaction(Double.parseDouble(amountfield.getText()));
							LoanSwing newobj=new LoanSwing(index);
							frame.dispose();
							
						}
					}});
				spanel.add(repay);
				spanel.add(amount);
				spanel.add(amountfield);
		}
		
		
		JButton ret=new JButton("RETURN TO MAIN MENU");
		ret.addActionListener(new ActionListener(){  
			  public void actionPerformed(ActionEvent e){
				  MainSwing a =new MainSwing();
				  frame.dispose();
			  }});
		
		
		npanel.add(text);	
		npanel.add(name);
		npanel.add(namefield);
		npanel.add(debt);
		npanel.add(debtfield);
		spanel.add(ret);
		frame.add(npanel, BorderLayout.NORTH);
		frame.add(spanel, BorderLayout.SOUTH);
		
		
		frame.pack();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		try {
			Loan.save();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
