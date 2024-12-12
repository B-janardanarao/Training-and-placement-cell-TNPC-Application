package com.tnpc.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tnpc.Service.PlacementDriveService;
import com.tnpc.entity.PlacementDrive;



@Controller
public class PlacementDriveController {

    @Autowired
    private PlacementDriveService service;
    
    
    @GetMapping("/")
    public String viewDrivesPage(Model model) {
        model.addAttribute("drives", service.getAllDrives());
        return "drives";
    }

    @GetMapping("/new")
    public String showNewDriveForm(Model model) {
        PlacementDrive drive = new PlacementDrive();
        model.addAttribute("drive", drive);
        return "new_drive";
    }

    @PostMapping("/save")
    public String saveDrive(@ModelAttribute("drive") PlacementDrive drive) {
        service.saveDrive(drive);
        return "redirect:/drives";
    }

    @GetMapping("/edit/{id}")
    public String showEditDriveForm(@PathVariable Long id, Model model) {
        PlacementDrive drive = service.getDriveById(id);
        model.addAttribute("drive", drive);
        return "edit_drive";
    }

    @PostMapping("/update")
    public String updateDrive(@ModelAttribute("drive") PlacementDrive drive) {
        service.saveDrive(drive);
        return "redirect:/drives";
    }

    @GetMapping("/delete/{id}")
    public String deleteDrive(@PathVariable Long id) {
        service.deleteDrive(id);
        return "redirect:/drives";
    }
}
