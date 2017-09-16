package lego.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lego.pojo.Sales;
import lego.service.SalesService;
@Controller
public class SalesController {
	@Autowired
	private SalesService salesService;
	
	//查询销售榜单
	@RequestMapping("findAllSales")
	public String findAllSales(Model model){
		List<Sales> salesList = salesService.findAllSales();
		model.addAttribute("salesList", salesList);
		return "";
	}
	
	//下载销售榜单
	@RequestMapping("/SalesDownLoad")
	@ResponseBody
	public void SalesDownLoad(HttpServletResponse response) throws Exception{
		StringBuilder str = salesService.SalesDownLoad();
		String fname = "XSBD.xls";
		response.setHeader("Content-Disposition", "attachment;filename="+fname);
		response.setContentType("text/html;charset=GBK");
		response.getWriter().write(str.toString());
	}
	
	
		
}
