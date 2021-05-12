package com.kyumin.erpsystem.item.repository;

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

import com.kyumin.erpsystem.item.domain.inventoryDTO;
import com.kyumin.erpsystem.item.domain.itemUse;

@Repository
public class ItemJDBC implements ItemRepository {

	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	@Override
	public int useItem(itemUse item) throws SQLException {
		int result = -1;	
		String sql = "update item set totalcount=totalcount-? where code=?";

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,item.getUseCount());
			pstmt.setInt(2,item.getCode());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			conn.close();
			pstmt.close();
			
		}
		return result;
	}
	
	@Override
	public List<inventoryDTO> findAllInventoryList() throws SQLException {
		String sql = "select * from Item";
		conn = dataSource.getConnection();
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		List<inventoryDTO> list = new ArrayList<inventoryDTO>();
		while(rs.next()) {
			inventoryDTO dto = new inventoryDTO();
			dto.setCode(rs.getInt("CODE"));
			dto.setName(rs.getString("NAME"));
			dto.setType(rs.getString("TYPE"));
			dto.setDepartment(rs.getString("DEPARTMENT"));
			dto.setTotalCount(rs.getInt("totalCount"));
			
			list.add(dto);
		}
		conn.close();
		pstmt.close();
		return list;
	}

	@Override
	public itemUse findByDrugName(String durgName) throws SQLException {
		String sql = "select * from ITEM WHERE NAME=?";
		conn = dataSource.getConnection();
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, durgName);
		rs = pstmt.executeQuery();
		
		itemUse dto = new itemUse();
		if (rs.next()) {
			dto.setCode(rs.getInt("CODE"));
			dto.setName(rs.getString("NAME"));
			dto.setType(rs.getString("TYPE"));
		}
		conn.close();
		pstmt.close();
		return dto;
	}

}
