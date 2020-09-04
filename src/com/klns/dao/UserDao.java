package com.klns.dao;

import com.klns.domain.User;
import com.klns.util.JDBCUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    /**
     * 声明JDBCTemplate对象共用
     */
    private final JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());


    /**
     * 登录方法
     *
     * @param loginUser 用户名和密码
     * @return user包含用户全部数据,如果没有查询到，返回null
     */
    public User login(User loginUser) {
        try {
            String sql = "select * from day14.USER where username=? and password=?";
            User user = template.queryForObject
                    (sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(),
                    loginUser.getPassword());

            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
