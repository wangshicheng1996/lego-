package lego.pojo;

/**
 * 订单商品关联表
 * @author Administrator
 *
 */
public class OrderItems {
	private String orderId;//订单id
	private String productId;//商品id
	
	private Integer count; //购买数量
	private Integer state; //0:未下单1:未发货 2:已发货,配送中 3:已签收
	private String express;
	private String expressId;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
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
	public String getExpress() {
		return express;
	}
	public void setExpress(String express) {
		this.express = express;
	}
	public String getExpressId() {
		return expressId;
	}
	public void setExpressId(String expressId) {
		this.expressId = expressId;
	}
	
}
