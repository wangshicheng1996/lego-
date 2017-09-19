package lego.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("/bt")
	public String bingtu(){
		return "/echarts/饼图";
	}
	
	@RequestMapping("/zx")
	public String zhexian(){
		return "/echarts/折线图";
	}

}
