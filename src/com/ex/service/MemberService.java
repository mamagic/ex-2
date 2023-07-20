package com.ex.service;

import java.sql.SQLException;
import java.util.Optional;

import com.ex.domain.Member;

public interface MemberService {
	
	void register(Member member) throws SQLException;
	Optional<Member> find(String id);
	void update(Member member);
	void delete(String id);
}
