package lego.mapper;

import java.util.List;

import lego.pojo.Sales;

public interface SalesMapper {

	public List<Sales> findAllSales();

	//查询商品所有名字
	public List<String> findAllSalesName();

	//查询所有商品销量
	public List<Integer> findAllSalesCount();

}
