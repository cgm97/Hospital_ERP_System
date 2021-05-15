package com.kyumin.erpsystem.order.repository;

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
import com.kyumin.erpsystem.order.domain.order;

@Repository
public class orderJDBC implements orderRepository {

	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Override
	public order findbyDrugName(String drugName) throws SQLException {
		String sql = "select * from item WHERE NAME=?";
		conn = dataSource.getConnection();
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, drugName);
		rs = pstmt.executeQuery();
		
		order dto = new order();
		if (rs.next()) {
			dto.setCode(rs.getInt("CODE"));
			dto.setName(rs.getString("NAME"));
			dto.setType(rs.getString("TYPE"));
			dto.setTotalCount(rs.getInt("totalCount"));
		}
		conn.close();
		pstmt.close();
		return dto;
	}

	@Override
	public int orderItem(order orderInfo) throws SQLException {
		String sql = "INSERT INTO ORDERITEM (ORDERNO, CODE, NAME, TYPE,ORDERCOUNT, DEPARTMENT, WANTEDDATE, APPLICATIONDATE)"
				+ "VALUES(ORDERNO.NEXTVAL,?,?,?,?,?,?,TO_CHAR(SYSDATE,'YYYY-MM-DD'))";

		conn = dataSource.getConnection();
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1,orderInfo.getCode());
		pstmt.setString(2,orderInfo.getName());
		pstmt.setString(3,orderInfo.getType());
		pstmt.setInt(4,orderInfo.getOrderCount());
		pstmt.setString(5,orderInfo.getDepartment());
		pstmt.setString(6, orderInfo.getWantedDate());
		
		int result = pstmt.executeUpdate();
		conn.close();
		pstmt.close();
		
		return result;
	}

	@Override
	public List<order> findAllOrderList() throws SQLException {
		String sql = "select * from orderitem";
		conn = dataSource.getConnection();
		
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		List<order> order = new ArrayList<order>();
		while (rs.next()) {
			order dto = new order();
			dto.setOrderNo(rs.getInt("orderNo"));
			dto.setDepartment(rs.getString("department"));
			dto.setCode(rs.getInt("CODE"));
			dto.setName(rs.getString("NAME"));
			dto.setType(rs.getString("TYPE"));
			dto.setOrderCount(rs.getInt("orderCount"));
			dto.setApplicationDate(rs.getString("applicationDate"));
			dto.setWantedDate(rs.getString("wantedDate"));
			order.add(dto);
		}
		conn.close();
		pstmt.close();
		return order;
	}

}
