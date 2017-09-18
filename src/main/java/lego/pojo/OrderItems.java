package lego.pojo;


/**
 * 订单商品关联表
 * @author Administrator
 *
 */
public class OrderItems {
	
	private Order order;
	private Product product;//封装商品对象
	
	private Integer count; //购买数量
	private Integer state; //0:未下单1:未发货 2:已发货,配送中 3:已签收
	private String num;//快递公司编号
	private String nu;//快递单号
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getNu() {
		return nu;
	}
	public void setNu(String nu) {
		this.nu = nu;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
}
