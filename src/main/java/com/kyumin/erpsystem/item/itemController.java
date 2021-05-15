package com.kyumin.erpsystem.item;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kyumin.erpsystem.item.domain.itemUse;
import com.kyumin.erpsystem.item.domain.machineDTO;
import com.kyumin.erpsystem.item.service.itemService;

@Controller
@RequestMapping("/item")
public class itemController {
	
	@Autowired
	private itemService itemService;
	
	@GetMapping("/use")
	public String use() {
		return "/item/itemUse";
	}

	/*
	 * 약품 검색 비동기 처리
	 */
	@ResponseBody
	@PostMapping("/itemSearch")
	public Map<String,Object> itemSearch(@RequestBody String drugName) throws SQLException {
		Map<String, Object> map = new HashMap<String, Object>();
		itemUse drugInfo = itemService.findByDrugName(drugName);
		
		if (drugInfo != null) {
			map.put("code", drugInfo.getCode());
			map.put("type", drugInfo.getType());
		}
		else {
			map = null;
		}
		
		return map;
	}
	
	/*
	 * 약품 사용 처리
	 */
	@PostMapping("/use.do")
	public String useAction(itemUse item) throws SQLException {
		itemService.usedItem(item);

		return "/item/itemUse";
	}

	/* 
	 * 기계 목록
	 */
	@GetMapping("/machineList")
	public String machineList(Model model) throws SQLException {
		model.addAttribute("machineList", itemService.findAllMachineList());
		// DB 처리 부분만 남음
		return "/item/machine";
	}
	
	/* 
	 * 악품 목록
	 */
	@GetMapping("/totalList")
	public String totalList(Model model) throws SQLException {
		model.addAttribute("inventoryList",itemService.findAllInventoryList());

		return "/item/totalInventory";
	}
}
