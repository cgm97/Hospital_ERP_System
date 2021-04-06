package com.kyumin.erpsystem.patient;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/patient")
public class PatientController {
	
	@GetMapping("/add")
	public String add() {
		return "/patient/patientAdd";
	}

	@GetMapping("/list")
	public String list() {
		return "/patient/patientList";
	}
}
