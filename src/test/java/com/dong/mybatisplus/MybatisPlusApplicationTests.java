package com.dong.mybatisplus;

import com.dong.mapper.UserMapper;
import com.dong.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
    @Test
    void testInsert(){
//        会自动生成id
        User user = new User();
        user.setName("Mike");
        user.setAge(25);
        user.setEmail("3123123@ww.com");
        userMapper.insert(user);
    }

    @Test
    void testUpdate(){
//        会自动生成id
        User user = new User();
        user.setId(1438725778627596290L);
        user.setName("nimama");
        userMapper.updateById(user);
    }

    @Test
    public void testOptimisticLocker(){
        User user = userMapper.selectById(1L);
        user.setName("mingming");
        user.setEmail("sefaefsfda");
        userMapper.updateById(user);
    }
}
