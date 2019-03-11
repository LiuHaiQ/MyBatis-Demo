package com.itheima.daoImpl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.itheima.dao.UserDao;
import com.itheima.pojo.User;
import com.itheima.utils.MybatisUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public User getById(Integer id) {
		// TODO Auto-generated method stub]
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisUtils.getsqlSessionFactory().openSession();
			User user = sqlSession.selectOne("queryUserById", id);
			return user;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return null;
	}

	@Override
	public List<User> getByUserName(String name) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisUtils.getsqlSessionFactory().openSession();
			List<User> list = sqlSession.selectList("queryUserByName", name);
			return list;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return null;
	}

	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisUtils.getsqlSessionFactory().openSession();
			sqlSession.insert("saveUser", user);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisUtils.getsqlSessionFactory().openSession();
			sqlSession.delete("deleteUser",id);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

}

