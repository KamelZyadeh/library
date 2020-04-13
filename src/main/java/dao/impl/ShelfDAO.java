package dao.impl;

import Exceptions.DAOException;
import entities.Shelf;

import java.util.ArrayList;
import java.util.List;

public class ShelfDAO{

    private List<Shelf> shelves = new ArrayList<>();

    public void update(Shelf shelf) throws DAOException {
        Shelf shelf1 = null;
        for (Shelf s : shelves) {
            if (s.getId() == shelf.getId()) {
                s.setId(shelf.getId());
                s.setBookId(shelf.getBookId());
                shelf1 = s;
            }
        }
        if (shelf1 == null) {
            throw new DAOException("object shelf not founded");
        }
    }

    public Shelf selectById(int id) throws DAOException {
        Shelf shelf = null;
        for (Shelf a : shelves) {
            if (a.getId() == id) {
                shelf = a;
            }
            if (shelf == null) {
                throw new DAOException("object shelf cant be selected");
            }
        }
        return shelf;
    }

    public void insert(Shelf shelf) throws DAOException {
        if (shelves.size() >= 30) {
            throw new DAOException("memory is full, cant insert");
        }
        shelves.add(shelf);
    }

    public void delete(Shelf shelf) throws DAOException {
        if (shelves.contains(shelf)) {
            shelves.remove(shelf);
        } else {
            throw new DAOException("cant delete because shelf doesnt exist");
        }
    }

    public void deleteById ( int id) throws DAOException{
        Shelf shelf = null;
        for (Shelf a : shelves) {
            if (a.getId() == id) {
                shelf = a;
            }
        }
        if (shelf == null) {
            throw new DAOException("object shelf cant be deleted");
        } else
            shelves.remove(shelf);
    }
}
