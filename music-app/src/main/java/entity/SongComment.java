package entity;

import java.util.Date;

public class SongComment {
	private int id;
	private int userId;
	private int songId;
	private Date comment_time;
	private String content;
	
	
	public SongComment() {}
	
	public SongComment(int id, int userId, int songId, Date comment_time, String content) {
		this.id = id;
		this.userId = userId;
		this.songId = songId;
		this.comment_time = comment_time;
		this.content = content;
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

	public Date getComment_time() {
		return comment_time;
	}

	public void setComment_time(Date comment_time) {
		this.comment_time = comment_time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment_time == null) ? 0 : comment_time.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
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
		SongComment other = (SongComment) obj;
		if (comment_time == null) {
			if (other.comment_time != null)
				return false;
		} else if (!comment_time.equals(other.comment_time))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (id != other.id)
			return false;
		if (songId != other.songId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SongComment [id=" + id + ", userId=" + userId + ", songId=" + songId + ", comment_time=" + comment_time
				+ ", content=" + content + "]";
	}

	
	
	
	
}
