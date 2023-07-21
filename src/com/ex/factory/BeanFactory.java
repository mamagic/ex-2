package com.ex.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.ex.dao.UserDaoJdbc;
import com.ex.proxy.ActionHandler;
import com.ex.repository.MemberRepository;
import com.ex.repository.MemberRepositoryImpl;
import com.ex.service.MemberService;
import com.ex.service.MemberServiceImpl;

import oracle.jdbc.datasource.OracleDataSource;

@Configuration
public class BeanFactory {
	
	@Bean
	public DataSource dataSource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		
		//oracle
		dataSource.setDriverClass(oracle.jdbc.driver.OracleDriver.class);
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:ORCL");
		dataSource.setUsername("c##ryu");
		dataSource.setPassword("1234");
		
		//mysql
//		dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
//		dataSource.setUrl("jdbc:mysql://localhost:3306/sbdt_db1?characterEncoding=UTF-8");
//		dataSource.setUsername("root");
//		dataSource.setPassword("QWERzxc!@#1234");
		
		return dataSource;
	}

	@Bean
	public MemberRepository memberRepository() {
		return new MemberRepositoryImpl();
	}
	
	@Bean
	public MemberService memberService() {
		MemberServiceImpl service = new MemberServiceImpl();
		service.setProxyMemberRepository(new ActionHandler(memberRepository()));
		return service;
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
	
//	@Bean
//	public InvocationHandler actionHandler() {
//		InvocationHandler actionHandler = (InvocationHandler) new ActionHandler(memberRepository());
//		return actionHandler; 
//	}
}
