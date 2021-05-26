package com.kyumin.erpsystem.humanresource;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.kyumin.erpsystem.humanresource.domain.Salary;
import com.kyumin.erpsystem.humanresource.domain.Schedule;
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
	
	@GetMapping("/schedule") // 직원 근태 관리 
	public String schedule(@RequestParam(value = "name", required = false) String name, Model model) throws SQLException {
		if (name == null) {
			return "/hr/schedule";
		}
		model.addAttribute("scheduleList", hrSerivce.getScheduleListbyName(name));
		
		return "/hr/schedule";
	}
	
	@GetMapping("/checkWorking") // 근무 기록 하기위해 달력을 클릭한 경우
	public String checkWorking(@RequestParam String today, Model model) {
		model.addAttribute("today",today);
		
		return "/hr/addWork";	
	}
	
	@PostMapping("/workRec") // 클릭된 날자 근무 기록 저장
	@ResponseBody
	public Map<String, Object> workRec(@RequestBody Schedule schedule) throws ParseException, SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("result",hrSerivce.workRec(schedule));

		return map;		
	}
	
	@GetMapping("/readScehdule") // 기록된 근무지를 클릭한 경우
	public String checkWorking(@RequestParam int scheduleNo, Model model) throws SQLException {
		model.addAttribute("scheduleInfo",hrSerivce.getSchedulebyNo(scheduleNo));
		
		return "/hr/readWork";	
	}
	
	@GetMapping("/salary")
	public String salary() {
		return "/hr/salary";
	}
	
	@ResponseBody
	@GetMapping("/searchSalary") // 급여 관리 확인
	public List<Salary> searchSalary(@RequestParam String name) throws SQLException {
		List<Salary> salaryList = new ArrayList<Salary>();
		salaryList = hrSerivce.findMemberSalaryList(name);

		return salaryList;
	}
	
}
