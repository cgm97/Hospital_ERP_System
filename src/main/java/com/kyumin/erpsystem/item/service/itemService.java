package com.kyumin.erpsystem.item.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.kyumin.erpsystem.item.domain.inventoryDTO;
import com.kyumin.erpsystem.item.domain.itemUse;
import com.kyumin.erpsystem.item.domain.machineDTO;

@Service
public class itemService {

	public void usedItem(itemUse item) {
		System.out.print(item);
	}

	public itemUse findByDrugName(String drugName) {
		itemUse info = new itemUse();
		info.setDrugCode(4765);
		info.setDrugType("50ml");
		return info;
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

	public List<inventoryDTO> findAllInventoryList() {
		List<inventoryDTO> list = new ArrayList<inventoryDTO>();
		inventoryDTO info = new inventoryDTO();
		for (int i=0; i<3; i++) {
			info.setCode(231);
			info.setName("수면제");
			info.setSize("20ml");
			info.setTotalCount(200);
			info.setDepartmentA(10);
			info.setDepartmentB(90);
			info.setDepartmentC(100);
			list.add(info);
		}

		return list;
	}
	
}
