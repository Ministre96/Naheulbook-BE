package be.vans.naheulbook.controllers;

import be.vans.naheulbook.exceptions.HttpNotFoundException;
import be.vans.naheulbook.exceptions.HttpPreConditionFailedException;
import be.vans.naheulbook.models.dtos.CharacterDTO;
import be.vans.naheulbook.models.dtos.JobDTO;
import be.vans.naheulbook.models.dtos.OriginDTO;
import be.vans.naheulbook.models.entities.Origin;
import be.vans.naheulbook.models.form.OriginAddForm;
import be.vans.naheulbook.services.character.CharacterService;
import be.vans.naheulbook.services.origin.OriginService;
import ch.qos.logback.core.pattern.FormatInfo;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/origins")
public class OriginController {
    private final OriginService originService;

    public OriginController(OriginService originService) {this.originService = originService;}

    @GetMapping("")
    public ResponseEntity<Collection<OriginDTO>> getAllAction(
            Pageable pageable
    ){
        return ResponseEntity.ok(this.originService.readAll(pageable).map(OriginDTO:: toDTO).toList());
    }

    @PostMapping("")
    public ResponseEntity<OriginDTO> addOriginAction(
            @Valid @RequestBody OriginAddForm originAddForm
    ){
        Origin origin = new Origin();
        try{
            origin = this.originService.save(originAddForm.toBll());
        }catch (Exception exception){
            throw new HttpPreConditionFailedException(exception.getMessage(), new ArrayList<>());
        }
        return ResponseEntity.ok(OriginDTO.toDTO(origin));
    }

    @PutMapping(path="/{id:[0-9]+}")
    public ResponseEntity<OriginDTO> updateOneAction(
            @PathVariable int id,
            @Valid @RequestBody OriginAddForm originAddForm
    ){
        Origin origin = this.originService.readOneByKey(id).orElseThrow(() ->
                new HttpNotFoundException("There is no origin with id :("+ id +")"));
        origin.setName(originAddForm.getName());
        origin.setDescription(originAddForm.getDescription());
        origin.setRequierements(originAddForm.getRequierements());
        origin.setHeritatedSkill(originAddForm.getHeritatedSkill());
        origin.setSkillToChoose(originAddForm.getSkillToChoose());

        this.originService.save(origin);
        return ResponseEntity.ok(OriginDTO.toDTO(origin));
    }

    @DeleteMapping(path="/{id:[0-9]+}")
    public ResponseEntity<OriginDTO> deleteAction(
            @PathVariable int id
    ){
        Origin origin = this.originService.readOneByKey(id).orElseThrow(() ->
                new HttpNotFoundException("origin doesn't exist"));
        origin.setActive(false);
        this.originService.save(origin);
        return ResponseEntity.ok(OriginDTO.toDTO(origin));
    }


}

