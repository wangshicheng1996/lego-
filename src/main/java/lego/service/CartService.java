package lego.service;

import java.util.List;

import lego.pojo.CarAndCollection;

public interface CartService {

	public List<CarAndCollection> findAllCart(String userId);

	public List<CarAndCollection> findAllCollection(String userId);

	public void deleteCollection(String productId,String userId);

	public void addCart(String productId, String userId);

	public void deleteShop(String productId, String userId);

	public void addCollection(String productId, String userId);

	public void updateNum(String productId, String userId, Integer pnum);

}
