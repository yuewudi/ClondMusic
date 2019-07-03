package entity;

import java.util.Date;

public class Collect {
	
	private int id;
	private int userId;
	private int songId;
	private Date collect_time;
	public Collect() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Collect(int id, int userId, int songId, Date collect_time) {
		super();
		this.id = id;
		this.userId = userId;
		this.songId = songId;
		this.collect_time = collect_time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getSongId() {
		return songId;
	}
	public void setSongId(int songId) {
		this.songId = songId;
	}
	public Date getCollect_time() {
		return collect_time;
	}
	public void setCollect_time(Date collect_time) {
		this.collect_time = collect_time;
	}
	@Override
	public String toString() {
		return "Collect [id=" + id + ", userId=" + userId + ", songId=" + songId + ", collect_time=" + collect_time
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((collect_time == null) ? 0 : collect_time.hashCode());
		result = prime * result + id;
		result = prime * result + songId;
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
		Collect other = (Collect) obj;
		if (collect_time == null) {
			if (other.collect_time != null)
				return false;
		} else if (!collect_time.equals(other.collect_time))
			return false;
		if (id != other.id)
			return false;
		if (songId != other.songId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	
	
	

}
