package entity;

public class Play {

	private int id;
	private int userId;
	private int songId;
	public Play() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Play(int id, int userId, int songId) {
		super();
		this.id = id;
		this.userId = userId;
		this.songId = songId;
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
	@Override
	public String toString() {
		return "Play [id=" + id + ", userId=" + userId + ", songId=" + songId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Play other = (Play) obj;
		if (id != other.id)
			return false;
		if (songId != other.songId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	
}
