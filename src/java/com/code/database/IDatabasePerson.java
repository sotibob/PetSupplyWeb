package com.code.database;

import com.code.business.Address;

/**
 *
 * @author josia
 */

//All the methods that are shared among the bussiness classes
public interface IDatabasePerson {
    abstract void select(int id);
    abstract void insert(String username, String password, String firstName, String lastName, String email, Address address, String phone);
    abstract void delete();
    abstract void update();
}
