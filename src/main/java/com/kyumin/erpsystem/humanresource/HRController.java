package com.kyumin.erpsystem.humanresource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/humanResource")
public class HRController {
	
	@GetMapping("/list")
	public String list() {
		return "/hr/employeeList";
	}
	
	@GetMapping("/schedule")
	public String schedule() {
		return "/hr/schedule";
	}
	
	@GetMapping("/salary")
	public String salary() {
		return "/hr/salary";
	}
}
