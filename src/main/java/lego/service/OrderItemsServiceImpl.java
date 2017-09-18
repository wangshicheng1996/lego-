package lego.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lego.mapper.OrderItemsMapper;
import lego.pojo.OrderItems;

@Service
public class OrderItemsServiceImpl implements OrderItemsService {
	
	@Autowired
	private OrderItemsMapper orderItemsMapper;

	//查询订单商品详情
	@Override
	public List<OrderItems> findAll(String userId) {
		return orderItemsMapper.findAll(userId);
	}

}
