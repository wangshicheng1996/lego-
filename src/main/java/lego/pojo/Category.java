package lego.pojo;
/**
 * 商品分类等级表
 * @author Administrator
 *
 */
public class Category {
	private Integer categoryId;//商品类别id
	private String categoryName;//类名名称
	private Integer level;//分类登记
	private Category parentLevel;//上级
	
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Category getParentLevel() {
		return parentLevel;
	}
	public void setParentLevel(Category parentLevel) {
		this.parentLevel = parentLevel;
	}
	
}
