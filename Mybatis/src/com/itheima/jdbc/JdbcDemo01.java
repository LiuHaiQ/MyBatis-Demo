package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcDemo01 {

	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 加载驱动
			Connection connection = DriverManager.getConnection("jdbc:mysql:///mybatis", "root", "123456");

			String sql = "select *from user ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getString("username"));
			}
			if (resultSet!=null) {
				resultSet.close();
			}
			if (preparedStatement!=null) {
				preparedStatement.close();
			}
			if (connection!=null) {
				connection.close();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		}
	}

}
