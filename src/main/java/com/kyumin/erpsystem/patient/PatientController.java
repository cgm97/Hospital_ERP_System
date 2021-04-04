package com.kyumin.erpsystem.patient;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/patient")
public class PatientController {
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "/patient/patientAdd";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() {
		return "/patient/patientList";
	}
}
