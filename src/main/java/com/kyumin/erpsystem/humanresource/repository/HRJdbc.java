package com.kyumin.erpsystem.humanresource.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.kyumin.erpsystem.humanresource.domain.Member;
import com.kyumin.erpsystem.humanresource.domain.Salary;
import com.kyumin.erpsystem.humanresource.domain.Schedule;

@Repository
public class HRJdbc implements HRRepository{

	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Override
	public List<Member> findAllMemberList() throws SQLException {
		String sql = "select * from MEMBER";
		conn = dataSource.getConnection();
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		List<Member> list = new ArrayList<Member>();
		while(rs.next()) {
			Member dto = new Member();
			dto.setMemberNo(rs.getInt("memberNo"));
			dto.setName(rs.getString("name"));
			dto.setDepartment(rs.getString("department"));
			dto.setRank(rs.getString("rank"));
			dto.setJoinDate(rs.getString("joinDate"));
			dto.setPayment(rs.getInt("payment"));
			dto.setPhone(rs.getString("phone"));
			
			list.add(dto);
		}
		conn.close();
		pstmt.close();
		rs.close();
		return list;
	}

	@Override
	public Member findMemberInfoByNo(int memberNo) throws SQLException {
		String sql = "select * from MEMBER WHERE MEMBERNO=?";
		conn = dataSource.getConnection();	
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, memberNo);
		rs = pstmt.executeQuery();
		
		Member dto = new Member();
		if (rs.next()) {
			dto.setMemberNo(rs.getInt("memberNo"));
			dto.setName(rs.getString("name"));
			dto.setDepartment(rs.getString("department"));
			dto.setRank(rs.getString("rank"));
			dto.setJoinDate(rs.getString("joinDate"));
			dto.setPayment(rs.getInt("payment"));
			dto.setPhone(rs.getString("phone"));
		}
		conn.close();
		pstmt.close();
		rs.close();
		return dto;
	}

	@Override
	public int findMemberNoByName(String name) throws SQLException {
		String sql = "select memberNo from MEMBER WHERE name=?";
		conn = dataSource.getConnection();	
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		rs = pstmt.executeQuery();
		
		int memberNo = -1;
		if (rs.next()) {
			memberNo = rs.getInt("memberNo");
		}
		conn.close();
		pstmt.close();
		rs.close();
		return memberNo;
	}

	@Override
	public List<Salary> findMemberSalaryList(int memberNo) throws SQLException {
		String sql = "select * from SALARY where MemberNo = ? order By paidDate asc";
		conn = dataSource.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, memberNo);
		rs = pstmt.executeQuery();
		
		List<Salary> list = new ArrayList<Salary>();
		while(rs.next()) {
			Salary dto = new Salary(rs.getInt("monthSalary"),rs.getString("paidDate"));
			list.add(dto);
		}
		conn.close();
		pstmt.close();
		rs.close();
		
		return list;
	}

	@Override
	public int getMemberCnt() throws SQLException {
		int cnt = 0;
		String sql = "select count(*) AS totalcount from Member";		
		conn = dataSource.getConnection();
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			cnt = (rs.getInt("totalcount"));
		}
		
		conn.close();
		pstmt.close();
		rs.close();
		
		return cnt;
	}

	@Override
	public List<Schedule> getScheduleListbyMemeberNo(int memeberNo) throws SQLException {
		String sql = "select * from Schedule where memberno = ?";
		
		conn = dataSource.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, memeberNo);
		rs = pstmt.executeQuery();
		
		List<Schedule> list = new ArrayList<Schedule>();
		while(rs.next()) {
			Schedule dto = new Schedule();
			dto.setToday(rs.getString("today"));
			dto.setStartTime(rs.getString("startTime"));
			dto.setEndTime(rs.getString("endTime"));
			dto.setDiffTime(rs.getInt("diffTime"));
			dto.setScheduleNo(rs.getInt("scheduleNo"));
			list.add(dto);
		}
		conn.close();
		pstmt.close();
		rs.close();
		
		return list;
	}

	@Override
	public int insertSchedule(Schedule schedule) throws SQLException {
		String sql = "insert into SCHEDULE values(?,?,?,?,1,SCHEDULENO.NEXTVAL)"; // 로그인 으로 변경 예정 -> 1
		int result = -1;
		
		conn = dataSource.getConnection();
		pstmt = conn.prepareStatement(sql);		
		
		
		pstmt.setString(1, schedule.getToday());
		pstmt.setString(2, schedule.getStartTime());
		pstmt.setString(3, schedule.getEndTime());
		pstmt.setDouble(4, schedule.getDiffTime());
		
		result = pstmt.executeUpdate();
		
		conn.close();
		pstmt.close();
		
		return result;
	}

	@Override
	public Schedule getSchedulebyNo(int scheduleNo) throws SQLException {
		String sql = "select * from Schedule where ScheduleNo = ?";
		
		conn = dataSource.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, scheduleNo);
		rs = pstmt.executeQuery();
		
		Schedule dto = new Schedule();
		if (rs.next()) {
			dto.setToday(rs.getString("today"));
			dto.setStartTime(rs.getString("startTime"));
			dto.setEndTime(rs.getString("endTime"));
			dto.setDiffTime(rs.getDouble("diffTime"));
			dto.setScheduleNo(rs.getInt("scheduleNo"));
		}
		conn.close();
		pstmt.close();
		rs.close();
		
		return dto;
	}
}
