import java.sql.*;

import java.util.Scanner;

public class Prototype
{
  public static void main(String[] args) throws ClassNotFoundException
  {
    // load the sqlite-JDBC driver using the current class loader
    Class.forName("org.sqlite.JDBC");

    Connection connection = null;
    try
    {
      // create a database connection
      connection = DriverManager.getConnection("jdbc:sqlite:finalProject.db");
      Statement statement = connection.createStatement();
      statement.setQueryTimeout(30);  // set timeout to 30 sec.
	  
	  Scanner input = new Scanner(System.in);
	  
	  
	  /**
	   * CREATE TABLE STATEMENTS
	   */
	  
	  String songs = "SONGS " +
              "(SONG_ID INT PRIMARY KEY     NOT NULL," +
              " NAME           CHAR(50)    NOT NULL, " + 
              " ARTIST         CHAR(50)    NOT NULL, " + 
              " GENRE          CHAR(50)    NOT NULL, " + 
              " LENGTH         REAL    NOT NULL, " +
              " RATING         INT, " +
              " ALBUM          CHAR(50)    NOT NULL)";
	  statement.executeUpdate(songs);
	  
	  String moodPlaylist = "MOOD_PLAYLIST " +
              "(MOOD_NAME        CHAR(30) PRIMARY KEY     NOT NULL," +
              " TIME_LISTENED         REAL    NOT NULL);";
	  statement.executeUpdate(moodPlaylist);
	  
	  String activityPlaylist = "ACTIVITY_PLAYLIST " +
              "(ACTIVITY_NAME        CHAR(30) PRIMARY KEY     NOT NULL," +
              " TIME_LISTENED         REAL    NOT NULL);";
	  statement.executeUpdate(activityPlaylist);
	  
	  String activity = "ACTIVITY " +
              "(SONG_ID        INT PRIMARY KEY     NOT NULL," +
              " ACTIVITY_NAME           CHAR(30) PRIMARY KEY    NOT NULL, " +
              " FOREIGN KEY(ACTIVITY_NAME) REFERENCES ACTIVITY_PLAYLIST(ACTIVITY_NAME), " +
              " FOREIGN KEY(SONG_ID) REFERENCES SONG(SONG_ID));";
	  statement.executeUpdate(activity);
	  
	  String mood = "MOOD " +
              "(SONG_ID        INT PRIMARY KEY     NOT NULL," +
              " MOOD_NAME           CHAR(30) PRIMARY KEY    NOT NULL, " +
              " FOREIGN KEY(MOOD_NAME) REFERENCES MOOD_PLAYLIST(MOOD_NAME), " +
              " FOREIGN KEY(SONG_ID) REFERENCES SONG(SONG_ID));";
	  statement.executeUpdate(mood);
	  
	  /**
	   * ADD SONGS FUNCTION
	   */
	  String loadSongs = "LOAD DATA INFILE '"+filename+"' INTO TABLE SONGS (SONG_ID, NAME, ARTIST, GENRE, LENGTH, RATING, ALBUM);";
      statement.executeUpdate(loadSongs);
	  
	  String loadMood = "LOAD DATA INFILE '"+filename+"' INTO TABLE MOOD (SONG_ID, MOOD_NAME);";
      statement.executeUpdate(loadMood);
	  
	  String loadActivity = "LOAD DATA INFILE '"+filename+"' INTO TABLE ACTIVITY (SONG_ID, ACTIVITY_NAME);";
      statement.executeUpdate(loadMood);
	  
	  /**
	  * QUERIES
	  */
	  String moodName = input.nextLine();
	  
	  ResultSet moodPlaylist = statement.executeQuery("INSERT INTO MOOD_PLAYLIST SELECT SONG_ID, MOOD_NAME FROM MOOD LEFT JOIN MOOD ON MOOD_PLAYLIST.MOOD_NAME = " + moodName + ";");
	  
	  String activityName = input.nextLine();
	  
	  ResultSet activityPlaylist = statement.executeQuery("INSERT INTO ACTIVITY_PLAYLIST SELECT SONG_ID, ACTIVITY_NAME FROM ACTIVITY LEFT JOIN ACTIVITY ON ACTIVITY_PLAYLIST.ACTIVITY_NAME = " + activityName + ";");
	  
	  
	  
	  

      while(rs.next())
      {
        // read the result set
        System.out.println("Song = " + moodPlaylist.getString("SONG-ID"));
		System.out.println("Time Listened = " + moodPlaylist.getString("TIME_LISTENED"));

		System.out.println("Song = " + activityPlaylist.getString("SONG-ID"));
		System.out.println("Time Listened = " + activityPlaylist.getString("TIME_LISTENED"));        
      }
    }
    catch(SQLException e)
    {
      // if the error message is "out of memory", 
      // it probably means no database file is found
      System.err.println(e.getMessage());
    }
    finally
    {
      try
      {
        if(connection != null)
          connection.close();
      }
      catch(SQLException e)
      {
        // connection close failed.
        System.err.println(e);
      }
    }
  }
}