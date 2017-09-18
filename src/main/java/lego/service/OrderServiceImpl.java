package lego.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lego.mapper.OrderItemsMapper;
import lego.mapper.OrderMapper;
import lego.pojo.Order;
import lego.pojo.OrderItems;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private OrderItemsMapper orderItemsMapper;
	//查看所有订单信息
	@Override
	public List<Order> findAll(String userId) {
		// TODO Auto-generated method stub
		return orderMapper.findAll(userId);
	}
	//删除订单
	@Override
	public void deleteOrder(String[] orderIds) {
		orderItemsMapper.deleteorderItems(orderIds);
		orderMapper.deleteOrder(orderIds);
		
	}
	//更改支付状态
	@Override
	public void updateState(String[] orderIds, int paystate) {
		orderMapper.updateState(orderIds,paystate);
		
	}
	//新增订单
	/*@Override
	public void saveOrder(Order order) {
		OrderItems orderItems =order.getOrderItems();
		//补齐属性值
		String id = UUID.randomUUID().toString();
		order.setOrderId(id);
		orderItems.setOrderId(id);
		
		orderMapper.saveOrder(order);
		orderItemsMapper.saveOrderItems(orderItems);
		
	}*/
	

}
