package com.ex.repository;

import java.util.Optional;

import com.ex.domain.Member;

public interface MemberRepository {
	void save(Member member);
	void delete(String id);
	Optional<Member> find(String id);
	void update(Member member);
	int getCount();

}
