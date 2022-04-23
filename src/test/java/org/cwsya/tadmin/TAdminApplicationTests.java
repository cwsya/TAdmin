package org.cwsya.tadmin;

import org.cwsya.tadmin.mapper.UserAllMapper;
import org.cwsya.tadmin.mapper.UserMapper;
import org.cwsya.tadmin.pojo.VO.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TAdminApplicationTests {


    @Autowired
    UserMapper userMapper;

    @Autowired
    UserAllMapper userAllMapper;

    @Test
    void contextLoads() {
//        System.out.println(userMapper.selectList(null));
        System.out.println(userAllMapper.selectUserAll(new UserEntity(null,"admin","admin",null)));
    }

}
