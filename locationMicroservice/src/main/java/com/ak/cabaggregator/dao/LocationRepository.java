package com.ak.cabaggregator.dao;

import com.ak.cabaggregator.entity.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends MongoRepository<Location, String> {
    List<Location> findByDriverId(String driverId);

}
