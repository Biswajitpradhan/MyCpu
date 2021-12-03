package com.cpu_makes.folder.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cpu_makes.folder.Entity.CustomizeCpuDetails;


@Repository
public interface CustomizeCpuDetailsRepo extends MongoRepository<CustomizeCpuDetails, Integer>{

}
