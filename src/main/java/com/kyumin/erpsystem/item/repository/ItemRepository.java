package com.kyumin.erpsystem.item.repository;

import java.sql.SQLException;
import java.util.List;

import com.kyumin.erpsystem.item.domain.inventoryDTO;
import com.kyumin.erpsystem.item.domain.itemUse;
import com.kyumin.erpsystem.item.domain.machineDTO;

public interface ItemRepository {

	List<inventoryDTO> findAllInventoryList() throws SQLException;
	List<machineDTO> findAllMachineList() throws SQLException;
	itemUse findByDrugName(String drugName) throws SQLException;
	int useItem(itemUse item) throws SQLException;

}
