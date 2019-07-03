package entity;

import java.util.Date;

public class PlayRecord {

	private int id;
	private int userId;
	private int songId;
	private Date play_time;
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
	public Date getPlay_time() {
		return play_time;
	}
	public void setPlay_time(Date play_time) {
		this.play_time = play_time;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((play_time == null) ? 0 : play_time.hashCode());
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
		PlayRecord other = (PlayRecord) obj;
		if (id != other.id)
			return false;
		if (play_time == null) {
			if (other.play_time != null)
				return false;
		} else if (!play_time.equals(other.play_time))
			return false;
		if (songId != other.songId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PalyRecord [id=" + id + ", userId=" + userId + ", songId=" + songId + ", play_time=" + play_time + "]";
	}

	
}
