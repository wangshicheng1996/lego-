package lego.pojo;

/**
 * 用户地址信息表
 * 
 * @author Administrator
 *
 */
public class Address {
	private Integer addressId;// 用户id
	private String addressInfo;// 地址信息
	private String province;// 省份

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getAddressInfo() {
		return addressInfo;
	}

	public void setAddressInfo(String addressInfo) {
		this.addressInfo = addressInfo;
	}

}
