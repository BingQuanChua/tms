package mj;

import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class TraineeUI extends JFrame {
	
	// Variables declaration
    private JScrollPane jScrollPane1;
    private JPanel menus;
    private JPanel panelBody;
    private JPanel panelHeader;
    private JPanel panelMenu;
    
    private JButton logoButton;
    private JButton signOutButton;
    
    private List availableTrainingList;
    private SubMenu subMenuATC;
    private List enrolledTrainingList;
    private SubMenu subMenuETC;
    private Icon icon;
    
    Font heading1 = new Font(Font.SERIF, Font.PLAIN, 30);
    
    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TraineeUI frame = new TraineeUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 
    //Constructor
    public TraineeUI() {
    	super("MJ Training Management System");
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        traineeUI(); //Based on role
    }
    

	// This method is called from within the constructor to initialize the form.
    private void initComponents() {

        panelHeader = new JPanel();	//Top header panel
        panelMenu = new JPanel();	//Left root panel
        jScrollPane1 = new JScrollPane(); //Able to scroll
        menus = new JPanel();		//Left panel that store all submenu
        panelBody = new JPanel();	//Right root panel
        
        availableTrainingList = new List();
        subMenuATC = new SubMenu("Available Training Course", availableTrainingList);
        // dummy data for trainingList
        availableTrainingList.addItem(new AvailableTraining("Python Advance Training Course", "Dr Liew Kuan Yung"));
        availableTrainingList.addItem(new AvailableTraining("Software Engineering with Java", "Dr Yap Mou En"));
		availableTrainingList.addItem(new AvailableTraining("Introduction to OOPDS", "Dr Suddhish"));
        //////
        enrolledTrainingList = new List(); //
        subMenuETC = new SubMenu("Enrolled Training Course", enrolledTrainingList);
        // dummy data for trainingList
        enrolledTrainingList.addItem(new EnrolledTraining("Python Advance Training Course"));
        enrolledTrainingList.addItem(new EnrolledTraining("Software Engineering with Java"));
		enrolledTrainingList.addItem(new EnrolledTraining("Introduction to OOPDS"));
        icon = new Icon();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        //Top header panel
        panelHeader.setBackground(new Color(233, 150, 122)); //Purple
        panelHeader.setPreferredSize(new Dimension(500, 120));
        
        //Clickable logo in the top header panel
        logoButton = new JButton();
        logoButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		home();
        	}
        });
        logoButton.setBackground(null);
        logoButton.setBorder(null);
        try {
        	Image originalLogo = ImageIO.read(getClass().getResource("images/logo.PNG"));
        	Image logo = originalLogo.getScaledInstance(370, 120, Image.SCALE_DEFAULT);
        	logoButton.setIcon(new ImageIcon(logo));
        }
        catch (Exception ex) {
        	System.out.println("Image not found");
        }
        
        // Sign out button in the top header panel
        signOutButton = new JButton("Sign Out");
        signOutButton.setForeground(Color.WHITE);
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
        			.addPreferredGap(ComponentPlacement.RELATED, 385, Short.MAX_VALUE)
        			.addComponent(signOutButton)
        			.addGap(37))
        );
        panelHeaderLayout.setVerticalGroup(
        	panelHeaderLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(panelHeaderLayout.createSequentialGroup()
        			.addComponent(logoButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addContainerGap())
        		.addGroup(panelHeaderLayout.createSequentialGroup()
        			.addContainerGap(93, Short.MAX_VALUE)
        			.addComponent(signOutButton)
        			.addGap(24))
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
   
    // This method is called from within the constructor to initialize the form.
    private void traineeUI() {
    	
        //  create subMenu Training
        MenuItem menuMTC = new MenuItem(" -- Available Training Course", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            	panelBody.removeAll();
                panelBody.add(subMenuATC);
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        MenuItem menuTP = new MenuItem(" -- Enrolled Training Course", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            	panelBody.removeAll();
                panelBody.add(subMenuETC);
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        
        MenuItem menuTraining = new MenuItem("Training", null, menuMTC, menuTP);
        addMenu(menuTraining);
        home(); //show home menu initially
    }

    // Add all subMenu into menus
    private void addMenu(MenuItem... menu) {
        for (int i = 0; i < menu.length; i++) {
            menus.add(menu[i]);
            ArrayList<MenuItem> subMenu = menu[i].getSubMenu();
            for (MenuItem m : subMenu) {
                addMenu(m);
            }
        }
        menus.revalidate();
    }
    
    // Setting the panelBody (Home menu)
    private void home() {
    	panelBody.removeAll();
    	panelBody.add(icon);
        panelBody.repaint();
        panelBody.revalidate();
    }
}
