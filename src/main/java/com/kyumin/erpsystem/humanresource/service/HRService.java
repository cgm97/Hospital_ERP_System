package com.kyumin.erpsystem.humanresource.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyumin.erpsystem.humanresource.domain.Member;
import com.kyumin.erpsystem.humanresource.repository.HRRepository;

@Service
public class HRService {
	
	@Autowired
	private HRRepository dao;

	public List<Member> findAllMemberList() throws SQLException {		
		return dao.findAllMemberList();
	}

	public Member findMemberInfoByNo(int memberNo) throws SQLException {
		return dao.findMemberInfoByNo(memberNo);
	}
	
	
}
