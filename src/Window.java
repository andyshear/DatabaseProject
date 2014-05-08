import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;


public class Window {

	private JFrame frmTeamMonstarsProject;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frmTeamMonstarsProject.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		frmTeamMonstarsProject = new JFrame();
		frmTeamMonstarsProject.setResizable(false);
		frmTeamMonstarsProject.setTitle("Team Monstars Project");
		frmTeamMonstarsProject.setBounds(100, 100, 451, 608);
		frmTeamMonstarsProject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmTeamMonstarsProject.getContentPane().setLayout(springLayout);
		
		JButton btnSearchMood = new JButton("Search");
		springLayout.putConstraint(SpringLayout.NORTH, btnSearchMood, 32, SpringLayout.NORTH, frmTeamMonstarsProject.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnSearchMood, 322, SpringLayout.WEST, frmTeamMonstarsProject.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnSearchMood, -10, SpringLayout.EAST, frmTeamMonstarsProject.getContentPane());
		btnSearchMood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frmTeamMonstarsProject.getContentPane().add(btnSearchMood);
		
		JLabel lblYourMood = new JLabel("Your mood:");
		springLayout.putConstraint(SpringLayout.WEST, lblYourMood, 23, SpringLayout.WEST, frmTeamMonstarsProject.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblYourMood, 10, SpringLayout.NORTH, frmTeamMonstarsProject.getContentPane());
		lblYourMood.setToolTipText("Enter your preferred moods, separated by commas");
		frmTeamMonstarsProject.getContentPane().add(lblYourMood);
		
		JLabel lblYourActivity = new JLabel("Your activity:");
		springLayout.putConstraint(SpringLayout.NORTH, lblYourActivity, 35, SpringLayout.SOUTH, lblYourMood);
		springLayout.putConstraint(SpringLayout.WEST, lblYourActivity, 23, SpringLayout.WEST, frmTeamMonstarsProject.getContentPane());
		lblYourActivity.setToolTipText("Enter your preferred activities, separated by commas");
		frmTeamMonstarsProject.getContentPane().add(lblYourActivity);
		
		JButton btnSearchActivity = new JButton("Search");
		springLayout.putConstraint(SpringLayout.NORTH, btnSearchActivity, 23, SpringLayout.SOUTH, btnSearchMood);
		springLayout.putConstraint(SpringLayout.WEST, btnSearchActivity, 0, SpringLayout.WEST, btnSearchMood);
		springLayout.putConstraint(SpringLayout.EAST, btnSearchActivity, -10, SpringLayout.EAST, frmTeamMonstarsProject.getContentPane());
		frmTeamMonstarsProject.getContentPane().add(btnSearchActivity);
		
		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 23, SpringLayout.WEST, frmTeamMonstarsProject.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -95, SpringLayout.SOUTH, frmTeamMonstarsProject.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -27, SpringLayout.EAST, frmTeamMonstarsProject.getContentPane());
		frmTeamMonstarsProject.getContentPane().add(scrollPane);
		
		JList<String> list = new JList<String>();
		scrollPane.setViewportView(list);
		
		JLabel lblYouShouldListen = new JLabel("You should listen to:");
		springLayout.putConstraint(SpringLayout.NORTH, lblYouShouldListen, 54, SpringLayout.SOUTH, lblYourActivity);
		springLayout.putConstraint(SpringLayout.WEST, lblYouShouldListen, 23, SpringLayout.WEST, frmTeamMonstarsProject.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 6, SpringLayout.SOUTH, lblYouShouldListen);
		frmTeamMonstarsProject.getContentPane().add(lblYouShouldListen);
		
		JLabel lblTimeListenedTo = new JLabel("Time listened to: 0 minutes");
		springLayout.putConstraint(SpringLayout.WEST, lblTimeListenedTo, 23, SpringLayout.WEST, frmTeamMonstarsProject.getContentPane());
		lblTimeListenedTo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		springLayout.putConstraint(SpringLayout.NORTH, lblTimeListenedTo, 17, SpringLayout.SOUTH, scrollPane);
		frmTeamMonstarsProject.getContentPane().add(lblTimeListenedTo);
		
		final JComboBox<String> moods = new JComboBox<String>();
		moods.setModel(new DefaultComboBoxModel<String>(new String[] {"Chill", "Energetic", "Uplifting"}));
		springLayout.putConstraint(SpringLayout.NORTH, moods, -24, SpringLayout.NORTH, lblYourActivity);
		springLayout.putConstraint(SpringLayout.WEST, moods, 23, SpringLayout.WEST, frmTeamMonstarsProject.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, moods, -4, SpringLayout.NORTH, lblYourActivity);
		springLayout.putConstraint(SpringLayout.EAST, moods, -6, SpringLayout.WEST, btnSearchMood);
		frmTeamMonstarsProject.getContentPane().add(moods);
		
		final JComboBox<String> activities = new JComboBox<String>();
		activities.setModel(new DefaultComboBoxModel<String>(new String[] {"Relaxing", "Driving", "Partying", "Sitting in the Sun", "Studying", "Working Out"}));
		springLayout.putConstraint(SpringLayout.NORTH, activities, -20, SpringLayout.SOUTH, btnSearchActivity);
		springLayout.putConstraint(SpringLayout.WEST, activities, 23, SpringLayout.WEST, frmTeamMonstarsProject.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, activities, 0, SpringLayout.SOUTH, btnSearchActivity);
		springLayout.putConstraint(SpringLayout.EAST, activities, 0, SpringLayout.EAST, moods);
		frmTeamMonstarsProject.getContentPane().add(activities);
		
		//NON GENERATED CODE
		
		try {
			Controller.instance = new Controller(lblTimeListenedTo, list);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		btnSearchMood.addActionListener(new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Controller.instance.searchForMoods(moods.getSelectedItem().toString());
			}
			
		});
		btnSearchActivity.addActionListener(new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Controller.instance.searchForActivities(activities.getSelectedItem().toString());				
			}
			
		});
		frmTeamMonstarsProject.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				Controller.instance.closeDatabase();
			}
		});
	}
}
