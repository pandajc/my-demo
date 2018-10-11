package com.ljc.mydemo.controller;

import java.io.Serializable;

public class Point implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6471302006106212998L;

    /**
     * 定位精度（单位：m）
     */
    protected Double radius;

    /**
     * 定位时间 yyyy-MM-dd HH:mm:ss
     */
    protected String locTime;

    /**
     * 方向（范围为[0,359]，0度为正北方向，顺时针）
     */
    protected Integer direction;

    /**
     * 速度（单位：km/h）
     */
    protected Float speed;

    /**
     * 高度（单位：m）
     */
    protected Integer height;
    
    private Double lon;
    
    private Double lat;
    
    private String coordType;
    
    private String vehicleId;
    
    private Integer type;
    
    //其他5个自定义字段数据
    private String param1Name;
    private String param1Value;
    
    private String param2Name;
    private String param2Value;
    
    private String param3Name;
    private String param3Value;
    
    
    private String param4Name;
    private String param4Value;
    
    private String param5Name;
    private String param5Value;
    
	public Double getRadius() {
		return radius;
	}
	public void setRadius(Double radius) {
		this.radius = radius;
	}
	public String getLocTime() {
		return locTime;
	}
	public void setLocTime(String locTime) {
		this.locTime = locTime;
	}
	public Integer getDirection() {
		return direction;
	}
	public void setDirection(Integer direction) {
		this.direction = direction;
	}
	public Float getSpeed() {
		return speed;
	}
	public void setSpeed(Float speed) {
		this.speed = speed;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public String getParam1Name() {
		return param1Name;
	}
	public void setParam1Name(String param1Name) {
		this.param1Name = param1Name;
	}
	public String getParam1Value() {
		return param1Value;
	}
	public void setParam1Value(String param1Value) {
		this.param1Value = param1Value;
	}
	public String getParam2Name() {
		return param2Name;
	}
	public void setParam2Name(String param2Name) {
		this.param2Name = param2Name;
	}
	public String getParam2Value() {
		return param2Value;
	}
	public void setParam2Value(String param2Value) {
		this.param2Value = param2Value;
	}
	public String getParam3Name() {
		return param3Name;
	}
	public void setParam3Name(String param3Name) {
		this.param3Name = param3Name;
	}
	public String getParam3Value() {
		return param3Value;
	}
	public void setParam3Value(String param3Value) {
		this.param3Value = param3Value;
	}
	public String getParam4Name() {
		return param4Name;
	}
	public void setParam4Name(String param4Name) {
		this.param4Name = param4Name;
	}
	public String getParam4Value() {
		return param4Value;
	}
	public void setParam4Value(String param4Value) {
		this.param4Value = param4Value;
	}
	public String getParam5Name() {
		return param5Name;
	}
	public void setParam5Name(String param5Name) {
		this.param5Name = param5Name;
	}
	public String getParam5Value() {
		return param5Value;
	}
	public void setParam5Value(String param5Value) {
		this.param5Value = param5Value;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public Double getLon() {
		return lon;
	}
	public void setLon(Double lon) {
		this.lon = lon;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public String getCoordType() {
		return coordType;
	}
	public void setCoordType(String coordType) {
		this.coordType = coordType;
	}
	public int getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
    
    
    
}
