package com.example.adminmodel.model;

import com.example.adminmodel.entity.Account;

import java.util.List;

public class MySqlAccountModel implements AccountModel {
    @Override
    public boolean save(Account account) {
        return false;
    }

    @Override
    public boolean update(int id, Account account) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Account findById(int id) {
        return null;
    }

    @Override
    public List<Account> findAll() {
        return null;
    }
}
