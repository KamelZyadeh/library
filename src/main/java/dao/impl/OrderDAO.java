package dao.impl;

import Exceptions.DAOException;
import entities.Order;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO{

    private List<Order> orders = new ArrayList<>();

    public void update(Order order) throws DAOException {
        Order order1 = null;
        for (Order o : orders) {
            if (o.getId() == order.getId()) {
                o.setId(order.getId());
                o.setTransactionId(order.getTransactionId());
                o.setBookId(order.getBookId());
                order1 = o;
            }
        }
        if (order1 == null) {
            throw new DAOException("object order not founded");
        }
    }

    public Order selectById(int id) throws DAOException {
        Order order1 = null;
        for (Order a : orders) {
            if (a.getId() == id) {
                order1 = a;
            }
            if (order1 == null) {
                throw new DAOException("object order cant be selected");
            }
        }
        return order1;
    }

    public void insert(Order order) throws DAOException {
        if (orders.size() >= 30) {
            throw new DAOException("memory is full, cant insert");
        }
        orders.add(order);
    }

    public void delete(Order account) throws DAOException {
        if (orders.contains(account)) {
            orders.remove(account);
        } else {
            throw new DAOException("cant delete because order doesnt exist");
        }
    }

    public void deleteById ( int id) throws DAOException{
        Order order1 = null;
        for (Order a : orders) {
            if (a.getId() == id) {
                order1 = a;
            }
        }
        if (order1 == null) {
            throw new DAOException("object order cant be deleted");
        } else
            orders.remove(order1);
    }
}
