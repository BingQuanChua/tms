package view;

import javax.swing.JButton;

public class JButtonID extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String UserID;
	String MaterialID; // For Mark As Done Button Button
	
	public JButtonID(String text , String UserID){
		super(text);
		this.UserID = UserID;
		this.MaterialID = "";
	}
	
	public JButtonID(String text , String UserID, String MaterialID){
		super(text);
		this.UserID = UserID;
		this.MaterialID = MaterialID;
	}
	
	public String getUserID(){
		return UserID;
	}
	
	public String getMaterialID(){
		return MaterialID;
	}
	
	public void setUserID(String UserID){
		this.UserID = UserID;
	}
	
	public void setMaterialID(String MaterialID){
		this.MaterialID = MaterialID;
	}

}
