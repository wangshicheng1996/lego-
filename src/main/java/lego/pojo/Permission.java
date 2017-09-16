package lego.pojo;
/**
 * 用户权限:1-超级管理员
 *        2-管理员
 *        3-普通用户
 * @author Administrator
 *
 */
public class Permission {
	private String permissionId;//权限id
	private String permissionName;//权限名称
	private String remark;//说明
	public String getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
		
}
