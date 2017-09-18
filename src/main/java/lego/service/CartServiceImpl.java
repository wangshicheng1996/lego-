package lego.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lego.mapper.CartMapper;
import lego.pojo.CarAndCollection;
@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartMapper cartMapper;
	public List<CarAndCollection> findAllCart(String userId) {
		List<CarAndCollection> list = cartMapper.findAllCart(userId);
		return cartMapper.findAllCart(userId);
	}
	
	public List<CarAndCollection> findAllCollection(String userId) {
		List<CarAndCollection> list = cartMapper.findAllCollection(userId);
		return cartMapper.findAllCollection(userId);
	}

	@Override
	public void deleteCollection(String productId,String userId) {
		cartMapper.deleteCollection(productId,userId);
		
	}

	@Override
	public void addCart(String productId, String userId) {
		//在之前需要判断购物车中是否有该物品,如果有则提示,没有则添加!
		cartMapper.addCart(productId,userId);
		
	}

	@Override
	public void deleteShop(String productId, String userId) {
		cartMapper.deleteShop(productId,userId);
		
	}

	@Override
	public void addCollection(String productId, String userId) {
		//在之前需要判断收藏夹中是否有该物品,如果有则提示,没有进行添加!
		cartMapper.addCollection(productId,userId);
	}

	@Override
	public void updateNum(String productId, String userId, Integer pnum) {
		cartMapper.updateNum(productId,userId,pnum);
		
	}

}
