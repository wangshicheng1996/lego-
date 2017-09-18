package lego.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import lego.pojo.CarAndCollection;

public interface CartMapper {
	
	public List<CarAndCollection> findAllCart(String userId);

	public List<CarAndCollection> findAllCollection(String userId);

	public void deleteCollection(@Param("productId")String productId,@Param("userId")String userId);

	public void addCart(@Param("productId")String productId,@Param("userId")String userId);

	public void deleteShop(@Param("productId")String productId,@Param("userId")String userId);

	public void addCollection(@Param("productId")String productId,@Param("userId")String userId);

	public void updateNum(@Param("productId")String productId, @Param("userId")String userId, @Param("pnum")Integer pnum);

}
