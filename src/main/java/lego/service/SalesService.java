package lego.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import lego.pojo.Sales;

public interface SalesService {
	//下载销售榜单
	public StringBuilder SalesDownLoad() throws Exception;
	
	//查询销售榜单
	public List<Sales> findAllSales();
}
