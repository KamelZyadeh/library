package dao.impl;

import Exceptions.DAOException;
import entities.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    private List<Category> categories = new ArrayList<>();

    public void update(Category category) throws DAOException{
        Category category1 = null;
        for (Category c : categories) {
            if (c.getId() == category.getId()){
                c.setCategory(category.getCategory());
                category1 = c;
            }
        }
        if (category1 == null)
            throw new DAOException("");
    }

    public Category selectById(int id) throws DAOException {
        Category category = null;
        for (Category c : categories) {
            if (c.getId() == id) {
                category = c;
            }
            if (category == null) {
                throw new DAOException("object category cant be selected");
            }
        }
        return category;
    }

    public void insert(Category category) throws DAOException {
        if (categories.size()>=30){
            throw new DAOException("");
        }
        categories.add(category);
    }

    public void delete(Category category) throws DAOException {
        if (categories.contains(category)) {
            categories.remove(category);
        } else {
            throw new DAOException("cant delete because category doesnt exist");
        }
    }

    public void deleteById ( int id) throws DAOException{
        Category category = null;
        for (Category c : categories) {
            if (c.getId() == id) {
                category = c;
            }
        }
        if (category == null) {
            throw new DAOException("object category cant be deleted");
        } else
            categories.remove(category);
    }

    public Category selectByCategory(String categoryName) throws DAOException {
        Category category = null;
        for (Category category1 : categories) {
            if (category1.getCategory().equals(categoryName)) {
                category = category1;
            }
            if (category == null) {
                throw new DAOException("this category doesnt exist");
            }
        }
        return category;
    }
}
