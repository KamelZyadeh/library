package service.impl;

import Exceptions.DAOException;
import Exceptions.ServiceException;
import dao.impl.TransactionDAO;
import dao.impl.UserDAO;
import entities.Singleton;
import entities.Transaction;
import entities.User;
import service.CURDService;

public class TransactionService extends CURDService<Transaction> {
    private TransactionDAO dao = Singleton.getInstance().getTransactionDAO();
    private UserDAO userDAO = Singleton.getInstance().getUserDAO();


    @Override
    public void create(Transaction entity) throws ServiceException {
        try {
            dao.insert(entity);
        } catch (DAOException e) {
            throw new ServiceException("cant create the transaction", e);
        }
    }

    @Override
    public void update(Transaction entity) throws ServiceException {
        try {
            dao.update(entity);
        } catch (DAOException e) {
            throw new ServiceException("cant update the transaction", e);
        }
    }

    @Override
    public Transaction read(int id) throws ServiceException {
        try {
            return dao.selectById(id);
        } catch (DAOException e) {
            throw new ServiceException("cant get the transaction", e);
        }
    }

    @Override
    public void delete(Transaction entity) throws ServiceException {
        try {
            dao.delete(entity);
        } catch (DAOException e) {
            throw new ServiceException("cant delete the transaction", e);
        }
    }

    public void deleteByUserId(int id) throws ServiceException {
        try {
            User user = userDAO.selectById(id);
            dao.deleteByUserId(user.getId());
        } catch (DAOException e) {
            throw new ServiceException("cant delete this transaction by the user id");
        }
    }


}
