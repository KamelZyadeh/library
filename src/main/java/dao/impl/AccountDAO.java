    package dao.impl;

    import Exceptions.DAOException;
    import entities.Account;

    import java.util.ArrayList;
    import java.util.List;

    public class AccountDAO {
        List<Account> accounts = new ArrayList<>();


        public void update(Account account) throws DAOException {
            Account account1 = null;
            for (Account a : accounts) {
                if (a.getId() == account.getId()) {
                    a.setUserId(account.getUserId());
                    a.setUserName(account.getUserName());
                    a.setPassword(account.getPassword());
                    a.setRole(account.getRole());
                    account1 = a;
                }
            }
            if (account1 == null) {
                throw new DAOException("object account not founded");
            }
        }

        public Account selectById(int id) throws DAOException {
            Account account1 = null;
            for (Account a : accounts) {
                if (a.getId() == id) {
                    account1 = a;
                }
                if (account1 == null) {
                    throw new DAOException("object account cant be selected");
                }
            }
            return account1;
        }

        public Account selectByUsernameAndPassword(String username, String password) throws DAOException {
            Account account = null;
            for (Account account1 : accounts) {
                if (account1.getUserName().equals(username) && account1.getPassword().equals(password)) {
                    account = account1;
                }
                if (account == null) {
                    throw new DAOException("this account username and password dont exist");
                }
            }
            return account;
        }

        public void insert(Account account) throws DAOException {
            if (accounts.size() >= 30) {
                throw new DAOException("memory is full, cant insert");
            }
            accounts.add(account);
        }

        public void delete(Account account) throws DAOException {
            if (accounts.contains(account)) {
                accounts.remove(account);
            } else {
                throw new DAOException("cant delete because account doesnt exist");
            }
        }

            public void deleteById ( int id) throws DAOException{
                Account account1 = null;
                for (Account a : accounts) {
                    if (a.getId() == id) {
                        account1 = a;
                    }
                }
                if (account1 == null) {
                    throw new DAOException("object account cant be deleted");
                } else {
                    accounts.remove(account1);
                }
        }

    }