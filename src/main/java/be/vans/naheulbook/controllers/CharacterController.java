package be.vans.naheulbook.controllers;

import be.vans.naheulbook.models.dtos.CharacterDTO;
import be.vans.naheulbook.services.character.CharacterService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("")
    public ResponseEntity<Collection<CharacterDTO>> getAllAction(
            Pageable pageable
    ){
        Collection<CharacterDTO> characters = this.characterService.readAll(pageable).map(CharacterDTO :: toDTO).toList();
        Collections.shuffle(characters.stream().toList());
        return ResponseEntity.ok(characters);
    }
}
