package entity;

public class Sms {
	private final String apikey = "c0f29907686a54d4022984f0f951bcc8";
	
	private String mobile;

	public Sms(String mobile) {
		super();
		this.mobile = mobile;
	}

	public Sms() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getApikey() {
		return apikey;
	}

	@Override
	public String toString() {
		return "Sms [apikey=" + apikey + ", mobile=" + mobile + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apikey == null) ? 0 : apikey.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
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
		Sms other = (Sms) obj;
		if (apikey == null) {
			if (other.apikey != null)
				return false;
		} else if (!apikey.equals(other.apikey))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		return true;
	}
	
	
	
}
