package dao.impl;

import Exceptions.DAOException;
import entities.Library;

import java.util.ArrayList;
import java.util.List;

public class LibraryDAO {
    private List<Library> libraries = new ArrayList<>();

    public void update(Library library) throws DAOException {
        Library library1 = null;
        for (Library l : libraries) {
            if (l.getId() == library.getId()){
                l.setClosetId(library.getClosetId());
                library1 = l;
            }
        }
        if (library1==null)
            throw new DAOException("");
    }

    public Library selectById(int id) throws DAOException {
        Library library = null;
        for (Library library1 : libraries) {
            if (library1.getId() == id) {
                library = library1;
            }
            if (library == null) {
                throw new DAOException("object library cant be selected");
            }
        }
        return library;
    }

    public void insert(Library library) throws DAOException{
        if (libraries.size()>=30){
            throw new DAOException("");
        }
        libraries.add(library);
    }

    public void delete(Library library) throws DAOException {
        if (libraries.contains(library)) {
            libraries.remove(library);
        } else {
            throw new DAOException("cant delete because library doesnt exist");
        }
    }

    public void deleteById ( int id) throws DAOException{
        Library library = null;
        for (Library l : libraries) {
            if (l.getId() == id) {
                library = l;
            }
        }
        if (library == null) {
            throw new DAOException("object library cant be deleted");
        } else
            libraries.remove(library);
    }
}
