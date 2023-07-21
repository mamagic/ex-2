package com.ex.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ex.domain.Member;
import com.ex.repository.MemberRepository;

public class UserDaoJdbc implements MemberRepository{

	@Autowired
	JdbcTemplate jdbcTemplate;


	@Override
	public void save(Member member) {
		jdbcTemplate.update("insert into users(id, name) values(?,?)"
					, member.getId(), member.getName());
	}

	@Override
	public void delete(String id) {
		jdbcTemplate.update("delete from users where id = ?", id);
	}

	@Override
	public Optional<Member> find(String id) {
		List<Map<String, Object>> result = jdbcTemplate.queryForList("select * from users where id = ?", id);
		Member m = new Member();
		if(id.equals(result.get(0).get("id"))){
			m.SetId(id);
			m.SetName((String)result.get(0).get("name"));
		}
		return Optional.of(m);
	}

	@Override
	public void update(Member member) {
		jdbcTemplate.update("update users set name = ? where id = ?", member.getName(), member.getId());
	}

	@Override
	public int getCount() {
		List<Integer> result = jdbcTemplate.queryForList("select count(*) from users", Integer.class);
		return result.get(0);
	}

	@Override
	public void deleteAll() {
		jdbcTemplate.update("delete from users");
	}

}
