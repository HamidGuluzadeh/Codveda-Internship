package repository.implement;

import connection.DbConnection;
import entity.User;
import repository.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM users";

        List<User> userList = new ArrayList<>();

        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                User user = new User();

                user.setId(resultSet.getInt("id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));

                userList.add(user);
            }

            return userList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<User> findById(int id) {
        String sql = "SELECT * FROM users WHERE id=?";

        try (Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    User user = new User();

                    user.setId(resultSet.getInt("id"));
                    user.setFirstName(resultSet.getString("first_name"));
                    user.setLastName(resultSet.getString("last_name"));
                    user.setEmail(resultSet.getString("email"));

                    return Optional.of(user);
                }
            }

            return Optional.empty();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO users(id, first_name, last_name, email) VALUES(?,?,?,?)";

        try (Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getEmail());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE users SET first_name=?,last_name=?,email=? WHERE id=?";

        try (Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setInt(4, user.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM users WHERE id=?";

        try (Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
