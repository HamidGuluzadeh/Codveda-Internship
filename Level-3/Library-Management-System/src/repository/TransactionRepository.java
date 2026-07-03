package repository;

import entity.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository {

    List<Transaction> findAll();

    Optional<Transaction> findById(int id);

    void save(Transaction transaction);

}
