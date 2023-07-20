package com.ex.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ex.dao.UserDaoJdbc;
import com.ex.domain.Member;
import com.ex.proxy.ActionHandler;

public class MemberRepositoryImpl implements MemberRepository{
	
	//List<Member> members = new ArrayList<>();
	@Autowired UserDaoJdbc userDaojdbc;
	
	@Override
	public void save(Member member) throws SQLException {
		userDaojdbc.save(member);
	}

	@Override
	public Optional<Member> find(String id) {
		return userDaojdbc.find(id);
	}

	@Override
	public void delete(String id) {
		Member member = new Member();
		member.SetId(id);
		userDaojdbc.delete(id);
	}

	@Override
	public void update(Member member) {
		userDaojdbc.update(member);
	}

	@Override
	public int getCount() {
		return userDaojdbc.getCount();
	}
	
//	public Optional<Member> findMember(Member member) {
//
//		for(Member item: members) {
//			if(item.getId().equals(member.getId())) {
//				return Optional.of(item);
//			}
//		}
//		
//		return Optional.empty();
//	}

//	@Override
//	public int getCount() {
//		return members.size(); 
//	}

}
