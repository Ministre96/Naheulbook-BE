package be.vans.naheulbook.controllers;

import be.vans.naheulbook.models.dtos.CharacterDTO;
import be.vans.naheulbook.models.dtos.OriginDTO;
import be.vans.naheulbook.services.character.CharacterService;
import be.vans.naheulbook.services.origin.OriginService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

