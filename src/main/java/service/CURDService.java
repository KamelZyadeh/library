package service;

import Exceptions.ServiceException;

public abstract class CURDService<T> {

   public abstract void create(T entity) throws ServiceException;

   public abstract void update(T entity) throws ServiceException;

   public abstract T read(int id) throws ServiceException;

   public abstract void delete(T entity) throws ServiceException;
}
