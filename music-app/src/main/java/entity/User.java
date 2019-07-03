package entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


/**
 * User实体类
 * @author root
 *
 */
public class User {
	//User的属性
	private int id;
	private String account;
	private String password;
	private String nickName;
	private boolean sex;
	private boolean status;
	private String description;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date create_date;
	
	private String header;
	private int grade;
	private long phone;
	
	//有参构造器
	public User(int id, String account, String password, String nickName, boolean sex, boolean status,
			String description, Date create_date, String header, int grade, long phone) {
		super();
		this.id = id;
		this.account = account;
		this.password = password;
		this.nickName = nickName;
		this.sex = sex;
		this.status = status;
		this.description = description;
		this.create_date = create_date;
		this.header = header;
		this.grade = grade;
		this.phone = phone;
	}
	//无参构造器
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	//set get
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getcreate_date() {
		return create_date;
	}
	public void setcreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	//重写toString
	
	@Override
	public String toString() {
		return "User [id=" + id + ", account=" + account + ", password=" + password + ", nickName=" + nickName
				+ ", sex=" + sex + ", status=" + status + ", description=" + description + ", create_date=" + create_date
				+ ", header=" + header + ", grade=" + grade + ", phone=" + phone + "]";
	}
	//重写eq和hash
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((create_date == null) ? 0 : create_date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + grade;
		result = prime * result + ((header == null) ? 0 : header.hashCode());
		result = prime * result + id;
		result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + (int) (phone ^ (phone >>> 32));
		result = prime * result + (sex ? 1231 : 1237);
		result = prime * result + (status ? 1231 : 1237);
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
		User other = (User) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (create_date == null) {
			if (other.create_date != null)
				return false;
		} else if (!create_date.equals(other.create_date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (grade != other.grade)
			return false;
		if (header == null) {
			if (other.header != null)
				return false;
		} else if (!header.equals(other.header))
			return false;
		if (id != other.id)
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone != other.phone)
			return false;
		if (sex != other.sex)
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	
	
	

}
