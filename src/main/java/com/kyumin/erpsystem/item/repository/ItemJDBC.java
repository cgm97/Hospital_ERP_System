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
	public List<inventoryDTO> findAllInventoryList() throws SQLException {
		String sql = "select * from ITEM";
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
			
			list.add(dto);
		}
		System.out.println("testtest");
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
		return dto;
	}

}
