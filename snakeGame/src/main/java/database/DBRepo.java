package database;

import java.sql.*;
import java.util.ArrayList;

/** Singleton. Class responsible for connecting to the database and making queries. */
public class DBRepo {
    /** Singleton instance of the class. */
    private static DBRepo instance;

    /** Database connection. */
    private final Connection connection;

    /**
     * Constructor.
     * @throws SQLException if a database access error occurs
     */
    private DBRepo() throws SQLException {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC driver not found!", e);
        }

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/game_db";
        String user = "root";
        String password = "1121";

        // Establish connection
        this.connection = DriverManager.getConnection(url, user, password);
    }

    /**
     * @return singleton instance of the class
     * @throws SQLException if a database access error occurs
     */
    public static DBRepo instance() throws SQLException {
        if (DBRepo.instance == null) {
            DBRepo.instance = new DBRepo();
        }
        return instance;
    }

    /**
     * Inserts the score of a player into the database. If the player already has a record, increments their score by one.
     * @param playerName name of the player
     * @throws SQLException if a database access error occurs
     */
    public void insertScore(String playerName) throws SQLException {
        // Check if the database contains a record that belongs to the given player
        PreparedStatement selectPlayerID = this.connection.prepareStatement("SELECT id FROM highscores WHERE Name = ?");
        selectPlayerID.setString(1, playerName);

        ResultSet resultSet = selectPlayerID.executeQuery();

        // Update existing records or insert new ones
        if (resultSet.next()) {
            // Player record already exists
            int id = resultSet.getInt(1);
            PreparedStatement updateRecord = this.connection.prepareStatement("UPDATE highscores SET score = score + 1 WHERE id = ?");
            updateRecord.setInt(1, id);
            updateRecord.executeUpdate();
        } else {
            // Create a new player record
            PreparedStatement insertRecord = this.connection.prepareStatement("INSERT INTO highscores (name, score) VALUES (?, 1)");
            insertRecord.setString(1, playerName);
            insertRecord.executeUpdate();
        }
    }

    /**
     * @return ArrayList created from records that have a score value in the top 10 scores in the table.
     * @throws SQLException if a database access error occurs
     */
    public ArrayList<PlayerScore> getTopScores() throws SQLException {
        ArrayList<PlayerScore> topScores = new ArrayList<>();

        // Select records with the top 10 scores
        PreparedStatement selectTop = this.connection.prepareStatement("SELECT name, score FROM highscores ORDER BY score DESC LIMIT 10");
        ResultSet resultSet = selectTop.executeQuery();

        while (resultSet.next()) {
            topScores.add(new PlayerScore(resultSet.getString(1), resultSet.getInt(2)));
        }

        return topScores;
    }
}
