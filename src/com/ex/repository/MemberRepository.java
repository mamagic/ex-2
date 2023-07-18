package com.ex.repository;

import java.util.Optional;

import com.ex.domain.Member;

public interface MemberRepository {
	public void save(Member member);
	public void delete(String id);
	public Optional<Member> find(String id);
	public void update(Member member);

}
