package com.baizhi.boot;

import com.baizhi.boot.dao.AlbumDao;
import com.baizhi.boot.service.AlbumService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootApplicationTests {
    @Autowired
    private AlbumService albumService;
    @Autowired
    private AlbumDao albumDao;
    @Test
    public void contextLoads() {
        System.out.println(albumService.getAll(1));
    }
    @Test
    public void ces(){
        System.out.println(albumDao.selectByPrimaryKey(1));
    }

}
