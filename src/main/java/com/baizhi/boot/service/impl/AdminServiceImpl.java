package com.baizhi.boot.service.impl;

import com.baizhi.boot.dao.AdminDao;
import com.baizhi.boot.entity.Admin;
import com.baizhi.boot.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Override
    public List<Admin> getAll() {
        return adminDao.getAll();
    }

    @Override
    public void insert(Admin admin) {
        adminDao.insert(admin);
    }

    @Override
    public void remove(Integer id) {
        adminDao.remove(id);
    }

    @Override
    public int login(String username, String password) {
        Admin adminByUsername = null;
        try {
            adminByUsername=adminDao.getAdminByUsername(username);
        }catch (Exception e){
            throw e;
        }
        if (adminByUsername==null) return 1;
        if (!adminByUsername.getPassword().equals(password)) return 2;
        return 3;
    }

    @Override
    public Admin getAdminByUsername(String username) {
        return adminDao.getAdminByUsername(username);
    }
}
