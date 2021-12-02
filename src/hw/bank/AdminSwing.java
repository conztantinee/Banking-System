package hw.bank;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class AdminSwing  {
	
	public static String arrl[][]=new String[50][50];
	public static String namel[]= {"#", "NAME", "DEBT"};
	
	public static String arrd[][]=new String[50][50];
	public static String named[]= {"#", "NAME", "MONEY"};
	
	AdminSwing(){
		JFrame frame= new JFrame("Banking System");
		JPanel panel=new JPanel();	
		
		JMenuItem mItem1 = new JMenuItem("Loan");
		JMenuItem mItem2 = new JMenuItem("Deposit");
		mItem1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {    
				  AdminLoanSwing a=new AdminLoanSwing();
				} 
		});    
		mItem2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {    
				AdminDepositSwing a=new AdminDepositSwing();
				} 
		});   
		
		
		
		JButton ret=new JButton("RETURN BACK");
		ret.addActionListener(new ActionListener(){  
			  public void actionPerformed(ActionEvent e){
				  MainSwing a =new MainSwing();
				  frame.dispose();
			  }});
		
		panel.add(ret);
		frame.add(panel, BorderLayout.SOUTH);
		
		JMenu menu = new JMenu("Type");
		menu.add(mItem1);
		menu.add(mItem2);
		JMenuBar bar = new JMenuBar();
		bar.add(menu);
		frame.setJMenuBar(bar);
		
		
		
		frame.setSize(300,400);
		frame.pack();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}


    }
