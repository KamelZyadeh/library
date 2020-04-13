package dao.impl;

import Exceptions.DAOException;
import entities.Basket;
import entities.Book;

import java.util.ArrayList;
import java.util.List;

public class BasketDAO{

    private List<Basket> baskets = new ArrayList<>();

    public void basketRegistration(){
        Basket basket = new Basket();
        Book book = new Book();
        basket.setId(1);
        basket.setBookId(book.hashCode());
        baskets.add(basket);
    }

    public void update(Basket basket) throws DAOException {
        Basket basket1 = null;
        for (Basket b : baskets) {
            if (b.getId() == basket.getId()) {
                b.setId(basket.getId());
                b.setBookId(basket.getBookId());
                basket1 = b;
            }
        }
        if (basket1 == null) {
            throw new DAOException("Can't update basket");
        }
    }

    public Basket selectById(int id) throws DAOException {
        Basket basket = null;
        for (Basket b : baskets) {
            if (b.getId() == id) {
                basket = b;
            } else {
                throw new DAOException("Can't find this ID");
            }
        }
        return basket;
    }

    public void insert(Basket basket) throws DAOException {
        if (baskets.size() >= 30) {
            throw new DAOException("Can't add to basket");
        }
        baskets.add(basket);
    }

    public void delete(Basket basket) throws DAOException {
        if (baskets.contains(basket)) {
            baskets.remove(basket);
        } else
            throw new DAOException("Can't delete array");
    }


    public void deleteById(int id) throws DAOException {
        Basket basket = null;
        for (Basket b : baskets) {
            if (b.getId() == id) {
                basket = b;
            }
            if (basket == null){
                throw new DAOException("cant delete this author");
            } else {
                baskets.remove(basket);
            }
        }
    }
}
