package dao.impl;


import Exceptions.DAOException;
import entities.Author;


import java.util.ArrayList;
import java.util.List;

public class AuthorDAO {

    private List<Author> authors = new ArrayList<>();


    public void update(Author author) throws DAOException {
        Author author1 = null;
        for (Author a : authors) {
            if (a.getId() == author.getId()) {
                a.setId(author.getId());
                a.setFirstName(author.getFirstName());
                a.setLastName(author.getLastName());
                author1 = a;
            }
        }
        if (author1 == null) {
            throw new DAOException("Can't update Author");
        }
    }

    public Author selectById(int id) throws DAOException {
        Author author = null;
        for (Author a : authors) {
            if (a.getId() == id) {
                author = a;
            } else {
                throw new DAOException("Can't find this ID");
            }
        }
        return author;
    }


    public void insert(Author author) throws DAOException {
        if (authors.size() >= 30) {
            throw new DAOException("Can't add to array");
        }
        authors.add(author);
    }

    public void delete(Author author) throws DAOException {
        if (authors.contains(author)) {
            authors.remove(author);
        } else
            throw new DAOException("Can't delete array");
    }


    public void deleteById(int id) throws DAOException {
        Author author = null;
        for (Author a : authors) {
            if (a.getId() == id) {
                author = a;
            }
            if (author == null){
                throw new DAOException("cant delete this author");
            } else {
                authors.remove(author);
            }
        }
    }

    public Author selectByAuthorName(String firstName, String lastName) throws DAOException {
        Author author = null;
        for (Author author1 : authors) {
            if (author1.getFirstName().equals(firstName) && author1.getLastName().equals(lastName)) {
                author = author1;
            }
            if (author == null) {
                throw new DAOException("this author's first name and last name is incorrect");
            }
        }
        return author;
    }
}