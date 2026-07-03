package entity;

import util.ActionType;

import java.time.Instant;

public class Transaction {
    private int id;
    private int bookId;
    private int userId;
    private ActionType actionType;
    private Instant transactionDate;

    public Transaction(int id, int bookId, int userId, ActionType actionType, Instant transactionDate) {
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
        this.actionType = actionType;
        this.transactionDate = transactionDate;
    }

    public Transaction() {

    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setTransactionDate(Instant transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Instant getTransactionDate() {
        return transactionDate;
    }


    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", userId=" + userId +
                ", actionType=" + actionType +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
