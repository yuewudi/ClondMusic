package entity;

import java.util.Date;

public class PlayRecordSong {
private int id;
private String songName;
private int userId;
private int typeId;
private String songTime;
private String songUrl;
private String songImage;
private String songWords;
private String description;
private int isVip;
private String play_time;
private String song_create_time;


//构造方法
public PlayRecordSong() {
	super();
}





public String getSong_create_time() {
	return song_create_time;
}





public void setSong_create_time(String song_create_time) {
	this.song_create_time = song_create_time;
}





public PlayRecordSong(int id, String songName, int userId, int typeId, String songTime, String songUrl,
		String songImage, String songWords, String description, int isVip, String play_time, String song_create_time) {
	super();
	this.id = id;
	this.songName = songName;
	this.userId = userId;
	this.typeId = typeId;
	this.songTime = songTime;
	this.songUrl = songUrl;
	this.songImage = songImage;
	this.songWords = songWords;
	this.description = description;
	this.isVip = isVip;
	this.play_time = play_time;
	this.song_create_time = song_create_time;
}





//getset方法
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getSongName() {
	return songName;
}
public void setSongName(String songName) {
	this.songName = songName;
}
public String getPlay_time() {
	return play_time;
}

public void setPlay_time(String play_time) {
	this.play_time = play_time;
}



public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public int getTypeId() {
	return typeId;
}
public void setTypeId(int typeId) {
	this.typeId = typeId;
}
public String getSongTime() {
	return songTime;
}
public void setSongTime(String songTime) {
	this.songTime = songTime;
}
public String getSongUrl() {
	return songUrl;
}
public void setSongUrl(String songUrl) {
	this.songUrl = songUrl;
}
public String getSongImage() {
	return songImage;
}
public void setSongImage(String songImage) {
	this.songImage = songImage;
}
public String getSongWords() {
	return songWords;
}
public void setSongWords(String songWords) {
	this.songWords = songWords;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getIsVip() {
	return isVip;
}
public void setIsVip(int isVip) {
	this.isVip = isVip;
}


//toString方法


//hashCode方法




@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((description == null) ? 0 : description.hashCode());
	result = prime * result + id;
	result = prime * result + isVip;
	result = prime * result + ((play_time == null) ? 0 : play_time.hashCode());
	result = prime * result + ((songImage == null) ? 0 : songImage.hashCode());
	result = prime * result + ((songName == null) ? 0 : songName.hashCode());
	result = prime * result + ((songTime == null) ? 0 : songTime.hashCode());
	result = prime * result + ((songUrl == null) ? 0 : songUrl.hashCode());
	result = prime * result + ((songWords == null) ? 0 : songWords.hashCode());
	result = prime * result + typeId;
	result = prime * result + userId;
	return result;
}



@Override
public String toString() {
	return "PlayRecordSong [id=" + id + ", songName=" + songName + ", userId=" + userId + ", typeId=" + typeId
			+ ", songTime=" + songTime + ", songUrl=" + songUrl + ", songImage=" + songImage + ", songWords="
			+ songWords + ", description=" + description + ", isVip=" + isVip + ", play_time=" + play_time
			+ ", song_create_time=" + song_create_time + "]";
}





@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	PlayRecordSong other = (PlayRecordSong) obj;
	if (description == null) {
		if (other.description != null)
			return false;
	} else if (!description.equals(other.description))
		return false;
	if (id != other.id)
		return false;
	if (isVip != other.isVip)
		return false;
	if (play_time == null) {
		if (other.play_time != null)
			return false;
	} else if (!play_time.equals(other.play_time))
		return false;
	if (songImage == null) {
		if (other.songImage != null)
			return false;
	} else if (!songImage.equals(other.songImage))
		return false;
	if (songName == null) {
		if (other.songName != null)
			return false;
	} else if (!songName.equals(other.songName))
		return false;
	if (songTime == null) {
		if (other.songTime != null)
			return false;
	} else if (!songTime.equals(other.songTime))
		return false;
	if (songUrl == null) {
		if (other.songUrl != null)
			return false;
	} else if (!songUrl.equals(other.songUrl))
		return false;
	if (songWords == null) {
		if (other.songWords != null)
			return false;
	} else if (!songWords.equals(other.songWords))
		return false;
	if (typeId != other.typeId)
		return false;
	if (userId != other.userId)
		return false;
	return true;
}



}
