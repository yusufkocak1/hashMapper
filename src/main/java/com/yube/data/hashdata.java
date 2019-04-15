package com.yube.data;

import javax.persistence.*;

@Entity
@Table(name ="hashdata")
public class hashdata {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String text = "";
	@Column
	private String SHA256 = "";
	@Column
	private String SHA1 = "";
	@Column
	private String MD5 = "";

	public hashdata(Builder builder) {
		this.text = builder.text;
		SHA256 = builder.SHA256;
		SHA1 = builder.SHA1;
		MD5 = builder.MD5;
	}

	public hashdata() {}

	public String getText() {
		return text;
	}

	public String getSHA256() {
		return SHA256;
	}

	public String getSHA1() {
		return SHA1;
	}

	public String getMD5() {
		return MD5;
	}


	public static class Builder {
		private String text = "";
		private String SHA256 = "";
		private String SHA1 = "";
		private String MD5 = "";

		public Builder(String text, String sHA256, String mD5) {
			this.text = text;
			SHA256 = sHA256;
			MD5 = mD5;
		}

		public hashdata build(){
			return new hashdata(this);
		}

		public String getText() {
			return text;
		}

		public String getSHA256() {
			return SHA256;
		}

		public String getSHA1() {
			return SHA1;
		}

		public String getMD5() {
			return MD5;
		}

		public void setText(String text) {
			this.text = text;
		}

		public void setSHA256(String sHA256) {
			SHA256 = sHA256;
		}

		public void setSHA1(String sHA1) {
			SHA1 = sHA1;
		}

		public void setMD5(String mD5) {
			MD5 = mD5;
		}

	}

}
