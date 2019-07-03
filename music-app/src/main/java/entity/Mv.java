package entity;

import java.util.Date;

public class Mv {

	private int id;
	private String mvName;
	private int userId;
	private Date mv_time;
	private String mvUrl;
	private String description;
	private boolean status;
	
	public Mv() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Mv(int id, String mvName, int userId, Date mv_time, String mvUrl, String description, boolean status) {
		super();
		this.id = id;
		this.mvName = mvName;
		this.userId = userId;
		this.mv_time = mv_time;
		this.mvUrl = mvUrl;
		this.description = description;
		this.status = status;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMvName() {
		return mvName;
	}
	public void setMvName(String mvName) {
		this.mvName = mvName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getMv_time() {
		return mv_time;
	}
	public void setMv_time(Date mv_time) {
		this.mv_time = mv_time;
	}
	public String getMvUrl() {
		return mvUrl;
	}
	public void setMvUrl(String mvUrl) {
		this.mvUrl = mvUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	
	@Override
	public String toString() {
		return "Mv [id=" + id + ", mvName=" + mvName + ", userId=" + userId + ", mv_time=" + mv_time + ", mvUrl="
				+ mvUrl + ", description=" + description + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((mvName == null) ? 0 : mvName.hashCode());
		result = prime * result + ((mvUrl == null) ? 0 : mvUrl.hashCode());
		result = prime * result + ((mv_time == null) ? 0 : mv_time.hashCode());
		result = prime * result + (status ? 1231 : 1237);
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
		Mv other = (Mv) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (mvName == null) {
			if (other.mvName != null)
				return false;
		} else if (!mvName.equals(other.mvName))
			return false;
		if (mvUrl == null) {
			if (other.mvUrl != null)
				return false;
		} else if (!mvUrl.equals(other.mvUrl))
			return false;
		if (mv_time == null) {
			if (other.mv_time != null)
				return false;
		} else if (!mv_time.equals(other.mv_time))
			return false;
		if (status != other.status)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	
}
