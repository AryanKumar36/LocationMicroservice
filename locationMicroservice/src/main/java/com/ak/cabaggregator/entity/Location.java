package com.ak.cabaggregator.entity;


import com.mongodb.lang.Nullable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Date;



@Document(collection = "locations")
public class Location {

    @Id
    private String id;

    private String driverId;

    private GeoJsonPoint location;
    private double accuracy;

    private Date timestamp;

    public Location()
    {

    }

    public Location(String driverId, GeoJsonPoint location, double accuracy, Date timestamp) {
        this.driverId = driverId;
        this.location = location;
        this.accuracy = accuracy;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public GeoJsonPoint getLocation() {
        return location;
    }

    public void setLocation(GeoJsonPoint location) {
        this.location = location;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    @Nullable
    public Date getTimestamp() {
        return (timestamp != null) ? timestamp: Date.from(Instant.now());
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id='" + id + '\'' +
                ", driverId='" + driverId + '\'' +
                ", location=" + location +
                ", accuracy=" + accuracy +
                ", timestamp=" + timestamp +
                '}';
    }
}
