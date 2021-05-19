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
import com.kyumin.erpsystem.utility.*;
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
	public List<order> findAllOrderList(Criteria cri) throws SQLException {
		String sql = "select orderno, code, name, type, department, wanteddate, applicationdate, completedate, state , ordercount "
					+"from ("
					+"select orderno, code, name, type, department, wanteddate, applicationdate, completedate, state , ordercount, "
					+"row_number() over(order by orderno asc) as rNum " 
					+"from orderItem "
					+")orderlist "
					+"where rNum between ? and ? "
					+"order by orderno asc";
		conn = dataSource.getConnection();
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, cri.getRowStart());
		pstmt.setInt(2, cri.getRowEnd());
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
			dto.setCompleteDate(rs.getString("completeDate"));
			dto.setState(rs.getInt("STATE"));
			order.add(dto);
		}
		conn.close();
		pstmt.close();
		rs.close();
		return order;
	}

	@Override
	public int completeBuy(order orderInfo) throws SQLException {
		int result = -1;
		String sql = "update item set totalcount=totalcount+? where code=?";
		
		conn = dataSource.getConnection();
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1,orderInfo.getOrderCount());
		pstmt.setInt(2,orderInfo.getCode());

		result = pstmt.executeUpdate();
		
		conn.close();
		pstmt.close();
		
		return result;
	}

	@Override
	public order findOrderByOrderNo(int orderNo) throws SQLException {
		String sql = "select code,orderCount from orderitem where orderNo = ?";
		conn = dataSource.getConnection();

		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, orderNo);
		rs = pstmt.executeQuery();
		order dto = new order();
		if (rs.next()) {
			dto.setCode(rs.getInt("CODE"));
			dto.setOrderCount(rs.getInt("orderCount"));
		}
		conn.close();
		pstmt.close();
		return dto;
	}

	@Override
	public int completeState(int orderNo) throws SQLException {
		int result = -1;
		String sql = "update orderitem set state = 1 , completeDate = TO_CHAR(SYSDATE,'YYYY-MM-DD') where orderNo=?";
		
		conn = dataSource.getConnection();
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1,orderNo);

		result = pstmt.executeUpdate();
		
		conn.close();
		pstmt.close();
		
		return result;
	}

	@Override
	public int completeReject(int orderNo) throws SQLException {
		int result = -1;
		String sql = "update orderitem set state = 2, completeDate = TO_CHAR(SYSDATE,'YYYY-MM-DD') where orderNo=?";
		
		conn = dataSource.getConnection();
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1,orderNo);

		result = pstmt.executeUpdate();
		
		conn.close();
		pstmt.close();
		
		return result;
	}

	@Override // 발주 전체 갯수
	public int getOrderListCnt() throws SQLException {
		int cnt = 0;
		String sql = "select count(*) AS totalcount from orderItem";		
		conn = dataSource.getConnection();
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			cnt = (rs.getInt("totalcount"));
		}
		
		conn.close();
		pstmt.close();
		return cnt;
	}

	@Override // 미처리된 발주 갯수
	public int getOrderListCnt(int waitOrderCount) throws SQLException {
		// TODO Auto-generated method stub
		int cnt = 0;
		String sql = "select count(*) AS waitOrderCount from orderItem where state=?";		
		conn = dataSource.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,waitOrderCount);
		
		rs = pstmt.executeQuery();
		if (rs.next()) {
			cnt = (rs.getInt("waitOrderCount"));
		}
		
		conn.close();
		pstmt.close();
		return cnt;
	}

	@Override
	public List<order> findOrderByList(String orderBy) throws SQLException {
	String sql = "select * from orderitem order by state " + orderBy;
//	String sql = "select orderno, code, name, type, department, wanteddate, applicationdate, completedate, state , ordercount "
//			+"from ("
//			+"select orderno, code, name, type, department, wanteddate, applicationdate, completedate, state , ordercount, "
//			+"row_number() over(order by state "+orderBy+") as rNum " 
//			+"from orderItem "
//			+")orderlist "
//			+"where rNum between ? and ? "
//			+"order by state " + orderBy;
	conn = dataSource.getConnection();
	
//	pstmt.setInt(1, cri.getRowStart());
//	pstmt.setInt(2, cri.getRowEnd());
	
	pstmt = conn.prepareStatement(sql);

	rs = pstmt.executeQuery();
	
	List<order> orderByList = new ArrayList<order>();
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
		dto.setCompleteDate(rs.getString("completeDate"));
		dto.setState(rs.getInt("STATE"));
		orderByList.add(dto);
	}
	conn.close();
	pstmt.close();
	
	return orderByList;
	}

}
