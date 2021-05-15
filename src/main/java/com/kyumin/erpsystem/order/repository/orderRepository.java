package com.kyumin.erpsystem.order.repository;

import java.sql.SQLException;
import java.util.List;

import com.kyumin.erpsystem.order.domain.order;

public interface orderRepository {
	order findbyDrugName(String drugName) throws SQLException;
	int orderItem(order orderInfo) throws SQLException;
	List<order> findAllOrderList() throws SQLException;
}
