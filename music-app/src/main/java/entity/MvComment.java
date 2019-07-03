package entity;

import java.util.Date;

public class MvComment {

	private int id;
	private int userId;
	private int mvId;
	private Date comment_time;//评论时间
	private String content;//评论内容
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
	public int getMvId() {
		return mvId;
	}
	public void setMvId(int mvId) {
		this.mvId = mvId;
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
	public String toString() {
		return "MvComment [id=" + id + ", userId=" + userId + ", mvId=" + mvId + ", comment_time=" + comment_time
				+ ", content=" + content + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment_time == null) ? 0 : comment_time.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + id;
		result = prime * result + mvId;
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
		MvComment other = (MvComment) obj;
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
		if (mvId != other.mvId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	

	
}
