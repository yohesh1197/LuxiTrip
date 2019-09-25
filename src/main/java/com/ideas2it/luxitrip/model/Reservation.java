package com.ideas2it.luxitrip.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Reservation")
public class Reservation {
	
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "midway_id", nullable = false)
    private int midwayId;
	
	@Column(name = "user_id", nullable = false)
    private int userId;
	
	@Column(name = "seat_id", nullable = false)
    private int seatId;
	
	@Column(name = "fare", nullable = false)
    private int fare;
	
	@Column(name = "bus_id", nullable = false)
    private int busId;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMidwayId() {
		return midwayId;
	}
	public void setMidwayId(int midwayId) {
		this.midwayId = midwayId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
}