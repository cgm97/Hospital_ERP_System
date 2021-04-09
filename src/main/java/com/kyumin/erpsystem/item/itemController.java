package com.kyumin.erpsystem.item;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kyumin.erpsystem.item.domain.itemUse;

@Controller
@RequestMapping("/item")
public class itemController {

	@GetMapping("/use")
	public String use() {
		return "/item/itemUse";
	}
	
	@PostMapping("/use.do")
	public String useAction(itemUse item) {
		System.out.print(item);
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
