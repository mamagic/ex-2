package com.ex.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ex.domain.Member;
import com.ex.factory.BeanFactory;
import com.ex.service.MemberServiceImpl;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {BeanFactory.class})
public class MainTest {
	
	@Autowired
	MemberServiceImpl service;

	public static void main(String[] args) {

	}
	
	@BeforeEach
	void setUp() {

	}

	@Test
	public void add() {
		deleteAll();
		Member m = new Member();
		m.SetId("1");
		m.SetName("위형준3");
		service.register(m);

		assertEquals("위형준3", service.find("1").get().getName());
	}
	
	@Test
	public void delete() {
		deleteAll();
		assertEquals(service.getCount(), 0);
	}
	
	@Test
	public void deleteAll() {
		service.deleteAll();
	}
	
	@Test
	public void update() {
		Member m = new Member();
		m.SetId("1");
		m.SetName("장동건");
		
		service.update(m);

		assertEquals(m.getName(), service.find("14").get().getName());
	}

	@Test
	public void find() {
		assertEquals("14", service.find("14").get().getId());
	}
}
