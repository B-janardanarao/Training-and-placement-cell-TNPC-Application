package com.tnpc.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tnpc.PlacementDriveRepository.PlacementDriveRepository;
import com.tnpc.entity.PlacementDrive;

@Service
public class PlacementDriveService {
    @Autowired
    private PlacementDriveRepository repository;

    public List<PlacementDrive> getAllDrives() {
        return repository.findAll();
    }

    public PlacementDrive saveDrive(PlacementDrive drive) {
        return repository.save(drive);
    }

    public PlacementDrive getDriveById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteDrive(Long id) {
        repository.deleteById(id);
    }
}
