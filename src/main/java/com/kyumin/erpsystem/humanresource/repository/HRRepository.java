package com.kyumin.erpsystem.humanresource.repository;

import java.sql.SQLException;
import java.util.List;

import com.kyumin.erpsystem.humanresource.domain.Member;

public interface HRRepository {
	
	// 총 직원 리스트 가져오기
	List<Member> findAllMemberList() throws SQLException;
	// 해당 직원 정보
	Member findMemberInfoByNo(int memberNo) throws SQLException;

	
}
