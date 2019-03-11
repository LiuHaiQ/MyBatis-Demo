package com.itheima.mybatis;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.itheima.pojo.User;
import com.itheima.utils.MybatisUtils;

public class MybatisTest {
	@Test
	public void test01() {
		SqlSession sqlSession = null;
		try {
			System.out.println("开始了");
			sqlSession = MybatisUtils.getsqlSessionFactory().openSession();
//创建SqlSession对象
			User user = sqlSession.selectOne("queryUserById", 10);
			System.out.println(user);
			System.out.println("结束了");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	@Test
	public void test02() {
		// 模糊查询
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisUtils.getsqlSessionFactory().openSession();
//创建SqlSession对象
			List<User> list = sqlSession.selectList("queryUserByName", "王");
			for (User user : list) {
				System.out.println(11);
				System.out.println(user);
			}
			System.out.println("结束了");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	@Test
	public void test03() throws IOException {
		//插入数据
		System.out.println("开始");
		SqlSession sqlSession = MybatisUtils.getsqlSessionFactory().openSession();
		//获得SqlSession
		User user = new User();
		user.setUsername("张飞");
		user.setAddress("深圳市黑马");
		user.setBirthday(new Date());
		user.setSex("1");
		// 执行插入
		int id=sqlSession.insert("saveUser",user);
		// 提交事务
		System.out.println(id);
		sqlSession.commit();
		System.out.println("结束");
		// 释放资源
	}
	@Test
	public void test04() throws IOException {
		//删除指定的User
		System.out.println("开始");
		SqlSession sqlSession = MybatisUtils.getsqlSessionFactory().openSession();
		//获得SqlSession
		sqlSession.delete("deleteUser",1);
		// 提交事务
		sqlSession.commit();
		System.out.println("结束");
		// 释放资源
	}	
	@Test
	public void test05() throws IOException {
		//修改指定的User
		System.out.println("开始");
		SqlSession sqlSession = MybatisUtils.getsqlSessionFactory().openSession();
		//获得SqlSession
		User user=new User();
		user.setId(51);
		user.setUsername("王远宏");
		user.setBirthday(new Date());
		user.setSex("2");
		sqlSession.update("updateUser",user);
		// 提交事务
		sqlSession.commit();
		System.out.println("结束");
		// 释放资源
	}	
	
}