package com.annguyen.kyanhbooks.model;

import java.io.Serializable;

import javax.persistence.Column;

public class ChiTietGioHangPrimaryKey implements Serializable {
	
	@Column(name = "MaSach", nullable = false)
	private String maSach;
	
	@Column(name = "SessionIdGH", nullable = false)
	private String sessionIdGH;

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getSessionIdGH() {
		return sessionIdGH;
	}

	public void setSessionIdGH(String sessionIdGH) {
		this.sessionIdGH = sessionIdGH;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maSach == null) ? 0 : maSach.hashCode());
		result = prime * result + ((sessionIdGH == null) ? 0 : sessionIdGH.hashCode());
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
		ChiTietGioHangPrimaryKey other = (ChiTietGioHangPrimaryKey) obj;
		if (maSach == null) {
			if (other.maSach != null)
				return false;
		} else if (!maSach.equals(other.maSach))
			return false;
		if (sessionIdGH == null) {
			if (other.sessionIdGH != null)
				return false;
		} else if (!sessionIdGH.equals(other.sessionIdGH))
			return false;
		return true;
	}
	
}
