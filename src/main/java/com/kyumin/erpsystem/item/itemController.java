package com.kyumin.erpsystem.item;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/item")
public class itemController {
	
	@RequestMapping(value = "/use", method = RequestMethod.GET)
	public String use() {
		return "/item/itemUse";
	}
	
	@RequestMapping(value = "/machineList", method = RequestMethod.GET)
	public String machineList() {
		return "/item/machine";
	}
	
	@RequestMapping(value = "/totalList", method = RequestMethod.GET)
	public String totalList() {
		return "/item/totalInventory";
	}
}
