package repository.implement;

import connection.DbConnection;
import entity.Transaction;
import repository.TransactionRepository;
import util.ActionType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TransactionRepositoryImpl implements TransactionRepository {
    @Override
    public List<Transaction> findAll() {
        String sql = "SELECT * FROM transactions";

        List<Transaction> transactionList = new ArrayList<>();

        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery();) {

            while (resultSet.next()) {
                Transaction transaction = new Transaction();

                transaction.setId(resultSet.getInt("id"));
                transaction.setBookId(resultSet.getInt("book_id"));
                transaction.setUserId(resultSet.getInt("user_id"));
                transaction.setActionType(ActionType.valueOf(resultSet.getString("action_type")));
                transaction.setTransactionDate(resultSet.getTimestamp("transaction_date").toInstant());

                transactionList.add(transaction);
            }

            return transactionList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Transaction> findById(int id) {
        String sql = "SELECT * FROM transactions WHERE id=?";

        try (Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    Transaction transaction = new Transaction();

                    transaction.setId(resultSet.getInt("id"));
                    transaction.setBookId(resultSet.getInt("book_id"));
                    transaction.setUserId(resultSet.getInt("user_id"));
                    transaction.setActionType(ActionType.valueOf(resultSet.getString("action_type")));
                    transaction.setTransactionDate(resultSet.getTimestamp("transaction_date").toInstant());

                    return Optional.of(transaction);
                }
            }

            return Optional.empty();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Transaction transaction) {
        String sql = "INSERT INTO transactions(id, book_id, user_id, action_type, transaction_date) VALUES(?,?,?,?,?)";

        try (Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, transaction.getId());
            preparedStatement.setInt(2, transaction.getBookId());
            preparedStatement.setInt(3, transaction.getUserId());
            preparedStatement.setString(4, transaction.getActionType().name());
            preparedStatement.setTimestamp(5, Timestamp.from(transaction.getTransactionDate()));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
