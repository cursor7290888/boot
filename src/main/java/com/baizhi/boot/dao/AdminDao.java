package com.baizhi.boot.dao;

import com.baizhi.boot.entity.Admin;

import java.util.List;

public interface AdminDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    List<Admin> getAll();

    void remove(Integer id);

    Admin getAdminByUsername(String username);
}