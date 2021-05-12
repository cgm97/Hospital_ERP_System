package com.kyumin.erpsystem.item.service;

import java.sql.SQLException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyumin.erpsystem.item.domain.inventoryDTO;
import com.kyumin.erpsystem.item.domain.itemUse;
import com.kyumin.erpsystem.item.domain.machineDTO;
import com.kyumin.erpsystem.item.repository.ItemRepository;

@Service
public class itemService {

	@Autowired
	private ItemRepository dao;
	
	public int usedItem(itemUse item) throws SQLException {
		return dao.useItem(item);
	}

	public itemUse findByDrugName(String drugName) throws SQLException {

		return dao.findByDrugName(drugName);
	}

	public List<machineDTO> findAllMachineList() {
		List<machineDTO> machineList = new ArrayList<machineDTO>();
		for (int i=0; i<3; i++) {
			machineDTO info = new machineDTO();
			info.setCode(111);
			info.setName("장남감");
			info.setLocation("우리집");
			info.setDepartment("간호병동");
			info.setBuyDate("2021/02/01");
			info.setInspectionDate("2021/05/02");
			machineList.add(info);
		}
				
		return machineList;
	}

	public List<inventoryDTO> findAllInventoryList() throws SQLException {
//		List<inventoryDTO> list = new ArrayList<inventoryDTO>();
//		inventoryDTO info = new inventoryDTO();
//		for (int i=0; i<3; i++) {
//			info.setCode(231);
//			info.setName("수면제");
//			info.setType("20ml");
//			info.setTotalCount(200);
//			info.setDepartmentA(10);
//			info.setDepartmentB(90);
//			info.setDepartmentC(100);
//			list.add(info);
//		}

		return dao.findAllInventoryList();
	}
	
}
