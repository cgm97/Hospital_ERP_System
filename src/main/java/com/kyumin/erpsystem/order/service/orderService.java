package com.kyumin.erpsystem.order.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyumin.erpsystem.order.domain.Criteria;
import com.kyumin.erpsystem.order.domain.order;
import com.kyumin.erpsystem.order.repository.orderRepository;

@Service
public class orderService {
	
	@Autowired
	private orderRepository dao;
	
	// 약품 검색
	public order findByDrugName(String drugName) throws SQLException {
		return dao.findbyDrugName(drugName);
	}
	
	// 약품 주문 
	public int orderItem(order orderInfo) throws SQLException {
		return dao.orderItem(orderInfo);
	}
	
	// 약품 발주 목록 리스트
	public List<order> findAllOrderList(Criteria cri) throws SQLException {
		return dao.findAllOrderList(cri);
	}

	// 약품 발주 완료 처리
	public int completeBuy(order orderInfo,int orderNo) throws SQLException {	
		// 주문상태 완료 처리
		dao.completeState(orderNo);
		
		return dao.completeBuy(orderInfo);
	}
	
	// 약품 발주 거절 처리
	public int completeReject(int orderNo) throws SQLException {
		return dao.completeReject(orderNo);
	}

	// 발주 번호로 해당되는 약품의 정보 가져오기
	public order findOrderByOrderNo(int orderNo) throws SQLException {
		return dao.findOrderByOrderNo(orderNo);
	}

	// 페이징 하기위해 발주리스트 총 갯수
	public int getOrderListCnt() throws SQLException {
		return dao.getOrderListCnt();
	}
}
