package com.itheima.test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.itheima.dao.UserMapperDao;
import com.itheima.pojo.UserMapper;
import com.itheima.utils.MybatisUtils;

public class UserMapperDaoTest {
	@Test
	public void testGetById() {
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisUtils.getsqlSessionFactory().openSession();
			// 加载配置文件获得sqlSession
			UserMapperDao userMapperDao = sqlSession.getMapper(UserMapperDao.class);
			// 获得代理对象
			UserMapper userMapper = userMapperDao.getById(51);
			System.out.println(userMapper);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}

	@Test
	public void testGetByUserName() {
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisUtils.getsqlSessionFactory().openSession();
			// 加载配置文件获得sql对象
			UserMapperDao userMapperDao = sqlSession.getMapper(UserMapperDao.class);
			List<UserMapper> list = userMapperDao.getByUserName("张");
			for (UserMapper userMapper : list) {
				System.out.println(userMapper);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	@Test
	public void testInsertUser() {
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisUtils.getsqlSessionFactory().openSession();
			// 加载配置文件获得sqlsession对象
			UserMapperDao userMapperDao = sqlSession.getMapper(UserMapperDao.class);
			UserMapper userMapper=new UserMapper();
			userMapper.setAddress("江西");
			userMapper.setBirthday(new Date());
			userMapper.setUsername("杨星");
			userMapper.setSex("2");
			userMapperDao.insertUser(userMapper);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}

	}

	@Test
	public void testDeleteUser() {
		SqlSession sqlSession=null;
		try {
			sqlSession=MybatisUtils.getsqlSessionFactory().openSession();
			UserMapperDao  userMapperDao=	sqlSession.getMapper(UserMapperDao.class);
			userMapperDao.deleteUser(51);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
	}

}
