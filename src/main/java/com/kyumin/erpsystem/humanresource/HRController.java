package com.kyumin.erpsystem.humanresource;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kyumin.erpsystem.humanresource.service.HRService;
import com.kyumin.erpsystem.utility.Criteria;

@Controller
@RequestMapping("/humanResource")
public class HRController {
	
	@Autowired
	private HRService hrSerivce;
	@GetMapping("/list")
	public String list(Model model, Criteria cri) throws SQLException {
		// 총 직원 수 
		
		// 직원 리스트 가져오기
		model.addAttribute("memberList", hrSerivce.findAllMemberList());
		//페이징 처리

		return "/hr/employeeList";
	}
	
	@GetMapping("/memberInfo")
	public String memberInfo(@RequestParam("memberNo") int memberNo, Model model) throws SQLException {
		System.out.println(memberNo);
		model.addAttribute("memberInfo",hrSerivce.findMemberInfoByNo(memberNo));
		return "/hr/memberInfo";
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
