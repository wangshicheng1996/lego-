package lego.mapper;

import java.util.List;

import lego.pojo.OrderItems;

public interface OrderItemsMapper {
	
	//查询全部订单详情
	public List<OrderItems> findAll(String userId);

	public void deleteorderItems(String[] orderIds);
	
	//新增OrderItems
	public void saveOrderItems(OrderItems orderItems);


	

}
