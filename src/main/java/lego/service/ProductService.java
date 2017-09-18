package lego.service;

import java.util.List;

import lego.pojo.Product;

public interface ProductService {

	public List<Product> findAllProduct();

	//根据id删除商品
	public void deleteById(String productId);

	//根据商品ID修改商品数量
	public boolean changeCount(String productId, Integer count);
	
	//显示25  
	public List<Product> findAllProduct25(int m,int n);


}
