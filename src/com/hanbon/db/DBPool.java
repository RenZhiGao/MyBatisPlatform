package com.hanbon.db;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public abstract class DBPool {
	private static SqlSessionFactory sessionFactory = null;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/hanbon/db/mybatis.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SqlSession getSqlSession() {
		SqlSession sqlSession = sessionFactory.openSession();
		try {
			sqlSession.getConnection().setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sqlSession;
	}
}
