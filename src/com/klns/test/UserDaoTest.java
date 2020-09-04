package com.klns.test;

import com.klns.dao.UserDao;
import com.klns.domain.User;
import org.junit.Test;


public class UserDaoTest {
    @Test
    public void testLogin(){
        User LoginUser=new User();
        LoginUser.setUsername("super");
        LoginUser.setPassword("123");

        UserDao dao=new UserDao();
        User user = dao.login(LoginUser);

        System.out.println(user);
    }
}
