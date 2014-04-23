import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;


public class Window {

	private JFrame frmTeamMonstarsProject;
	private JTextField moodText;
	private JTextField activityText;
	private JTextField nameText;

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
		frmTeamMonstarsProject.getContentPane().add(moodText);
		moodText.setColumns(10);
		
		JButton btnSearchMood = new JButton("Search");
		springLayout.putConstraint(SpringLayout.EAST, moodText, -6, SpringLayout.WEST, btnSearchMood);
		springLayout.putConstraint(SpringLayout.WEST, btnSearchMood, 322, SpringLayout.WEST, frmTeamMonstarsProject.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnSearchMood, -10, SpringLayout.EAST, frmTeamMonstarsProject.getContentPane());
		btnSearchMood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frmTeamMonstarsProject.getContentPane().add(btnSearchMood);
		
		JLabel lblYourMood = new JLabel("Your mood:");
		lblYourMood.setToolTipText("Enter your preferred moods, separated by commas");
		springLayout.putConstraint(SpringLayout.NORTH, moodText, 6, SpringLayout.SOUTH, lblYourMood);
		springLayout.putConstraint(SpringLayout.SOUTH, moodText, 29, SpringLayout.SOUTH, lblYourMood);
		springLayout.putConstraint(SpringLayout.WEST, lblYourMood, 23, SpringLayout.WEST, frmTeamMonstarsProject.getContentPane());
		frmTeamMonstarsProject.getContentPane().add(lblYourMood);
		
		JLabel lblYourActivity = new JLabel("Your activity:");
		lblYourActivity.setToolTipText("Enter your preferred activities, separated by commas");
		springLayout.putConstraint(SpringLayout.NORTH, lblYourActivity, 6, SpringLayout.SOUTH, moodText);
		springLayout.putConstraint(SpringLayout.WEST, lblYourActivity, 0, SpringLayout.WEST, moodText);
		frmTeamMonstarsProject.getContentPane().add(lblYourActivity);
		
		activityText = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, activityText, 6, SpringLayout.SOUTH, lblYourActivity);
		springLayout.putConstraint(SpringLayout.WEST, activityText, 23, SpringLayout.WEST, frmTeamMonstarsProject.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, activityText, 29, SpringLayout.SOUTH, lblYourActivity);
		springLayout.putConstraint(SpringLayout.EAST, activityText, 0, SpringLayout.EAST, moodText);
		frmTeamMonstarsProject.getContentPane().add(activityText);
		activityText.setColumns(10);
		
		JButton btnSearchActivity = new JButton("Search");
		springLayout.putConstraint(SpringLayout.NORTH, btnSearchActivity, 128, SpringLayout.NORTH, frmTeamMonstarsProject.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnSearchMood, -26, SpringLayout.NORTH, btnSearchActivity);
		springLayout.putConstraint(SpringLayout.WEST, btnSearchActivity, 322, SpringLayout.WEST, frmTeamMonstarsProject.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnSearchActivity, 0, SpringLayout.EAST, btnSearchMood);
		frmTeamMonstarsProject.getContentPane().add(btnSearchActivity);
		
		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 20, SpringLayout.WEST, frmTeamMonstarsProject.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -36, SpringLayout.SOUTH, frmTeamMonstarsProject.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 415, SpringLayout.WEST, frmTeamMonstarsProject.getContentPane());
		frmTeamMonstarsProject.getContentPane().add(scrollPane);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Artist - Title - Length"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);
		
		JLabel lblYouShouldListen = new JLabel("You should listen to:");
		springLayout.putConstraint(SpringLayout.WEST, lblYouShouldListen, 23, SpringLayout.WEST, frmTeamMonstarsProject.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblYouShouldListen, -380, SpringLayout.SOUTH, frmTeamMonstarsProject.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 6, SpringLayout.SOUTH, lblYouShouldListen);
		frmTeamMonstarsProject.getContentPane().add(lblYouShouldListen);
		
		JLabel lblYourName = new JLabel("Your name:");
		lblYourName.setToolTipText("Enter your name");
		springLayout.putConstraint(SpringLayout.NORTH, lblYourName, 10, SpringLayout.NORTH, frmTeamMonstarsProject.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblYourName, 23, SpringLayout.WEST, frmTeamMonstarsProject.getContentPane());
		frmTeamMonstarsProject.getContentPane().add(lblYourName);
		
		nameText = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, nameText, 23, SpringLayout.WEST, frmTeamMonstarsProject.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblYourMood, 6, SpringLayout.SOUTH, nameText);
		springLayout.putConstraint(SpringLayout.NORTH, nameText, 6, SpringLayout.SOUTH, lblYourName);
		springLayout.putConstraint(SpringLayout.SOUTH, nameText, 29, SpringLayout.SOUTH, lblYourName);
		frmTeamMonstarsProject.getContentPane().add(nameText);
		nameText.setColumns(10);
		
		JButton btnUserInfo = new JButton("User Info");
		springLayout.putConstraint(SpringLayout.EAST, nameText, -6, SpringLayout.WEST, btnUserInfo);
		springLayout.putConstraint(SpringLayout.NORTH, btnUserInfo, -550, SpringLayout.SOUTH, frmTeamMonstarsProject.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnUserInfo, -527, SpringLayout.SOUTH, frmTeamMonstarsProject.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnUserInfo, 0, SpringLayout.WEST, btnSearchMood);
		springLayout.putConstraint(SpringLayout.EAST, btnUserInfo, 0, SpringLayout.EAST, btnSearchMood);
		frmTeamMonstarsProject.getContentPane().add(btnUserInfo);
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
