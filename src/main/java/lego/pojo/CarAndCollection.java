package lego.pojo;


/**
 * 购物车和收藏夹表单
 * @author Administrator
 *
 */
public class CarAndCollection {
	private User user;//用户对象
	private Product product;//商品对象
	
	private Integer number; //作为购物车表时显示购买数量;而作为收藏夹表时不显示数量
	private Integer type;   //1:购物车表,2:收藏夹表
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
		
}
