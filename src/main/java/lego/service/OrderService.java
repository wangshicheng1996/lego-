package lego.service;

import java.util.List;

import lego.pojo.Order;


public interface OrderService {

	public List<Order> findAll(String userId);

	public void deleteOrder(String[] orderIds);

	public void updateState(String[] orderIds, int paystate);
//保存新增订单
	//public void saveOrder(Order order);

}
