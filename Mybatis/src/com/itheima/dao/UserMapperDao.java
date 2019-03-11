package com.itheima.dao;

import java.util.List;

import com.itheima.pojo.UserMapper;

public interface UserMapperDao {
	/*
	* 根据id查找用户
	* @param name* @return
	* * */	
	public UserMapper getById(Integer id);

	/*
	 * 根据用户名查找用户列表
	 * @param name
	 * @return
	 * */
	public List<UserMapper> getByUserName(String name);
	/**
	 * 添加用户
	 * @param user
	 */
	public void insertUser(UserMapper userMapper);
	/**
	 *删除指定的用户
	 * @param user
	 */
	public void deleteUser(Integer id);

}
