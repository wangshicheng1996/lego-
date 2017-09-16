package lego.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lego.mapper.CategoryMapper;
import lego.pojo.Category;


@Service
public class CategoryServiceImpl implements  CategoryService{
	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public List<Category> findAllCategory() {
		// TODO Auto-generated method stub
		return categoryMapper.findAllCategory();
	}
	
        
}
