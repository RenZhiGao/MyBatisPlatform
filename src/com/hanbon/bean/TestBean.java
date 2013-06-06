package com.hanbon.bean;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.hanbon.db.DBPool;

public class TestBean {
	private int t1;
	private String t2;
	private String t3;

	public int getT1() {
		return t1;
	}

	public void setT1(int t1) {
		this.t1 = t1;
	}

	public String getT2() {
		return t2;
	}

	public void setT2(String t2) {
		this.t2 = t2;
	}

	public String getT3() {
		return t3;
	}

	public void setT3(String t3) {
		this.t3 = t3;
	}
	
	public void create() {
		SqlSession sqlSession = DBPool.getSqlSession();
		sqlSession.insert("createTest", this);
		sqlSession.close();
	}
	
	public void update() {
		SqlSession sqlSession = DBPool.getSqlSession();
		sqlSession.update("setTest", this);
		sqlSession.close();
	}
	
	public void delete() {
		SqlSession sqlSession = DBPool.getSqlSession();
		sqlSession.delete("delTest", this);
		sqlSession.close();
	}
	
	public static TestBean get(int t1) {
		SqlSession sqlSession = DBPool.getSqlSession();
		TestBean bean = sqlSession.selectOne("getTestByT1", t1);
		sqlSession.close();
		return bean;
	}
	
	public static List<TestBean> getAll() {
		SqlSession sqlSession = DBPool.getSqlSession();
		List<TestBean> beans = sqlSession.selectList("getTestAll");
		sqlSession.close();
		return beans;
	}
}
