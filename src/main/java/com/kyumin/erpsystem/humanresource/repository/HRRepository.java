package com.kyumin.erpsystem.humanresource.repository;

import java.sql.SQLException;
import java.util.List;

import com.kyumin.erpsystem.humanresource.domain.Member;
import com.kyumin.erpsystem.humanresource.domain.Salary;

public interface HRRepository {
	
	// 총 직원 리스트 가져오기
	List<Member> findAllMemberList() throws SQLException;
	// 해당 직원 정보
	Member findMemberInfoByNo(int memberNo) throws SQLException;
	// 급여 검샘할 대상 사원번호 검색
	int findMemberNoByName(String name)throws SQLException;
	// 검색된 사원의 급여 조회
	List<Salary> findMemberSalaryList(int memberNo) throws SQLException;
	

	
}
