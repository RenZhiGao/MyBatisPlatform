package com.hanbon.bean;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import com.hanbon.bean.TestBean;

public class TestBeanTest {

	@Test
	public void testCreate() {
		 TestBean bean = new TestBean();
		 bean.setT1(1);
		 bean.setT2("Me");
		 bean.setT3("what");
		 bean.create();
	}
	
	@Test
	public void testUpdate() {
		 TestBean bean = TestBean.get(1);
		 bean.setT2("Change");
		 bean.setT3("when");
		 bean.update();
	}

	@Test
	public void testDelete() {
		TestBean bean = new TestBean();
		 bean.setT1(1);
		 bean.setT2("Me");
		 bean.setT3("what");
		 bean.delete();
	}
	
	@Test
	public void testGet() {
		System.out.println(TestBean.get(1));
		System.out.println(TestBean.get(0));
	}
	
	@Test
	public void testGetAll() throws JsonGenerationException, JsonMappingException, IOException {
		List<TestBean> beans = TestBean.getAll();
		System.out.println(new ObjectMapper().writeValueAsString(beans));
	}
}
