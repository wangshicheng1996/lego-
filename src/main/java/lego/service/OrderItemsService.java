package lego.service;


import java.util.List;


import lego.pojo.OrderItems;


public interface OrderItemsService {

	//查询订单商品详情
	List<OrderItems> findAll(String userId);
	

}
