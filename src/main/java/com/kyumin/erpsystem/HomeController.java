package com.kyumin.erpsystem;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kyumin.erpsystem.humanresource.service.HRService;
import com.kyumin.erpsystem.order.service.orderService;

@Controller
public class HomeController {
	
	@Autowired
	private orderService orderService;
	@Autowired
	private HRService hrService;
	
	@GetMapping("/")
	public String main(Model model) throws SQLException {
		int waitOrderCount = 0;
		
		model.addAttribute("waitOrderCount",orderService.getOrderListCnt(waitOrderCount));
		model.addAttribute("memberCount",hrService.getMemberCnt());
		
		return "main";
	}	
}
