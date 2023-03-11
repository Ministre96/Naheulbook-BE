package be.vans.naheulbook.controllers;

import be.vans.naheulbook.exceptions.HttpPreConditionFailedException;
import be.vans.naheulbook.models.dtos.JobDTO;
import be.vans.naheulbook.models.dtos.OriginDTO;
import be.vans.naheulbook.models.dtos.SkillDTO;
import be.vans.naheulbook.models.entities.Job;
import be.vans.naheulbook.models.entities.Skill;
import be.vans.naheulbook.models.form.SkillAddForm;
import be.vans.naheulbook.services.origin.OriginService;
import be.vans.naheulbook.services.skill.SkillService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @PostMapping("")
    public ResponseEntity<SkillDTO> addSkillAction(
            @Valid @RequestBody SkillAddForm skillAddForm
    ){
        Skill skill = new Skill();
        try{
            skill = this.skillService.save(skillAddForm.toBll());
        }catch (Exception exception){
            throw new HttpPreConditionFailedException(exception.getMessage(), new ArrayList<>());
        }
        return ResponseEntity.ok(SkillDTO.toDTO(skill));
    }
}