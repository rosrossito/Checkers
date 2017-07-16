package game.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by Администратор on 28.05.2017.
 */
public class GameUserRepository {


    Connection con;
//  String fileName = "src/main/resources/config.properties";

    public Connection connect_to_database_from_properties() {

//        URL url1 = Application.class.getResource("/config.properties");
//        String fileName = Application.class.getResource("/ACDCHighwaytoHell.mp3").toString();
//        URL url1 = this.getClass().getClassLoader().getResource("config.properties");
//        String fileName = url1.toString();
//        System.out.println(fileName);
        Properties prop = new Properties();

        InputStream is;
        try {

            is = this.getClass().getClassLoader().getResourceAsStream("config.properties");

            prop.load(is);

            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String pass = prop.getProperty("password");
            is.close();
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, pass);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

//player registration

    public void playerRegistration(String player1Name, String player2Name) {
        boolean flagplayer1 = false;
        boolean flagplayer2 = false;

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM players");

            while (rs.next()) {
                String str = rs.getString("name");
                if (player1Name.equals(str)) {
                    flagplayer1 = true;
                }
                if (player2Name.equals(str)) {
                    flagplayer2 = true;
                }

            }
            if (!flagplayer1) {
                String query1 = "INSERT INTO PLAYERS (name,points)" +
                        "VALUES ('" + player1Name + "', 0);";
                stmt.executeUpdate(query1);
            }
            if (!flagplayer2) {
                String query2 = "INSERT INTO PLAYERS (name,points)" +
                        "VALUES ('" + player2Name + "', 0);";
                stmt.executeUpdate(query2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    //writing points to DB
    void scoring(String player1Name, String player2Name) {
        Statement stmt = null;
        ResultSet rs = null;
        int pointsPlayer1 = 0;
        int pointsPlayer2 = 0;
        try {

            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM players");


            while (rs.next()) {
                String str = rs.getString("name");

                if (player1Name.equals(str)) {
                    pointsPlayer1 = rs.getInt("points");
                }
                if (!player2Name.equals(str)) {
                    pointsPlayer2 = rs.getInt("points");
                }
            }

            String updatePlayers1 = "UPDATE Players SET POINTS = " + (1 + pointsPlayer1) + " WHERE name = '" +
                    player1Name + "'";
            String updatePlayers2 = "UPDATE Players SET POINTS = " + (0 + pointsPlayer2) + " WHERE name = '" + player2Name + "'";
            stmt.execute(updatePlayers1);
            stmt.execute(updatePlayers2);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //show ranking
    void showRanking(String player1Name, String player2Name) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            String selectTableSQL = "SELECT name, points from players";
            stmt = con.createStatement();
            rs = stmt.executeQuery(selectTableSQL);

            while (rs.next()) {
                String user = rs.getString("name");
                int points = rs.getInt("points");
            }
//вывести в форму первую десятку лидеров
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}


