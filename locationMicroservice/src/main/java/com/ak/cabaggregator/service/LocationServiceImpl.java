package com.ak.cabaggregator.service;

import com.ak.cabaggregator.dao.LocationRepository;
import com.ak.cabaggregator.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    private final MongoTemplate mongoTemplate;


    @Autowired
    public LocationServiceImpl(LocationRepository theLocationRepository, MongoTemplate mongoTemplate) {
        this.locationRepository = theLocationRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public List<Location> getAllDrivers() {
        return locationRepository.findAll();
    }

    @Override
    public void deleteByDriverId(String driverId) {
        if(locationRepository.findByDriverId(driverId).isEmpty())
        {
            throw new RuntimeException("Driver Not Exist by this Id");
        }
        locationRepository.deleteById(driverId);
    }

    @Override
    public List<Location> getLocationByDriverId(String driverId) {
        return locationRepository.findByDriverId(driverId);
    }

    @Override
    public GeoResults<Location> getDriverInCircle(double lat, double lang, double radius, int limit) {
        NearQuery nearQuery = NearQuery.near(lat, lang).maxDistance(new Distance(radius, Metrics.KILOMETERS)).limit(limit);
        return mongoTemplate.geoNear(nearQuery, Location.class);
    }


}


