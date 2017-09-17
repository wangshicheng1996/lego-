package lego.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lego.mapper.OrderMapper;
import lego.pojo.Order;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;
	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return orderMapper.findAll();
	}
	@Override
	public void deleteOrder(String[] orderIds) {
		orderMapper.deleteOrder(orderIds);
		
	}
	@Override
	public void updateState(String[] orderIds, int paystate) {
		orderMapper.updateState(orderIds,paystate);
		
	}

}
