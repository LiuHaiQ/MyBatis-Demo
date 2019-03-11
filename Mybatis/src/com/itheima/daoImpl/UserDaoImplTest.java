package com.itheima.daoImpl;

import java.util.List;

import org.junit.Test;

import com.itheima.dao.UserDao;
import com.itheima.pojo.User;

public class UserDaoImplTest {
	@Test
	public void testGetById() {
		// 根据id查询
		UserDao userDaoImpl = new UserDaoImpl();
		User user = userDaoImpl.getById(16);
		System.out.println(user);
	}

	@Test
	public void testGetByUserName() {
		// 模糊查询
		UserDao userDaoImpl = new UserDaoImpl();
		List<User> list = userDaoImpl.getByUserName("张");
		for (User user : list) {
			System.out.println(user);
		}
	}

	@Test
	public void testInsertUser() {
		// 插入数据
		UserDao userDao = new UserDaoImpl();
		User user = new User();
		user.setAddress("深圳");
		user.setUsername("许舒怡");
		user.setSex("1");
		userDao.insertUser(user);
	}
	@Test
	public void testDeleteUser() {
		//删除指定id的User
		UserDao userDao = new UserDaoImpl();
		userDao.deleteUser(50);
	}
}
