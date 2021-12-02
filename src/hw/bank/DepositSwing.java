package hw.bank;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class DepositSwing {
	DepositSwing(int index){
		JFrame frame= new JFrame("Banking System");
		JPanel npanel=new JPanel();
		JPanel spanel=new JPanel();
		JTextArea text= new JTextArea("Account Details");
		text.setEditable(false);
		JTextArea name=new JTextArea(" NAME: ");
		name.setEditable(false);
		JTextField namefield=new JTextField(Main.deposits.get(index).name);
		namefield.setEditable(false);
		JTextArea money=new JTextArea(" MONEY: ");
		money.setEditable(false);
		JTextField moneyfield=new JTextField(String.valueOf(Main.deposits.get(index).money));
		moneyfield.setEditable(false);
		
		
		JButton store=new JButton("STORE");
				JLabel amount=new JLabel(" AMOUNT: ");
				JTextField amountfield=new JTextField("", 20);
				store.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e){
						if(Double.parseDouble(amountfield.getText())>0){
						Main.deposits.get(index).money=Double.parseDouble(amountfield.getText());
						DepositSwing newobj=new DepositSwing(index);
						frame.dispose();
						}
					}});
				
		
		
			JButton transfer=new JButton("MONEY TRANSFER");
					JLabel namefield2=new JLabel("NAME : ");
					JTextField namefield3=new JTextField("", 20);
					transfer.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e){
							try {
								Main.deposits.get(index).transfer(Double.parseDouble(amountfield.getText()), namefield3.getText());
							} catch (NumberFormatException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							LoanSwing newobj=new LoanSwing(index);
							frame.dispose();
						}});

			
		
		
		JButton withdraw=new JButton("WITHDRAW");
				
				withdraw.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e){
						if(Double.parseDouble(amountfield.getText())>0 && Double.parseDouble(amountfield.getText())<Main.deposits.get(index).money){
						Main.deposits.get(index).transaction(Double.parseDouble(amountfield.getText()));
						DepositSwing newobj=new DepositSwing(index);
						frame.dispose();
						}
						else if(Double.parseDouble(amountfield.getText())>Main.deposits.get(index).money){
							amountfield.setText(String.valueOf(Main.deposits.get(index).money));
							Main.deposits.get(index).money=0;
							DepositSwing newobj=new DepositSwing(index);
							frame.dispose();						
						}
					}});
		
		
		JButton ret=new JButton("RETURN TO MAIN MENU");
		ret.addActionListener(new ActionListener(){  
			  public void actionPerformed(ActionEvent e){
				  MainSwing a =new MainSwing();
				  frame.dispose();
			  }});
		
		spanel.add(amount);		
		spanel.add(amountfield);
		spanel.add(namefield2);
		spanel.add(namefield3);
		spanel.add(store);
		spanel.add(transfer);
		spanel.add(withdraw);
		
		npanel.add(text);	
		npanel.add(name);
		npanel.add(namefield);
		npanel.add(money);
		npanel.add(moneyfield);
		spanel.add(ret);
		frame.add(npanel, BorderLayout.NORTH);
		frame.add(spanel, BorderLayout.SOUTH);
		
		
		frame.pack();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
