package com.ideas2it.luxitrip.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "schedule")
public class Schedule {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length=11, nullable=false, unique=true)
    private int id;
    
    @Column(name = "departure")
    private Date departureTime;
    
    @Column(name = "arrival")
    private Date arrivalTime;
    
    @ManyToOne
    private Bus bus;
    
    @ManyToOne
    private User driver;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="midway_id")
    private List<Midway> midways;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Bus getBusID() {
        return bus;
    }

    public void setBusID(Bus busID) {
        this.bus = busID;
    }

    public User getDriverId() {
        return driver;
    }

    public void setDriverId(User driver) {
        this.driver = driver;
    }

    public List<Midway> getMidways() {
        return midways;
    }

    public void setMidways(List<Midway> midways) {
        this.midways = midways;
    }

    @Override
    public String toString() {
        return "Schedule [id=" + id + ", departureTime=" + departureTime + 
                ", arrivalTime=" + arrivalTime + ", busID=" + bus + 
                ", driverId=" + driver + ", midways=" + midways + "]";
    }


}
