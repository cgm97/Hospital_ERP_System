package com.kyumin.erpsystem;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.kyumin.erpsystem.humanresource.service.HRService;
import com.kyumin.erpsystem.member.jwt.AuthenticateRequest;
import com.kyumin.erpsystem.member.jwt.AuthenticationResponse;
import com.kyumin.erpsystem.order.service.orderService;
import com.kyumin.erpsystem.utility.JwtUtil;

@Controller
public class HomeController {
	
	@Autowired
	private orderService orderService;
	@Autowired
	private HRService hrService;
	@Autowired
	private JwtUtil jwtUtil;
	
	@GetMapping("/")
	public String main(Model model) throws SQLException {
		int waitOrderCount = 0;
		
		model.addAttribute("waitOrderCount",orderService.getOrderListCnt(waitOrderCount));
		model.addAttribute("memberCount",hrService.getMemberCnt());
		
		return "main";
	}	
	
	@GetMapping("/login")
	public String login(Model model) throws SQLException {

		return "login";
	}	
	
	@PostMapping("/authenticate")
	public String authenticate(AuthenticateRequest userDetail,Model model){		
		// Login user create Token
		AuthenticationResponse token = new AuthenticationResponse(jwtUtil.createToken(userDetail, "authenticate"));
		model.addAttribute("token", token.getToken());

		return "common/tokenSave";	
	}
}
