package com.kyumin.erpsystem.item.repository;

import java.sql.SQLException;
import java.util.List;

import com.kyumin.erpsystem.item.domain.inventoryDTO;
import com.kyumin.erpsystem.item.domain.itemUse;

public interface ItemRepository {

	List<inventoryDTO> findAllInventoryList() throws SQLException;
	itemUse findByDrugName(String drugName) throws SQLException;

}
