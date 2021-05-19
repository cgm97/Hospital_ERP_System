package com.kyumin.erpsystem.order.repository;

import java.sql.SQLException;
import java.util.List;
import com.kyumin.erpsystem.utility.*;
import com.kyumin.erpsystem.order.domain.order;

public interface orderRepository {
	// 약품검색
	order findbyDrugName(String drugName) throws SQLException;
	
	// 약품 주문 신청
	int orderItem(order orderInfo) throws SQLException;
	
	// 발주 리스트
	List<order> findAllOrderList(Criteria cri) throws SQLException;
	
	// 발주 처리 완료
	int completeBuy(order orderInfo) throws SQLException;
	
	// 발주 거절
	int completeReject(int orderNo) throws SQLException;
	
	// 발주 처리 와 거절시 상태 값 
	int completeState(int orderNo) throws SQLException;
	
	// 발주 번호로 해당되는 약품 정보 가져오기
	order findOrderByOrderNo(int orderNo) throws SQLException;
	
	// 페이징을 위한 발주 목록 갯수
	int getOrderListCnt() throws SQLException;

	// 미처리된 발주 목록 갯수
	int getOrderListCnt(int waitOrderCount) throws SQLException;
	
	// 미처리된 발주 목록
	List<order> findOrderByList(String orderBy) throws SQLException;

}
