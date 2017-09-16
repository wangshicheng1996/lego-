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

}
