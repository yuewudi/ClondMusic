package entity;

import java.util.Date;

public class Vip {
	private int id;
	private int userId;
	private boolean status;
	private Date start_time;
	private Date end_time;
	
	public Vip() {}
	
	public Vip(int id, int userId, boolean status, Date start_time, Date end_time) {
		this.id = id;
		this.userId = userId;
		this.status = status;
		this.start_time = start_time;
		this.end_time = end_time;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((end_time == null) ? 0 : end_time.hashCode());
		result = prime * result + id;
		result = prime * result + ((start_time == null) ? 0 : start_time.hashCode());
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
		Vip other = (Vip) obj;
		if (end_time == null) {
			if (other.end_time != null)
				return false;
		} else if (!end_time.equals(other.end_time))
			return false;
		if (id != other.id)
			return false;
		if (start_time == null) {
			if (other.start_time != null)
				return false;
		} else if (!start_time.equals(other.start_time))
			return false;
		if (status != other.status)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vip [id=" + id + ", userId=" + userId + ", status=" + status + ", start_time=" + start_time + ", end_time="
				+ end_time + "]";
	}
	
	
	
}
