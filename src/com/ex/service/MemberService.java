package com.ex.service;

import java.util.Optional;

import com.ex.domain.Member;

public interface MemberService {
	
	void register(Member member);
	Optional<Member> find(String id);
	void update(Member member);
	void delete(String id);
}
