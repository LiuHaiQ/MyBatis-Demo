package com.itheima.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.Null;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
	static private SqlSessionFactory sqlSessionFactory = null;

public static SqlSessionFactory getsqlSessionFactory() throws IOException {
	//创建SqlSessionFactory对象
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
	//创建sqlSessionFactoryBuilder
			InputStream inStream = Resources.getResourceAsStream("SqlMapConfig.xml");
	//加载配置文件
			sqlSessionFactory  = sqlSessionFactoryBuilder.build(inStream);
			return sqlSessionFactory;
}
}
