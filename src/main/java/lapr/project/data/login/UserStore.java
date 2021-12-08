package lapr.project.data.login;

import lapr.project.controller.App;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Manuela Leite <1200720@isep.ipp.pt>
 */
public class UserStore {

    private Connection connectionDatabase;
    private RoleStore roleStore;

    public UserStore(){
       // connectionDatabase = App.getInstance().getDatabaseConnection().getConnection();
        roleStore = new RoleStore();
    }

    public boolean createUser(String username, String password, String roleName) throws SQLException {
        if (userExist(username,password)) return false;
        else{
            connectionDatabase= App.getInstance().getDatabaseConnection().getConnection();
            String sqlCommand = "insert into UserSystem(username, password, roleId) values(?, ?, ?)";

            PreparedStatement preparedStatement = connectionDatabase.prepareStatement(sqlCommand);

            String hashedPassword= hashPassword(password);

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, hashedPassword);
            preparedStatement.setInt(3, roleStore.getRoleId(roleName));

            try{
                preparedStatement.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }
            finally {
                preparedStatement.close();
            }

            return true;
        }
    }

    private boolean userExist(String userName, String password) throws SQLException {


        connectionDatabase= App.getInstance().getDatabaseConnection().getConnection();
        boolean isUserOnDatabase;
        String hashedPassword="";
        String sqlCommand = "select password from userSystem where username = ?";

        PreparedStatement preparedStatement = connectionDatabase.prepareStatement(sqlCommand);

        preparedStatement.setString(1, userName);

        try (ResultSet userResultSet = preparedStatement.executeQuery()) {
            userResultSet.next();

            hashedPassword= userResultSet.getString("password");


            isUserOnDatabase = checkPass(password,hashedPassword);


            userResultSet.close();
        }catch (Exception e){
            isUserOnDatabase=false;
            e.printStackTrace();
        }
        finally {
            preparedStatement.close();
        }
        return isUserOnDatabase;
    }


    public User getByUsername(String username, String password) throws SQLException {


        if(userExist(username,password)) {
            connectionDatabase = App.getInstance().getDatabaseConnection().getConnection();
            String userNames;
            String passwords;
            int roleId;


            String sqlCommand = "select username,password,roleId from usersystem where username = ?";

            PreparedStatement preparedStatement = connectionDatabase.prepareStatement(sqlCommand);

            preparedStatement.setString(1, username);

            try (ResultSet userResultSet = preparedStatement.executeQuery()) {
                userResultSet.next();
                userNames = userResultSet.getString("username");
                passwords = userResultSet.getString("password");
                roleId = userResultSet.getInt("roleId");


                userResultSet.close();
            } catch (SQLException e) {
                System.out.println(e.getErrorCode());
                e.printStackTrace();
                return null;
            } finally {
                preparedStatement.close();
            }

            return new User(userNames, passwords, new Role(roleId, roleStore.getRoleName(roleId)));
        }else{
            return null;
        }
    }

    public boolean checkPass(String plainPassword, String hashedPassword) {

        return BCrypt.checkpw(plainPassword, hashedPassword);

    }

    public String hashPassword(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }
}
