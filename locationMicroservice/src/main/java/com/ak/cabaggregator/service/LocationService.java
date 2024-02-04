package com.ak.cabaggregator.service;

import com.ak.cabaggregator.entity.Location;
import org.springframework.data.geo.GeoResults;

import java.util.List;

public interface LocationService {

    Location saveLocation(Location location);

    List<Location> getAllDrivers();

    void deleteByDriverId(String driverId);

    List<Location> getLocationByDriverId(String driverId);

    GeoResults<Location> getDriverInCircle(double lat, double lang, double radius, int limit);

}
