package com.kyumin.erpsystem.item;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kyumin.erpsystem.item.domain.itemUse;
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
	public Map<String,Object> itemSearch(@RequestBody String drugName) {
		Map<String, Object> map = new HashMap<String, Object>();
		itemUse drugInfo = itemService.findByDrugName(drugName);
		
		if (drugInfo.getDrugType() != null) {
			map.put("drugCode", drugInfo.getDrugCode());
			map.put("drugType", drugInfo.getDrugType());
			System.out.println("test");
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
	public String useAction(itemUse item) {
		itemService.usedItem(item);
		// DB 처리 부분만 남음 사용 처리
		return "/item/itemUse";
	}
	
	@GetMapping("/machineList")
	public String machineList() {
		return "/item/machine";
	}

	@GetMapping("/totalList")
	public String totalList() {
		return "/item/totalInventory";
	}
}
