package com.kyumin.erpsystem.item;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/item")
public class itemController {

	@GetMapping("/use")
	public String use() {
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
