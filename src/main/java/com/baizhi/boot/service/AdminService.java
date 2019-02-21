package com.baizhi.boot.service;

import com.baizhi.boot.entity.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> getAll();
    void insert(Admin admin);
    void remove(Integer id);
    int login(String username, String password);
    Admin getAdminByUsername(String username);
}
