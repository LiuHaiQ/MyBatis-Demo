package com.itheima.dao;

import java.util.List;

import com.itheima.pojo.User;

public interface UserDao {
/*
* 根据id查找用户
* @param name* @return
* * */	
public User getById(Integer id);

/*
 * 根据用户名查找用户列表
 * @param name
 * @return
 * */
public List<User> getByUserName(String name);
/**
 * 添加用户
 * @param user
 */
public void insertUser(User user);
/**
 *删除指定的用户
 * @param user
 */
public void deleteUser(Integer id);
}
