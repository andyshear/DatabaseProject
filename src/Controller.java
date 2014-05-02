import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import javax.swing.JList;


public class Controller {
	public static Controller instance;
	private String timeListened = "Time listened to: %.2f minutes";
	
	private JLabel listenedTo;
	private SongList list;
	
	public Controller(JLabel listenedTo, JList<String> displaySongsList) {
		this.listenedTo = listenedTo;
		list = new SongList();
		displaySongsList.setModel(list);
	}
	
	/**
	 * Search for the given moods, updating the playlist
	 * @param moodList A list of moods, separated by commas, from the "Mood" box.
	 */
	public void searchForMoods(String moodList) {
		String moodName = input.nextLine();
	  
		ResultSet moodPlaylist = statement.executeQuery("INSERT INTO MOOD_PLAYLIST SELECT SONG_ID, MOOD_NAME FROM MOOD LEFT JOIN MOOD ON MOOD_PLAYLIST.MOOD_NAME = " + moodName + ";");
	}
	
	/**
	 * Search for the given activities, updating the playlist
	 * @param activityList A list of activities, separated by commas, from the "Activity" box.
	 */
	public void searchForActivities(String activityList) {
		String activityName = input.nextLine();
	  
		ResultSet activityPlaylist = statement.executeQuery("INSERT INTO ACTIVITY_PLAYLIST SELECT SONG_ID, ACTIVITY_NAME FROM ACTIVITY LEFT JOIN ACTIVITY ON ACTIVITY_PLAYLIST.ACTIVITY_NAME = " + activityName + ";");
	}
	
	/**
	 * Update the playlist with the given list of songs.
	 * @param songs Songs to display on the playlist
	 */
	public void updatePlaylist(String[] songs) {
		list.set(songs);
	}
	
	/**
	 * Update the time listened
	 * @param time Time to display
	 */
	public void setTimeListened(double time) {
		listenedTo.setText(String.format(timeListened, time));
	}
	
	@SuppressWarnings("serial")
	public static class SongList extends AbstractListModel<String> {
		private ArrayList<String> list = new ArrayList<String>();
		
		@Override
		public int getSize() {
			return list.size();
		}

		@Override
		public String getElementAt(int index) {
			return list.get(index);
		}
		
		public void set(String[] values) {
			int curSize = list.size();
			list.clear();
			this.fireIntervalRemoved(this, 0, curSize);
			list.addAll(Arrays.asList(values));
			this.fireIntervalAdded(this, 0, list.size());
		}
	}
	
}
