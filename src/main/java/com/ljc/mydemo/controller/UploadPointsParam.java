package com.ljc.mydemo.controller;

import java.io.Serializable;
import java.util.List;


public class UploadPointsParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -96478650715405910L;
	
	private String token;
	private String vehicleId;
	private List<Point>points;
	/*private List<PushPoint> pushPointList;*/
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public List<Point> getPoints() {
		return points;
	}
	public void setPoints(List<Point> points) {
		this.points = points;
	}
	/*public List<PushPoint> getPushPointList() {
		return pushPointList;
	}
	public void setPushPointList(List<PushPoint> pushPointList) {
		this.pushPointList = pushPointList;
	}*/
	
}
