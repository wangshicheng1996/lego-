package lego.pojo;

public class Rank {
	private Integer rank;
	private String rank_name;
	private Integer parent_rank;
	private Integer rank_id;
	
	private Rank parent;

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public String getRank_name() {
		return rank_name;
	}

	public void setRank_name(String rank_name) {
		this.rank_name = rank_name;
	}

	public Integer getParent_rank() {
		return parent_rank;
	}

	public void setParent_rank(Integer parent_rank) {
		this.parent_rank = parent_rank;
	}

	public Integer getRank_id() {
		return rank_id;
	}

	public void setRank_id(Integer rank_id) {
		this.rank_id = rank_id;
	}

	public Rank getParent() {
		return parent;
	}

	public void setParent(Rank parent) {
		this.parent = parent;
	}
	
}
