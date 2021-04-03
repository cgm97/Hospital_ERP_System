package com.kyumin.erpsystem;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hr")
public class HRController {
	
	@GetMapping("/employeeList")
	public String 직원목록() {
		return "/hr/employeeList";
	}
	
	@GetMapping("/schedule")
	public String 근태관리() {
		return "/hr/schedule";
	}
	
	@GetMapping("/salary")
	public String 급여관리() {
		return "/hr/salary";
	}
}
