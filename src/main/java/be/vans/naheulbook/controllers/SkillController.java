package be.vans.naheulbook.controllers;

import be.vans.naheulbook.models.dtos.OriginDTO;
import be.vans.naheulbook.models.dtos.SkillDTO;
import be.vans.naheulbook.services.origin.OriginService;
import be.vans.naheulbook.services.skill.SkillService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/skills")
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {this.skillService = skillService;}

    @GetMapping("")
    public ResponseEntity<Collection<SkillDTO>> getAllAction(
            Pageable pageable
    ){
        return ResponseEntity.ok(this.skillService.readAll(pageable).map(SkillDTO:: toDTO).toList());
    }

}
