package database;

import javax.swing.*;
import java.sql.*;
import java.util.Properties;

public class Database {
    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/sudoku";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private Connection connection;
    private Properties properties;
    private static Database database;

    public static Database getDatabaseInstance() {
        if(database == null){
            database = new Database();
        }
        return database;
    }

    private Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", USERNAME);
            properties.setProperty("password", PASSWORD);
        }
        return properties;
    }

    public Connection connect() {
        if (connection == null) {
            try {
                Class.forName(DATABASE_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, getProperties());
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void loadFromDatabase(String mode, JTextField[][] hs) {
        String sql = "SELECT * FROM highscores WHERE Mode = '" + mode + "' ORDER BY Score DESC";
        int i = 1;
        try {
            Statement st = connection.createStatement();
            ResultSet rst = st.executeQuery(sql);
            while (rst.next()) {
                if (i == 11) {
                    break;
                }
                hs[i][1].setText(rst.getString("Mode"));
                hs[i][2].setText(rst.getString("Difficulty"));
                hs[i][3].setText(String.valueOf(rst.getInt("game.Score")));
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveToDatabase(String mode, String difficulty, int score) {
        String sql = "INSERT INTO highscores (Difficulty, Mode, Score) VALUES ('" + difficulty + "', '" + mode + "', '" + score + "')";
        try {
            Statement st = connection.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isInTop(String mode, int score) {
        String sql = "SELECT * FROM highscores WHERE mode = '" + mode + "' ORDER BY Score DESC";
        int i = 1;
        try {
            Statement st = connection.createStatement();
            ResultSet rst = st.executeQuery(sql);
            if (!rst.isBeforeFirst()) {
                return true;
            }
            while (rst.next()) {
                if (i == 11) {
                    break;
                }
                if (rst.getInt("game.Score") < score) {
                    return true;
                }
                i++;
            }

            if (i < 11) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}