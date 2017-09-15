package lego.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/{pathname}/left")
	public String tosysadminLeft(@PathVariable String pathname){
		return "/"+pathname+"/left";
	}
	@RequestMapping("/{aa}/main")
	public String tosysadminMain(@PathVariable String pathname){
		return "/"+pathname+"/main";
	}
}
