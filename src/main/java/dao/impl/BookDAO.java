package dao.impl;

import Exceptions.DAOException;
import entities.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    private List<Book> books = new ArrayList<>();


    public void update(Book book) throws DAOException {
        Book book1 = null;
        for (Book b : books) {
            if (b.getId() == book.getId()) {
                b.setId(book.getId());
                b.setName(book.getName());
                b.setAuthorId(book.getAuthorId());
                b.setCategoryId(book.getCategoryId());
                b.setNumberOfPages(book.getNumberOfPages());
                book1 = b;
            }
        }
        if (book1 == null) {
            throw new DAOException("Can't update book");
        }
    }

    public Book selectById(int id) throws DAOException {
        Book book = null;
        for (Book b : books) {
            if (b.getId() == id) {
                book = b;
            } else {
                throw new DAOException("Can't find this ID");
            }
        }
        return book;
    }

    public void insert(Book book) throws DAOException {
        if (books.size() >= 30) {
            throw new DAOException("Can't add to array");
        }
        books.add(book);
    }

    public void delete(Book book) throws DAOException {
        if (books.contains(book)) {
            books.remove(book);
        } else
            throw new DAOException("Can't delete array");
    }


    public void deleteById(int id) throws DAOException {
        Book book = null;
        for (Book b : books) {
            if (b.getId() == id) {
                book = b;
            }
            if (book == null) {
                throw new DAOException("cant delete this book");
            } else {
                books.remove(book);
            }
        }
    }

   /* List<Book> bookList = new ArrayList<>();
    public List<Book> selectByAuthor(Author author) throws DAOException {
        Book book = null;
        for (Book b : bookList) {
            if (b.getName().equals(author.getFirstName())){
                if(b.getName().equals(author.getLastName())) {
                    book = b;
                }
            }
            if (book == null){
                throw new DAOException("Can't find this name");
            } else {
                return bookList;
            }
        }
        return bookList;
    }*/

    public Book selectByAuthorId(int id) throws DAOException {
        Book book = null;
        for (Book b : books) {
            if (b.getAuthorId() == id) {
                book = b;
            }
        }
            if (book == null){
                throw new DAOException("cant find this id");
            }

        return book;
    }

    public Book selectByCategoryId(int id) throws DAOException {
        Book book = null;
        for (Book b : books) {
            if (b.getCategoryId() == id) {
                book = b;
            }
        }
        if (book == null) {
            throw new DAOException("cant find this id");
        }
        return book;
    }

    public Book selectByBookName(String bookName) throws DAOException {
        Book book = null;
        for (Book b : books) {
            if (b.getName().equals(bookName)) {
                book = b;
            }
        }
        if (book == null) {
            throw new DAOException("a book with this tittle doesnt exist");
        }
        return book;
    }
}
