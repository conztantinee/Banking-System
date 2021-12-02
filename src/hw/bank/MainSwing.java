package hw.bank;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class MainSwing  {
	
	MainSwing(){
		JFrame frame= new JFrame("Banking System");
		JPanel npanel=new JPanel();
		JPanel spanel=new JPanel();
		JTextArea text= new JTextArea("WELCOME!");
		text.setEditable(false);
		JButton login=new JButton("LOGIN");
		JButton signup=new JButton("SIGN UP");
		JButton admin=new JButton("ADMIN LOGIN");
		JButton save=new JButton("SAVE ALL DATA AND QUIT");
		
		npanel.add(text);
		spanel.add(admin);
		spanel.add(login);
		spanel.add(signup);
		spanel.add(save);
		frame.add(npanel, BorderLayout.NORTH);
		frame.add(spanel, BorderLayout.SOUTH);
		admin.addActionListener(new ActionListener(){  
			  public void actionPerformed(ActionEvent e){  
					  	AdminSwing a=new AdminSwing(); 
					  	frame.dispose();
				        }  
			      });  
		login.addActionListener(new ActionListener(){  
			  public void actionPerformed(ActionEvent e){  
					  	LoginSwing a=new LoginSwing(); 
					  	frame.dispose();
				        }  
			      });  
		 signup.addActionListener(new ActionListener(){  
			  public void actionPerformed(ActionEvent e){  
			               SignupSwing a=new SignupSwing(); 
			               frame.dispose();
			          }  
			      });
		 save.addActionListener(new ActionListener(){  
			  public void actionPerformed(ActionEvent e){  
			               try {
							Deposit.save();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			               try {
							Loan.save();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			               frame.dispose();
			          }  
			      });
		 
		frame.pack();
		
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		}}
		
	
	

