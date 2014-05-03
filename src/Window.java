import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import java.awt.Font;


public class Window {

	private JFrame frmTeamMonstarsProject;
	private JTextField moodText;
	private JTextField activityText;

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
		
		moodText = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, moodText, 23, SpringLayout.WEST, frmTeamMonstarsProject.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, moodText, -522, SpringLayout.SOUTH, frmTeamMonstarsProject.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, moodText, -129, SpringLayout.EAST, frmTeamMonstarsProject.getContentPane());
		frmTeamMonstarsProject.getContentPane().add(moodText);
		moodText.setColumns(10);
		
		JButton btnSearchMood = new JButton("Search");
		springLayout.putConstraint(SpringLayout.NORTH, btnSearchMood, 32, SpringLayout.NORTH, frmTeamMonstarsProject.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnSearchMood, 6, SpringLayout.EAST, moodText);
		springLayout.putConstraint(SpringLayout.EAST, btnSearchMood, -10, SpringLayout.EAST, frmTeamMonstarsProject.getContentPane());
		btnSearchMood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frmTeamMonstarsProject.getContentPane().add(btnSearchMood);
		
		JLabel lblYourMood = new JLabel("Your mood:");
		springLayout.putConstraint(SpringLayout.NORTH, moodText, 6, SpringLayout.SOUTH, lblYourMood);
		springLayout.putConstraint(SpringLayout.WEST, lblYourMood, 23, SpringLayout.WEST, frmTeamMonstarsProject.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblYourMood, 10, SpringLayout.NORTH, frmTeamMonstarsProject.getContentPane());
		lblYourMood.setToolTipText("Enter your preferred moods, separated by commas");
		frmTeamMonstarsProject.getContentPane().add(lblYourMood);
		
		JLabel lblYourActivity = new JLabel("Your activity:");
		springLayout.putConstraint(SpringLayout.NORTH, lblYourActivity, 1, SpringLayout.SOUTH, moodText);
		springLayout.putConstraint(SpringLayout.WEST, lblYourActivity, 23, SpringLayout.WEST, frmTeamMonstarsProject.getContentPane());
		lblYourActivity.setToolTipText("Enter your preferred activities, separated by commas");
		frmTeamMonstarsProject.getContentPane().add(lblYourActivity);
		
		activityText = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, activityText, 6, SpringLayout.SOUTH, lblYourActivity);
		springLayout.putConstraint(SpringLayout.WEST, activityText, 23, SpringLayout.WEST, frmTeamMonstarsProject.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, activityText, -473, SpringLayout.SOUTH, frmTeamMonstarsProject.getContentPane());
		frmTeamMonstarsProject.getContentPane().add(activityText);
		activityText.setColumns(10);
		
		JButton btnSearchActivity = new JButton("Search");
		springLayout.putConstraint(SpringLayout.NORTH, btnSearchActivity, 23, SpringLayout.SOUTH, btnSearchMood);
		springLayout.putConstraint(SpringLayout.EAST, activityText, -6, SpringLayout.WEST, btnSearchActivity);
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
		springLayout.putConstraint(SpringLayout.NORTH, lblYouShouldListen, 20, SpringLayout.SOUTH, activityText);
		springLayout.putConstraint(SpringLayout.WEST, lblYouShouldListen, 23, SpringLayout.WEST, frmTeamMonstarsProject.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 6, SpringLayout.SOUTH, lblYouShouldListen);
		frmTeamMonstarsProject.getContentPane().add(lblYouShouldListen);
		
		JLabel lblTimeListenedTo = new JLabel("Time listened to: 0 minutes");
		springLayout.putConstraint(SpringLayout.WEST, lblTimeListenedTo, 23, SpringLayout.WEST, frmTeamMonstarsProject.getContentPane());
		lblTimeListenedTo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		springLayout.putConstraint(SpringLayout.NORTH, lblTimeListenedTo, 17, SpringLayout.SOUTH, scrollPane);
		frmTeamMonstarsProject.getContentPane().add(lblTimeListenedTo);
		
		//NON-GENERATED CODE
		
		try {
			Controller.instance = new Controller(lblTimeListenedTo, list);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		btnSearchMood.addActionListener(new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Controller.instance.searchForMoods(moodText.getText());
			}
			
		});
		btnSearchActivity.addActionListener(new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Controller.instance.searchForActivities(activityText.getText());				
			}
			
		});
		frmTeamMonstarsProject.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				Controller.instance.closeDatabase();
			}
		});
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
