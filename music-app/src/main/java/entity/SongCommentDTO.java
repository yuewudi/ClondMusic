package entity;

import org.springframework.stereotype.Component;


public class SongCommentDTO {
	private SongComment songComment;
	private User user;
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((songComment == null) ? 0 : songComment.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		SongCommentDTO other = (SongCommentDTO) obj;
		if (songComment == null) {
			if (other.songComment != null)
				return false;
		} else if (!songComment.equals(other.songComment))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}




	public SongComment getSongComment() {
		return songComment;
	}




	public void setSongComment(SongComment songComment) {
		this.songComment = songComment;
	}




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	public SongCommentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}




	public SongCommentDTO(SongComment songComment, User user) {
		super();
		this.songComment = songComment;
		this.user = user;
	}




	@Override
	public String toString() {
		return "SongCommentDTO [songComment=" + songComment + ", user=" + user + "]";
	}
	
	

	

}
