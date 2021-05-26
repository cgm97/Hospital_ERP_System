package com.kyumin.erpsystem.humanresource.repository;

import java.sql.SQLException;
import java.util.List;

import com.kyumin.erpsystem.humanresource.domain.Member;
import com.kyumin.erpsystem.humanresource.domain.Salary;
import com.kyumin.erpsystem.humanresource.domain.Schedule;

public interface HRRepository {
	
	// 총 직원 리스트 가져오기
	List<Member> findAllMemberList() throws SQLException;
	// 해당 직원 정보
	Member findMemberInfoByNo(int memberNo) throws SQLException;
	// 급여 검샘할 대상 사원번호 검색
	int findMemberNoByName(String name)throws SQLException;
	// 검색된 사원의 급여 조회
	List<Salary> findMemberSalaryList(int memberNo) throws SQLException;
	// 현재 재직중인 직원 수
	int getMemberCnt() throws SQLException;
	// 근태기록 불러오기
	List<Schedule> getScheduleListbyMemeberNo(int memeberNo) throws SQLException;
	// 근무 기록 저장
	int insertSchedule(Schedule schedule) throws SQLException;
	// 클릭된 근무지 불러오기
	Schedule getSchedulebyNo(int scheduleNo) throws SQLException;
	

	
}
