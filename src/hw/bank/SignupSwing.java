package hw.bank;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class SignupSwing {
	SignupSwing(){
		JFrame frame=new JFrame("Banking System");
		JPanel npanel=new JPanel();
		JPanel spanel=new JPanel();
		JTextArea text= new JTextArea("CREATE A NEW ACCOUNT");
		JLabel name=new JLabel("ENTER NAME: ");
		text.setEditable(false);
		JTextField namefield=new JTextField("", 20);
		JLabel password=new JLabel("PASSWORD min. 4 digits: ");
		JTextField passwordfield=new JTextField("", 20);
		JLabel type=new JLabel("Select type:");
		String typearr[]= {"Loan", "Deposit"};
		JComboBox typebox=new JComboBox(typearr);
		
		
		JButton signup=new JButton("SIGN UP NOW!");
		signup.addActionListener(new ActionListener(){  
			  public void actionPerformed(ActionEvent e){  
			               if(passwordfield.getText().length()>3) {  
			            	   
			            	   //signup for Loan
			            	  if(typebox.getItemAt(typebox.getSelectedIndex()).equals("Loan")) {
			            		  boolean existingpassword=false;
				            	   boolean existingname=false;
			            	   
				            	   for(int i=0; i<Main.loans.size(); i++) {
			            	   if(passwordfield.getText().equals(Main.loans.get(i).password)){
			            		   existingpassword=true;
			            		   JOptionPane.showMessageDialog(null, "Choose another password");
			            	   }
			            	   else if(namefield.getText().equals(Main.loans.get(i).name)) {
			            		   existingname=true;
			            		   JOptionPane.showMessageDialog(null, "Choose another name");
			            	   }
			            	   }
			            	   if(!existingpassword && !existingname) {
			            	   Loan obj=new Loan(namefield.getText(),passwordfield.getText());
		            			  obj.debt=0;
		            			  Main.loans.add(obj);
		            			  MainSwing a=new MainSwing();
		            			  frame.dispose();
		            			  try {
									Loan.save();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}}}
			            	  
			            	  
			            	  //signup for deposit
			            	  else if(typebox.getItemAt(typebox.getSelectedIndex()).equals("Deposit")) {
			            		  boolean existingpassword=false;
				            	   boolean existingname=false;
			            		  for(int i=0; i<Main.deposits.size(); i++) {
					            	   if(passwordfield.getText().equals(Main.deposits.get(i).password)){
					            		   existingpassword=true;
					            		   JOptionPane.showMessageDialog(null, "Choose another password");
					            	   }
					            	   else if(namefield.getText().equals(Main.deposits.get(i).name)) {
					            		   existingname=true;
					            		   JOptionPane.showMessageDialog(null, "Choose another name");
					            	   }
					            	   }
					            	   if(!existingpassword && !existingname) {
					            	   Deposit obj=new Deposit(namefield.getText(),passwordfield.getText());
				            			  obj.money=0;
				            			  Main.deposits.add(obj);
				            			  MainSwing a=new MainSwing();
				            			  frame.dispose();
				            			 }
			            	  }}
			            	  
			            				  
			               else {
			            	   JOptionPane.showMessageDialog(null, "Password must be at least 4 digits");
			               }
			               }} );
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
		spanel.add(signup);
		spanel.add(ret);
		frame.add(npanel, BorderLayout.NORTH);
		frame.add(spanel, BorderLayout.SOUTH);
		
		
		frame.pack();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

}
