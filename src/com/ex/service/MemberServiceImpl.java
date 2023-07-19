package com.ex.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ex.domain.Member;
import com.ex.repository.MemberRepository;

public class MemberServiceImpl implements MemberService{
	
	@Autowired
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
		memberRepository.update(member);
		
	}

	@Override
	public void delete(String id) {
		memberRepository.delete(id);
		
	}

	public int getCount() {
		return memberRepository.getCount();
	}


}
