package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BikeRepository extends JpaRepository<Bike, Integer> {
}
