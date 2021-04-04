package com.kyumin.erpsystem.emr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emr")
public class EmrController {
	
	@GetMapping("/add")
	public String list() {
		return "/emr/emrAdd";
	}
	
	@GetMapping("/list")
	public String schedule() {
		return "/emr/emrList";
	}
}
