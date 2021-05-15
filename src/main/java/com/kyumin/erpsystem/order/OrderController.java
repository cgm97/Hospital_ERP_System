package com.kyumin.erpsystem.order;

import java.sql.SQLException;
import java.util.HashMap;
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
	public String ordering(order orderInfo) throws SQLException {
		orderService.orderItem(orderInfo);
		return "/order/orderAdd";
	}
	
	@GetMapping("/list")
	public String list(Model model) throws SQLException {
		model.addAttribute("orderList",orderService.findAllOrderList());
		return "/order/orderList";
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
	public int buy(@RequestParam int orderNo) {
		//DB -> 신청된 목록 NO의 값을 가지고 데이터 불러온 후 결과 처리
		return 0;
	}
	
	/*
	 * 발주 거절
	 */
	@ResponseBody
	@GetMapping("/reject")
	public int reject(@RequestParam int orderNo) {
		//DB -> 신청된 목록 NO의 값을 가지고 데이터 불러온 후 결과 처리
		return 1;
	}
	
	}
