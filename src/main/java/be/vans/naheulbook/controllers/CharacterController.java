package be.vans.naheulbook.controllers;

import be.vans.naheulbook.models.dtos.CharacterDTO;
import be.vans.naheulbook.models.dtos.JobDTO;
import be.vans.naheulbook.models.entities.Character;
import be.vans.naheulbook.models.entities.Job;
import be.vans.naheulbook.models.form.CharacterAddForm;
import be.vans.naheulbook.models.form.JobAddForm;
import be.vans.naheulbook.services.character.CharacterService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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
        Collection<CharacterDTO> characters = this.characterService.readAll(pageable).map(CharacterDTO :: toDTO).collect(Collectors.toList());
        Collections.shuffle(characters.stream().collect(Collectors.toList()));
        return ResponseEntity.ok(characters);
    }

    @PostMapping("")
    public ResponseEntity<CharacterDTO> addCharacterAction(
            @Valid @RequestBody CharacterAddForm characterAddForm
    ){
        Character character = new Character();
        character = this.characterService.save(characterAddForm.toBll());
        return ResponseEntity.ok(CharacterDTO.toDTO(character));
    }
}
