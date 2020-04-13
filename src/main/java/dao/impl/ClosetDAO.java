package dao.impl;

import Exceptions.DAOException;
import entities.Closet;

import java.util.ArrayList;
import java.util.List;

public class ClosetDAO {
    private List<Closet> closets = new ArrayList<>();

    public void update(Closet closet)throws DAOException {
        Closet closet1 = null;
        for (Closet c : closets) {
            if (c.getId() == closet.getId()){
                c.setShelfId(closet.getShelfId());
                closet1 = c;
            }
        }
        if (closet1==null)
            throw new DAOException("closet cant be updated");
    }

    public Closet selectById(int id) throws DAOException {
        Closet closet = null;
        for (Closet c : closets) {
            if (c.getId() == id) {
                closet = c;
            }
            if (closet == null) {
                throw new DAOException("object closet cant be selected");
            }
        }
        return closet;
    }

    public void insert(Closet closet) throws DAOException {
        if (closets.size()>=30){
            throw new DAOException("");
        }
        closets.add(closet);
    }

    public void delete(Closet closet) throws DAOException {
        if (closets.contains(closet)) {
            closets.remove(closet);
        } else {
            throw new DAOException("cant delete because closet doesnt exist");
        }
    }

    public void deleteById ( int id) throws DAOException{
        Closet closet = null;
        for (Closet c : closets) {
            if (c.getId() == id) {
                closet = c;
            }
        }
        if (closet == null) {
            throw new DAOException("object closet cant be deleted");
        } else
            closets.remove(closet);
    }
}
