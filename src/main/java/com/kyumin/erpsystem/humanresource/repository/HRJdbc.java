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
			dto.setSalary(rs.getInt("salary"));
			dto.setPayment(rs.getInt("payment"));
			dto.setPhone(rs.getString("phone"));
			
			list.add(dto);
		}
		conn.close();
		pstmt.close();
		
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
			dto.setName(rs.getString("NAME"));
		}
		return dto;
	}

}
