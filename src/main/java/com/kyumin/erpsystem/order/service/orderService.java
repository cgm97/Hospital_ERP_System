package com.kyumin.erpsystem.order.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kyumin.erpsystem.order.domain.order;
import com.kyumin.erpsystem.order.repository.orderRepository;

@Service
public class orderService {
	
	@Autowired
	private orderRepository dao;
	
	public order findByDrugName(String drugName) throws SQLException {
		return dao.findbyDrugName(drugName);
	}

	public int orderItem(order orderInfo) throws SQLException {
		return dao.orderItem(orderInfo);
	}

	public List<order> findAllOrderList() throws SQLException {
		return dao.findAllOrderList();
	}
}
