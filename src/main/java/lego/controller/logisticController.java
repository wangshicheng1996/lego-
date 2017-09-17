package lego.controller;

import org.springframework.web.bind.annotation.RequestMapping;


public class logisticController {
	
	@RequestMapping("/logistic")
	public String toLogistic(){
		
		
		return "/person/logistic";
	}
}
