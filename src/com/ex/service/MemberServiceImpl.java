package com.ex.service;

import java.lang.reflect.Proxy;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

import com.ex.domain.Member;
import com.ex.proxy.ActionHandler;
import com.ex.repository.MemberRepository;

public class MemberServiceImpl implements MemberService{
	
	MemberRepository memberRepository;
	@Autowired ActionHandler actionHandler;
	
	public MemberServiceImpl() {
		
		memberRepository = (MemberRepository) Proxy.newProxyInstance(
				MemberRepository.class.getClassLoader(), 
				,
				actionHandler);
		
	}
	
	public void setMemberRepository(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Override
	public void register(Member member) {
		try {
			memberRepository.save(member);
		}
		catch(DuplicateKeyException e) {
			System.out.println("등록과정에서 id 중복발견");
		}catch(SQLException e) {
			e.printStackTrace();
		}
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
