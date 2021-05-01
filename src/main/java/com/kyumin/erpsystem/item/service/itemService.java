package com.kyumin.erpsystem.item.service;

import org.springframework.stereotype.Service;

import com.kyumin.erpsystem.item.domain.itemUse;

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
	
}
