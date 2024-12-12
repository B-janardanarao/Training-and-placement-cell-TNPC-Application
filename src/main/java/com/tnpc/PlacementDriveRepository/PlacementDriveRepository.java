package com.tnpc.PlacementDriveRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tnpc.entity.PlacementDrive;

@Repository
public interface PlacementDriveRepository extends JpaRepository<PlacementDrive, Long> {
}
