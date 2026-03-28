package controller;

import service.OrganizerService;
import entity.Organizer;
import dto.OrganizerDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizer")
public class OrganizerController {
    
    @Autowired
    private OrganizerService organizerService;

//    Create a new organizer
    @PostMapping
    public OrganizerDTO createOrganizer(@RequestBody Organizer organizer, @RequestParam Integer id) {
        Organizer savedOrganizer = organizerService.createOrganizer(organizer, id);
        return savedOrganizer;
//        OrganizerDTO organizerDTO = new OrganizerDTO(
//                savedOrganizer.getId(),
//                savedOrganizer.getTitle(),
//                savedOrganizer.getAuthor().getName()
//        );
//
//        return organizerDTO;
    }
}
