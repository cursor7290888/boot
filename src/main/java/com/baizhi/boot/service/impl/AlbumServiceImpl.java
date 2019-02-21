package com.baizhi.boot.service.impl;

import com.baizhi.boot.dao.AlbumDao;
import com.baizhi.boot.entity.Album;
import com.baizhi.boot.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDao albumDao;
    @Override
    public Album getAll(Integer id) {
        return albumDao.selectByPrimaryKey(id);
    }
}
