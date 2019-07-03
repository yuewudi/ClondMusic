package entity;

public class PlayRecordSong {
private int id;
private String songName;
private String songAuthor;
private int typeId;
private String songTime;
private String songUrl;
private String songImage;
private String songWords;
private String description;
private boolean isVip;
private String song_create_time;
private int count;




//构造方法

public PlayRecordSong() {
}

public PlayRecordSong(int id, String songName, String songAuthor, int typeId, String songTime, String songUrl,
		String songImage, String songWords, String description, boolean isVip, String song_create_time, int count) {
	this.id = id;
	this.songName = songName;
	this.songAuthor = songAuthor;
	this.typeId = typeId;
	this.songTime = songTime;
	this.songUrl = songUrl;
	this.songImage = songImage;
	this.songWords = songWords;
	this.description = description;
	this.isVip = isVip;
	this.song_create_time = song_create_time;
	this.count = count;
}

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

public String getSongAuthor() {
	return songAuthor;
}

public void setSongAuthor(String songAuthor) {
	this.songAuthor = songAuthor;
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

public boolean isVip() {
	return isVip;
}

public void setVip(boolean isVip) {
	this.isVip = isVip;
}

public String getSong_create_time() {
	return song_create_time;
}

public void setSong_create_time(String song_create_time) {
	this.song_create_time = song_create_time;
}

public int getCount() {
	return count;
}

public void setCount(int count) {
	this.count = count;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + count;
	result = prime * result + ((description == null) ? 0 : description.hashCode());
	result = prime * result + id;
	result = prime * result + (isVip ? 1231 : 1237);
	result = prime * result + ((songAuthor == null) ? 0 : songAuthor.hashCode());
	result = prime * result + ((songImage == null) ? 0 : songImage.hashCode());
	result = prime * result + ((songName == null) ? 0 : songName.hashCode());
	result = prime * result + ((songTime == null) ? 0 : songTime.hashCode());
	result = prime * result + ((songUrl == null) ? 0 : songUrl.hashCode());
	result = prime * result + ((songWords == null) ? 0 : songWords.hashCode());
	result = prime * result + ((song_create_time == null) ? 0 : song_create_time.hashCode());
	result = prime * result + typeId;
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
	PlayRecordSong other = (PlayRecordSong) obj;
	if (count != other.count)
		return false;
	if (description == null) {
		if (other.description != null)
			return false;
	} else if (!description.equals(other.description))
		return false;
	if (id != other.id)
		return false;
	if (isVip != other.isVip)
		return false;
	if (songAuthor == null) {
		if (other.songAuthor != null)
			return false;
	} else if (!songAuthor.equals(other.songAuthor))
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
	if (song_create_time == null) {
		if (other.song_create_time != null)
			return false;
	} else if (!song_create_time.equals(other.song_create_time))
		return false;
	if (typeId != other.typeId)
		return false;
	return true;
}

@Override
public String toString() {
	return "PlayRecordSong [id=" + id + ", songName=" + songName + ", songAuthor=" + songAuthor + ", typeId=" + typeId
			+ ", songTime=" + songTime + ", songUrl=" + songUrl + ", songImage=" + songImage + ", songWords="
			+ songWords + ", description=" + description + ", isVip=" + isVip + ", song_create_time=" + song_create_time
			+ ", count=" + count + "]";
}





}