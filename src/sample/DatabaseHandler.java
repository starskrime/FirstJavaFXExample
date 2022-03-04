package sample;
import java.sql.*;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException , SQLException{
        String conectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName ;

        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(conectionString , dbUsername ,dbPassword);

        return dbConnection;

    }

    public void signUpUser (User user) {

        String userInsert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USERS_FIRSTNAME + ","
                                           + Const.USERS_LASTNAME + "," + Const.USERS_USERNAME + ","
                                           + Const.USERS_PASSWORD + "," + Const.USERS_COUNTRY + ","
                                           + Const.USERS_GENDER + ")" + "VALUES (?,?,?,?,?,?)";
        PreparedStatement prST = null;

        try {
            prST = getDbConnection().prepareStatement(userInsert);

            prST.setString(1, user.getFirstName());
            prST.setString(2, user.getLastName());
            prST.setString(3, user.getUserName());
            prST.setString(4, user.getPassword());
            prST.setString(5, user.getCountry());
            prST.setString(6, user.getGender());

            prST.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    }
    public ResultSet getUser(User user) {
        ResultSet resSet = null;
        String getUserSql = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USERS_USERNAME + " =? AND " + Const.USERS_PASSWORD + " =?";
        try {
            PreparedStatement prStUser = getDbConnection().prepareStatement(getUserSql);
            prStUser.setString(1,user.getUserName());
            prStUser.setString(2,user.getPassword());
            resSet = prStUser.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();

        }catch (ClassNotFoundException e){
            e.printStackTrace();

        }

        return resSet;
    }
}
