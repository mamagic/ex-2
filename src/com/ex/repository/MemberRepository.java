package com.ex.repository;

import java.sql.SQLException;
import java.util.Optional;

import com.ex.domain.Member;

public interface MemberRepository {
	void save(Member member) throws SQLException;
	void delete(String id);
	void deleteAll();
	Optional<Member> find(String id);
	void update(Member member);
	int getCount();

}
