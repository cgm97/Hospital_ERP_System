package com.kyumin.erpsystem.humanresource.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyumin.erpsystem.humanresource.domain.Member;
import com.kyumin.erpsystem.humanresource.domain.Salary;
import com.kyumin.erpsystem.humanresource.domain.Schedule;
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

	public List<Salary> findMemberSalaryList(String name) throws SQLException {
		int memberNo = dao.findMemberNoByName(name);
		
		return dao.findMemberSalaryList(memberNo);
	}

	public int getMemberCnt() throws SQLException {
		return dao.getMemberCnt();
	}

	public List<Schedule> getScheduleListbyName(String name) throws SQLException {
		int memberNo = dao.findMemberNoByName(name);
		return dao.getScheduleListbyMemeberNo(memberNo);
	}

	public int workRec(Schedule schedule) throws ParseException, SQLException {
		schedule.setDiffTime(diffTimeCal(schedule.getStartTime(),schedule.getEndTime()));
		
		return dao.insertSchedule(schedule);
	}
	
	// 근무한 시간 계산
	private double diffTimeCal(String startTime, String endTime) throws ParseException {
		SimpleDateFormat f = new SimpleDateFormat("HH:mm", Locale.KOREA);
		Date d1 = f.parse(startTime);
		Date d2 = f.parse(endTime);
		double diff = (d2.getTime() - d1.getTime()) * 100;
		double hour = Math.round(diff / (1000*60*60)) / 100.0;

		return hour;		
	}

	public Schedule getSchedulebyNo(int scheduleNo) throws SQLException {
		return dao.getSchedulebyNo(scheduleNo);
	}
	
	
}
