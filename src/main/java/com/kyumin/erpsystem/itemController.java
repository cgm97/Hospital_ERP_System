package com.kyumin.erpsystem;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/item")
public class itemController {
	
	@RequestMapping(value = "/use", method = RequestMethod.GET)
	public String use() {
		return "/item/itemAdd";
	}
	
	@RequestMapping(value = "/machine", method = RequestMethod.GET)
	public String machine() {
		return "/item/machine";
	}
	
	@RequestMapping(value = "/totalInventory", method = RequestMethod.GET)
	public String totalInventory() {
		return "/item/totalInventory";
	}
}
