package lego.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import lego.pojo.Product;

public interface ProductMapper {

	public List<Product> findAllProduct();

	//根据商品id删除商品
	@Delete("delete from product where product_id = #{productId}")
	public void deleteById(String productId);

	//修改商品数量
	@Update("update product set count =#{count} where product_id = #{productId}")
	public int changeCount(@Param("productId")String productId,@Param("count") Integer count);

	//显示25条商品
	@Select("SELECT * FROM product  LIMIT  #{m},#{n}")
	public List<Product> findAllProduct25(@Param("m")int m,@Param("n")int n);

}
