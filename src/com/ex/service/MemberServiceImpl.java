package com.ex.service;

import java.util.List;
import java.util.Optional;

import com.ex.domain.Member;
import com.ex.repository.MemberRepository;

public class MemberServiceImpl implements MemberService{
	
	MemberRepository memberRepository;
	
	public void setMemberRepository(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Override
	public void register(Member member) {
		memberRepository.save(member);
	}

	@Override
	public Optional<Member> find(String id) {
		return memberRepository.find(id);
	}

	@Override
	public void update(Member member) {
		memberRepository.save(member);
		
	}

	@Override
	public void delete(String id) {
		memberRepository.delete(id);
		
	}


}
