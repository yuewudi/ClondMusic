package entity;

import java.util.Date;

public class SearchRecord {
	private int id;
	private int userId;
	private String keyword;
	private Date search_time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	@Override
	public String toString() {
		return "SearchRecord [id=" + id + ", userId=" + userId + ", keyword=" + keyword + ", search_time=" + search_time
				+ "]";
	}
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((keyword == null) ? 0 : keyword.hashCode());
		result = prime * result + ((search_time == null) ? 0 : search_time.hashCode());
		result = prime * result + userId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SearchRecord other = (SearchRecord) obj;
		if (id != other.id)
			return false;
		if (keyword == null) {
			if (other.keyword != null)
				return false;
		} else if (!keyword.equals(other.keyword))
			return false;
		if (search_time == null) {
			if (other.search_time != null)
				return false;
		} else if (!search_time.equals(other.search_time))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Date getSearch_time() {
		return search_time;
	}
	public void setSearch_time(Date search_time) {
		this.search_time = search_time;
	}
}
