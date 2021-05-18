package com.kyumin.erpsystem.order;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kyumin.erpsystem.order.domain.Criteria;
import com.kyumin.erpsystem.order.domain.PageMaker;
import com.kyumin.erpsystem.order.domain.order;
import com.kyumin.erpsystem.order.service.orderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private orderService orderService;
	/*
	 * 주문 신청 화면
	 */
	@GetMapping("/add")
	public String add(order orderInfo){
		
		return "/order/orderAdd";
	}
	/*
	 * 주문 신청 프로세스
	 */
	@PostMapping("/order.do")
	public String ordering(order orderInfo, Model model) throws SQLException {
		int result = orderService.orderItem(orderInfo);
		
		if (result > 0) {
			model.addAttribute("msg","주문 신청 완료");
		}
		else {
			model.addAttribute("msg","주문 신청 실패");		
		}
		model.addAttribute("url","/erpsystem/order/add");
		
		return "common/alert";
	}

	/*
	 * 발주 신청 목록
	 */
	@GetMapping("/list")
	public String list(Model model, Criteria cri) throws SQLException {
		
		// 발주 리스트 가져오기
		model.addAttribute("orderList",orderService.findAllOrderList(cri));
		
		// 페이징 처리
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(orderService.getOrderListCnt());
		
		model.addAttribute("pageMaker", pageMaker);
		return "/order/orderList";
	}
	
	/* 
	 * 졍렬 발주 리스트 목록 
	 */
	@ResponseBody
	@GetMapping("/listOrderBy")
	public List<order> listOrderBy(@RequestParam String orderBy) throws SQLException {
		List<order> orderByList = new ArrayList<order>();
		System.out.println(orderBy);
		
		orderByList=orderService.findWaitOrderList(orderBy);
		
		
		return orderByList;		
	}
	
	/*
	 * 물품검색
	 */
	@ResponseBody
	@PostMapping("/itemSearch")
	public Map<String,Object> itemSearch(@RequestBody String drugName) throws SQLException {
		Map<String, Object> map = new HashMap<String, Object>();
		order drugInfo = orderService.findByDrugName(drugName);
		
		if (drugInfo != null) {
			map.put("code", drugInfo.getCode());
			map.put("type", drugInfo.getType());
			map.put("totalCount", drugInfo.getTotalCount());
		}
		else {
			map = null;
		}
		
		return map;
	}
	
	/*
	 * 구입 처리
	 */
	@ResponseBody
	@GetMapping("/buy")
	public int buy(@RequestParam int orderNo) throws SQLException {
		// 해당 발주 리스트 해당된 발주 번호로 약품 값 불러오기
		order orderInfo = orderService.findOrderByOrderNo(orderNo);
		//구매처리
		int result = orderService.completeBuy(orderInfo,orderNo);
		
		return result;
	}
	
	/*
	 * 발주 거절
	 */
	@ResponseBody
	@GetMapping("/reject")
	public int reject(@RequestParam int orderNo) throws SQLException {
		//DB -> 신청된 목록 NO의 값을 가지고 데이터 불러온 후 결과 처리
		int result = orderService.completeReject(orderNo);
		
		return result;
	}
	
	}
