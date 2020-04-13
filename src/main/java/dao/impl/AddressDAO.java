package dao.impl;

import Exceptions.DAOException;
import entities.Address;

import java.util.ArrayList;
import java.util.List;

public class AddressDAO {
    List<Address> addresses = new ArrayList<>();

    public void update(Address address) throws DAOException {
        Address address1 = null;
        for (Address c : addresses) {
            if (c.getId() == address.getId()) {
                c.setCountry(address.getCountry());
                c.setRegion(address.getRegion());
                c.setStreet(address.getStreet());
                c.setApartment(address.getApartment());
                address1 = c;
            }
        }
        if (address1 == null)
            throw new DAOException("object address not founded");
    }

    public Address selectById(int id) throws DAOException {
        Address address = null;
        for (Address c : addresses) {
            if (c.getId() == id) {
                address = c;
            } else {
                throw new DAOException("object address couldn't be selected");
            }
        }
        return address;
    }

    public void insert(Address address) throws DAOException {
        if (addresses.size() >= 30) {
            throw new DAOException("address couldn't be inserted");
        }
        addresses.add(address);
    }

    public void delete(Address address) throws DAOException {
        if (addresses.contains(address)) {
            addresses.remove(address);
        } else
            throw new DAOException("address couldn't be deleted");
    }

    public void deleteById(int id) throws DAOException {
        Address address = null;
        for (Address a : addresses) {
            if (a.getId() == id) {
                address = a;
            }
        }
        if (address == null) {
            throw new DAOException("address couldn't be deleted");
        } else {
            addresses.remove(address);
        }
    }
}