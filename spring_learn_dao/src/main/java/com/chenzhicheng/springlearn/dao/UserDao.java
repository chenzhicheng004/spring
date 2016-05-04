package com.chenzhicheng.springlearn.dao;

import com.chenzhicheng.springlearn.common.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/5/2.
 */
@Repository("userDao")
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int getMatchCount(String username,String password){
        String sql = "select count(*) from user where username = ? and password = ?";
        Object o = jdbcTemplate.queryForObject(sql,new Object[]{username,password},Integer.class);
        System.out.println(o);
        return jdbcTemplate.queryForInt(sql,new Object[]{username,password});
    }

    public User getUserByName(String username){
        String sql = "select id,username,credits from user where username = ?";
        final User user = new User();
        jdbcTemplate.query(sql,new Object[]{username},new RowCallbackHandler(){
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setCredits(resultSet.getInt("credits"));
            }
        });
        return user;
    }

    public void updateUser(User user){
        String sql = "update user set last_ip = ?,credits = ?,last_visit = ? where id = ?";
        jdbcTemplate.update(sql,new Object[]{user.getLastIp(),user.getCredits(),user.getLastVisit(),user.getId()});
    }
}
