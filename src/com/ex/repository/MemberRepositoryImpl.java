package com.ex.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ex.domain.Member;

public class MemberRepositoryImpl implements MemberRepository{
	
	List<Member> members = new ArrayList<>();

	@Override
	public void save(Member member) {
		members.add(member);
	}

	@Override
	public Optional<Member> find(String id) {
		Member member = new Member();
		member.SetId(id);
		return findMember(member);
	}

	@Override
	public void delete(String id) {
		Member member = new Member();
		member.SetId(id);
		members.remove(findMember(member).get());
	}

	@Override
	public void update(Member member) {
		for(int i = 0; i < members.size(); i++) {
			if(members.get(i).getId().equals(member.getId())){
				members.get(i).SetName(member.getName());
				break;
			}
		}
	}
	
	public Optional<Member> findMember(Member member) {

		for(Member item: members) {
			if(item.getId().equals(member.getId())) {
				return Optional.of(item);
			}
		}
		
		return Optional.empty();
	}

}
