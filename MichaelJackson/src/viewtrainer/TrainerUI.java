package viewtrainer;

import java.awt.Color; 
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

import view.Icon;
import view.ListPanel;
import view.MenuItem;
import view.SubMenu;
import view.UserProfile;
import mj.UserProfileController;
import view.ChangePassword;

public class TrainerUI extends JFrame {

	/**
	 * Trainer interface (currently extends JFrame, will change to JPanel later)
	 */
	
	private static final long serialVersionUID = 1L;
	// private JPanel contentPane;
	private JScrollPane jScrollPane1;
	private JPanel menus;
    private JPanel panelBody;
    private JPanel panelHeader;
    private JPanel panelMenu;
    
    private JButton logoButton;
    private JButton signOutButton;
    
    private ListPanel trainingList;
    private SubMenu subMenuMTC;
    private ListPanel trainingProgressList;
    private SubMenu subMenuTP;
    private ChangePassword changePassword;
    private UserProfile profile;
    private UserProfileController profileController;
    private Icon icon;
    
    //Profile
    private JPanel panelMenuHeader;
    private JButton profileButton;
    private JButton accountSettingButton;
    private Icon profileIcon;
    
	Font heading1 = new Font(Font.SERIF, Font.PLAIN, 30);

	// Constructor
	public TrainerUI() {
		super("MJ Training Management System");
		initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        trainerUI(); //Based on role		
	}
	
	private void initComponents() {

        panelHeader = new JPanel();	//Top header panel
        panelMenu = new JPanel();	//Left root panel
        jScrollPane1 = new JScrollPane(); //Able to scroll
        menus = new JPanel();		//Left panel that store all submenu
        panelBody = new JPanel();	//Right root panel
        changePassword = new ChangePassword();// Change password panel
        
        // list of assigned training 
        trainingList = new ListPanel();
        subMenuMTC = new SubMenu("Manage Training Course", trainingList);
        // dummy data for trainingList
        trainingList.addItem(new Training("Python Advance Training Course"));
        trainingList.addItem(new Training("Software Engineering with Java"));
        trainingList.addItem(new Training("Introduction to OOPDS"));
        
        // list of training progress
        trainingProgressList = new ListPanel();
        subMenuTP = new SubMenu("Training Progress", trainingProgressList);
        // dummy data for trainingProgressList
        trainingProgressList.addItem(new TrainingProgress("Python Advance Training Course"));
        trainingProgressList.addItem(new TrainingProgress("Software Engineering with Java"));
        trainingProgressList.addItem(new TrainingProgress("Introduction to OOPDS"));

        icon = new Icon();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        //Top header panel
        panelHeader.setBackground(new Color(233, 150, 122)); 
        panelHeader.setPreferredSize(new Dimension(500, 120));
        
        
        /**************************************************************
         * Profile (Show profile and profile setting)
         **************************************************************/
        panelMenuHeader = new JPanel(); //Left header panel for profile
        profileIcon = new Icon();		//Set Icon in button
      
        panelMenuHeader.setBackground(new Color(255,218,185)); //
        panelMenuHeader.setLayout(new javax.swing.BoxLayout(panelMenuHeader, javax.swing.BoxLayout.Y_AXIS));
        panelMenuHeader.setSize(new Dimension(Integer.MAX_VALUE, 130));
        panelMenuHeader.setMaximumSize(new Dimension(Integer.MAX_VALUE, 130));
        panelMenuHeader.setMinimumSize(new Dimension(Integer.MAX_VALUE, 130));
        //Profile setting
        profile = new UserProfile();
        SubMenu subProfile = new SubMenu("Profile", profile);
        profileButton = new JButton("Trainer Profile");
        profileButton.addActionListener(new ActionListener() { 
        	  public void actionPerformed(ActionEvent e) { 
        		  panelBody.removeAll();
                  panelBody.add(subProfile);
                  panelBody.repaint();
                  panelBody.revalidate();
        	  } 
        	} );
        profileButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        profileButton.setBackground(null);
        accountSettingButton = new JButton("Change Password");
        accountSettingButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 panelBody.removeAll();
                 panelBody.add(new SubMenu("Change Password",changePassword));
                 panelBody.repaint();
                 panelBody.revalidate();
        	}
        });
        profileController =  new UserProfileController(profile);
        accountSettingButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        accountSettingButton.setBackground(null);
        panelMenuHeader.add(profileButton);
        panelMenuHeader.add(Box.createRigidArea(new Dimension(10,10)));
        panelMenuHeader.add(accountSettingButton);
        menus.add(panelMenuHeader);
        /**************************************************************
         * Profile 
         **************************************************************/
        
        
        
        // Clickable logo in the top header panel
        logoButton = new JButton();
        logoButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		home();
        	}
        });
        logoButton.setBackground(null);
        logoButton.setBorder(null);
        try {
        	File logoPath = new File("src/images/logo.png");
			Image originalLogo = ImageIO.read(logoPath);
        	Image logo = originalLogo.getScaledInstance(370, 120, Image.SCALE_DEFAULT);
        	logoButton.setIcon(new ImageIcon(logo));
        	/**profile**********************************************************************/
        	File profIconPath = new File("src/images/profileLogo.png");
			Image profIcon = ImageIO.read(profIconPath);
        	Image profileIcon = profIcon.getScaledInstance(75, 75, Image.SCALE_DEFAULT);
        	profileButton.setIcon(new ImageIcon(profileIcon));
        	/*******************************************************************************/
        }
        catch (Exception ex) {
        	System.out.println("Trainer Image not found");
        }
        
        // Sign out button in the top header panel
        signOutButton = new JButton("Sign Out");
        // signOutButton.setForeground(Color.WHITE);
        signOutButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		// Need to handle this later
        		System.exit(0); 
        	}
        });
        signOutButton.setBackground(null);
        signOutButton.setBorder(null);

        GroupLayout panelHeaderLayout = new GroupLayout(panelHeader);
        panelHeaderLayout.setHorizontalGroup(
            	panelHeaderLayout.createParallelGroup(Alignment.LEADING)
            		.addGroup(panelHeaderLayout.createSequentialGroup()
            			.addContainerGap()
            			.addComponent(logoButton, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
            			.addGap(1404)
            			.addComponent(signOutButton, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
            			.addContainerGap(39, Short.MAX_VALUE))
        );
        panelHeaderLayout.setVerticalGroup(
            	panelHeaderLayout.createParallelGroup(Alignment.TRAILING)
            		.addGroup(panelHeaderLayout.createSequentialGroup()
            			.addGroup(panelHeaderLayout.createParallelGroup(Alignment.LEADING)
            				.addComponent(logoButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            				.addGroup(panelHeaderLayout.createSequentialGroup()
            					.addGap(80)
            					.addComponent(signOutButton, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)))
            			.addContainerGap())
        );
        panelHeader.setLayout(panelHeaderLayout);
        getContentPane().add(panelHeader, java.awt.BorderLayout.PAGE_START);

        //Left root panel
        panelMenu.setBackground(new Color(204, 204, 204));
        panelMenu.setPreferredSize(new Dimension(300, 384));

        //Able to scroll
        jScrollPane1.setBorder(null);

        //Left panel that store all submenu
        menus.setBackground(new Color(255, 255, 255)); //White
        menus.setLayout(new javax.swing.BoxLayout(menus, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(menus);

        GroupLayout panelMenuLayout = new GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
        );

        getContentPane().add(panelMenu, java.awt.BorderLayout.LINE_START);

        panelBody.setBackground(new Color(255, 255, 200));
        panelBody.setLayout(new java.awt.BorderLayout());
        JScrollPane scrollPane = new JScrollPane(panelBody);
        getContentPane().add(scrollPane, java.awt.BorderLayout.CENTER);

        setSize(new Dimension(871, 473));
        setLocationRelativeTo(null);
    }
	
	public ListPanel getTrainingList() {
		return trainingList;
	}
	
	public ListPanel getTrainingProgressList() {
		return trainingProgressList;
	}
	
	public JPanel getPanelBody() {
		return panelBody;
	}
	
	
	// This method is called from within the constructor to initialize the form.
	private void trainerUI() {
		MenuItem menuMTC = new MenuItem(" -- Manage Training Course", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            	panelBody.removeAll();
                panelBody.add(subMenuMTC);
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        MenuItem menuTP = new MenuItem(" -- Training Progress", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            	panelBody.removeAll();
                panelBody.add(subMenuTP);
                panelBody.repaint();
                panelBody.revalidate();
            }
        });

        MenuItem menuTraining = new MenuItem("Training", null, menuMTC, menuTP);
        menuTraining.setBackground(new Color(250, 240, 230));
        addMenu(menuTraining);
        home(); //show home menu initially
	} 
	
	// Add all subMenu into menus
    private void addMenu(MenuItem menu) {
        
       menus.add(menu);
       ArrayList<MenuItem> subMenu = menu.getSubMenu();
       for (MenuItem m : subMenu) {
           addMenu(m);
       }
        
        menus.revalidate();
    }
    
    // Setting the panelBody (Home menu)
    public void home() {
    	panelBody.removeAll();
    	panelBody.add(icon);
        panelBody.repaint();
        panelBody.revalidate();
    }
}
