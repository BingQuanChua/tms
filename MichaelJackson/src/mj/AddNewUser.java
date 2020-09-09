package mj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AddNewUser extends JPanel {
    
    AddNewUser() {
    	setBackground(new Color(255, 255, 224));
    	
    	JPanel addNewUserPanel = new JPanel();
    	addNewUserPanel.setBounds(0, 0, 1600, 1080);
        JPanel frontPanel = new JPanel();
        JSeparator separator_1 = new JSeparator();
        JSeparator separator_2 = new JSeparator();
        JTextField userIDField = new JTextField(20);
        JTextField passwordField = new JTextField(20);
        JCheckBox trainerBox = new JCheckBox("New Trainer", true);
        JCheckBox traineeBox = new JCheckBox("New Trainee", true);
        JButton addButton = new JButton("Add");
        JButton cancelButton = new JButton("Cancel");
        JLabel lblUserID = new JLabel("UserID");
        JLabel lblPassword = new JLabel("Password\r\n");
        JPanel NavPanel = new JPanel();
        Font heading1 = new Font(Font.SERIF, Font.PLAIN, 40);
        Font f1 = new Font(Font.DIALOG, Font.PLAIN, 20);
       
        //Add New User panel //        
        addNewUserPanel.setPreferredSize(new Dimension(1600, 1080));
        addNewUserPanel.setBackground(new Color(255, 255, 224));
        addNewUserPanel.setLayout(null);      
        
        //Front Panel//
        frontPanel.setForeground(SystemColor.desktop);
        frontPanel.setBounds(277, 121, 1000, 762);
        frontPanel.setBackground(Color.WHITE);
        frontPanel.setLayout(null);
        addNewUserPanel.add(frontPanel);
        
        //Separator//       
        separator_1.setBackground(Color.GRAY);
        separator_1.setForeground(Color.GRAY);
        separator_1.setBounds(230, 243, 600, 2);
        frontPanel.add(separator_1);
               
        separator_2.setForeground(Color.GRAY);
        separator_2.setBackground(Color.GRAY);
        separator_2.setBounds(230, 440, 600, 2);
        frontPanel.add(separator_2);
        
        //TextField// 
        userIDField.setText("Enter userID");
        userIDField.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent e) {
        		if(userIDField.getText().trim().equals("Enter userID")) 
        	         userIDField.setText("");
        	}
        	@Override
        	public void focusLost(FocusEvent e) {
        		 if(userIDField.getText().trim().equals("")) 
        	           userIDField.setText("Enter userID");
        	}
        }); 
        userIDField.setBounds(230, 152, 600, 80);
        userIDField.setForeground(Color.GRAY);
        userIDField.setFont(f1);
        userIDField.setBorder(null);
             
        passwordField.setText("Enter password\r\n");
        passwordField.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent e) {
        		  if(passwordField.getText().trim().equals("Enter password"))
        		         passwordField.setText("");
        	}
        	@Override
        	public void focusLost(FocusEvent e) {
        		if(passwordField.getText().trim().equals(""))
                    passwordField.setText("Enter password");
        	}
        });
        passwordField.setBounds(230, 352, 600, 80); 
        passwordField.setForeground(Color.GRAY);
        passwordField.setFont(f1);
        passwordField.setBorder(null);
         
        frontPanel.add(userIDField);
        frontPanel.add(passwordField);
        
        //button  
        trainerBox.setHorizontalAlignment(SwingConstants.CENTER);
        trainerBox.setBounds(230, 492, 300, 46);
        frontPanel.add(trainerBox);
        trainerBox.setForeground(Color.BLACK);
        trainerBox.setBackground(new Color(106, 90, 205));
        trainerBox.setFont(f1);
        
        traineeBox.setHorizontalAlignment(SwingConstants.CENTER);
        traineeBox.setBounds(532, 492, 300, 46);
        frontPanel.add(traineeBox);
        traineeBox.setBackground(new Color(106, 90, 205));
        traineeBox.setForeground(Color.BLACK);
        traineeBox.setFont(f1);
            
        addButton.setBackground(new Color(106, 90, 205));
        addButton.setForeground(Color.WHITE);
        addButton.setBounds(680, 669, 150, 35);
        frontPanel.add(addButton);
        addButton.setFont(f1);
             
        cancelButton.setBackground(new Color(106, 90, 205));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBounds(517, 669, 150, 35);
        frontPanel.add(cancelButton);
        cancelButton.setFont(f1);
         
        lblUserID.setForeground(Color.DARK_GRAY);
        lblUserID.setFont(new Font("Serif", Font.BOLD, 30));
        lblUserID.setBounds(230, 106, 103, 35);
        frontPanel.add(lblUserID);
         
        lblPassword.setForeground(Color.DARK_GRAY);
        lblPassword.setFont(new Font("Serif", Font.BOLD, 30));
        lblPassword.setBounds(230, 306, 150, 35);
        frontPanel.add(lblPassword);
        setPreferredSize(new Dimension(1600, 1080));
        setLayout(null);
        add(addNewUserPanel);
        
        JLabel lblUserInfo = new JLabel("User Info");
        lblUserInfo.setForeground(Color.DARK_GRAY);
        lblUserInfo.setFont(new Font("SansSerif", Font.PLAIN, 40));
        lblUserInfo.setBounds(277, 45, 379, 73);
        addNewUserPanel.add(lblUserInfo);
    
        
       
        ////end of Add New User panel///
    }
}