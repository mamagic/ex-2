package com.ex.factory;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.ex.dao.UserDaoJdbc;
import com.ex.repository.MemberRepository;
import com.ex.repository.MemberRepositoryImpl;
import com.ex.service.MemberService;
import com.ex.service.MemberServiceImpl;

@Configuration
public class BeanFactory {
	
	@Bean
	public DataSource dataSource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		
		dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
		dataSource.setUrl("jdbc:mysql://localhost:3306/sbdt_db1?characterEncoding=UTF-8");
		dataSource.setUsername("root");
		dataSource.setPassword("QWERzxc!@#1234");
		
		return dataSource;
	}

	@Bean
	public MemberRepository memberRepository() {
		return new MemberRepositoryImpl();
	}
	
	@Bean
	public MemberService memberService() {
		//MemberServiceImpl memberService = new MemberServiceImpl();
		//memberService.setMemberRepository(memberRepository());
		return new MemberServiceImpl();
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}

	@Bean
	public UserDaoJdbc userDaoJdbc() {
		return new UserDaoJdbc();
	}
}
