package lego.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lego.mapper.ProductMapper;
import lego.pojo.Product;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductMapper productMapper;

	@Override
	public List<Product> findAllProduct() {
		// TODO Auto-generated method stub
		return productMapper.findAllProduct();
	}

	@Override
	public void deleteById(String productId) {
		productMapper.deleteById(productId);
	}
  
	@Override
	public boolean changeCount(String productId, Integer count) {
		//返回修改数据的条数
		int row = productMapper.changeCount(productId,count);
		//条数大于0则修改成功
		return row>0;
	}

	@Override
	public List<Product> findAllProduct25(int m,int n) {
		return productMapper.findAllProduct25(m,n);
	}

}
