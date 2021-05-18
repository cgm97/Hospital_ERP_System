package com.kyumin.erpsystem;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kyumin.erpsystem.order.service.orderService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private orderService orderService;
	@GetMapping("/")
	public String main(Model model) throws SQLException {
		int waitOrderCount = 0;
		model.addAttribute("waitOrderCount",orderService.getOrderListCnt(waitOrderCount));
		
		return "main";
	}	
}
