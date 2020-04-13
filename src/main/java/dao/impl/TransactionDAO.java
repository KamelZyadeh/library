package dao.impl;

import Exceptions.DAOException;
import entities.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {
    private List<Transaction> transactions = new ArrayList<>();


    public void update(Transaction transaction) throws DAOException{
        Transaction transaction1 = null;
        for (Transaction t : transactions) {
            if (t.getId() == transaction.getId()){
                t.setDate(transaction.getDate());
                t.setPrice(transaction.getPrice());
                t.setUserId(transaction.getUserId());
                transaction1 = t;
            }
        }
        if (transaction1 == null)
            throw new DAOException("");
    }

    public Transaction selectById(int id) throws DAOException {
        Transaction transaction = null;
        for (Transaction a : transactions) {
            if (a.getId() == id) {
                transaction = a;
            }
            if (transaction == null) {
                throw new DAOException("object transaction cant be selected");
            }
        }
        return transaction;
    }

    public void insert(Transaction transaction) throws DAOException {
        if (transactions.size()>=30){
            throw new DAOException("");
        }
        transactions.add(transaction);
    }

    public void delete(Transaction transaction) throws DAOException {
        if (transactions.contains(transaction)) {
            transactions.remove(transaction);
        } else {
            throw new DAOException("cant delete because transaction doesnt exist");
        }
    }

    public void deleteById ( int id) throws DAOException{
        Transaction transaction = null;
        for (Transaction t : transactions) {
            if (t.getId() == id) {
                transaction = t;
            }
        }
        if (transaction == null) {
            throw new DAOException("object transaction cant be deleted");
        } else
            transactions.remove(transaction);
    }

    public void deleteByUserId(int id) throws DAOException{
        Transaction transaction = null;
        for (Transaction t : transactions) {
            if (t.getUserId() == id) {
                transaction = t;
            }
        }
        if (transaction == null) {
            throw new DAOException("object transaction cant be deleted by user id");
        } else
            transactions.clear();
    }

}
