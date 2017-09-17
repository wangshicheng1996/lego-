package lego.service;

import java.util.List;

import lego.pojo.Order;


public interface OrderService {

	public List<Order> findAll();

	public void deleteOrder(String[] orderIds);

	public void updateState(String[] orderIds, int paystate);

}
