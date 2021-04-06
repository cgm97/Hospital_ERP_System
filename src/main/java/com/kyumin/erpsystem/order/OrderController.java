package com.kyumin.erpsystem.order;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "/order/orderAdd";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() {
		return "/order/orderList";
	}
}
