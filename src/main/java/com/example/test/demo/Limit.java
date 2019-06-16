package com.example.test.demo;

public class Limit { 

	private long SEC;
	private long MIN;
	private long HOUR;
	private long WEEK;
	private long MONTH;
	
	public Limit(long sEC, long mIN, long hOUR, long wEEK, long mONTH) {
		SEC = sEC;
		MIN = mIN;
		HOUR = hOUR;
		WEEK = wEEK;
		MONTH = mONTH;
	}
	
	public long getSEC() {
		return SEC;
	}
	public void setSEC(long sEC) {
		SEC = sEC;
	}
	public long getMIN() {
		return MIN;
	}
	public void setMIN(long mIN) {
		MIN = mIN;
	}
	public long getHOUR() {
		return HOUR;
	}
	public void setHOUR(long hOUR) {
		HOUR = hOUR;
	}
	public long getWEEK() {
		return WEEK;
	}
	public void setWEEK(long wEEK) {
		WEEK = wEEK;
	}
	public long getMONTH() {
		return MONTH;
	}
	public void setMONTH(long mONTH) {
		MONTH = mONTH;
	}
	
	

	
}

