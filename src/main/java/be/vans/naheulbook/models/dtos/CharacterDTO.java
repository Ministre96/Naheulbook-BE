package be.vans.naheulbook.models.dtos;

import be.vans.naheulbook.models.entities.*;
import be.vans.naheulbook.models.entities.Character;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CharacterDTO {
    private int id;
    private String firstname;
    private String lastname;
    private Sexe sexe;
    private int gold;
    private int fate;
    private Job job;
    private Origin origin;
    private List<Skill> skills;
    private Customer creator;

    public static CharacterDTO toDTO(Character character){
        CharacterDTO.CharacterDTOBuilder dto =CharacterDTO.builder();
        return dto
                .id(character.getId())
                .firstname(character.getFirstname())
                .lastname(character.getLastname())
                .sexe(character.getSexe())
                .gold(character.getGold())
                .fate(character.getFate())
                .job(character.getJob())
                .origin(character.getOrigin())
                .skills(character.getSkills())
                .creator(character.getCreator())
                .build();
    }

}
