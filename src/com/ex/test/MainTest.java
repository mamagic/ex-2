package com.ex.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ex.domain.Member;
import com.ex.service.MemberServiceImpl;

public class MainTest {
	
	MemberServiceImpl service;
	Member[] members;
	public static void main(String[] args) {

	}
	
	@BeforeEach
	void setUp() {
		service = new MemberServiceImpl();
		members = new Member[5];
		
		members[0].SetId("1");
		members[0].SetName("홍길동");
		members[1].SetId("2");
		members[1].SetName("김길수");
		members[2].SetId("3");
		members[2].SetName("전지현");
		members[3].SetId("4");
		members[3].SetName("노종길");
		members[4].SetId("5");
		members[4].SetName("김태희");
	}

	@Test
	public void add() {
		service.register(members[0]);
		service.register(members[1]);
		service.register(members[2]);
		service.register(members[3]);
		service.register(members[4]);
		
		assertEquals("전지현", service.find("3").get());
	}
}
