package be.vans.naheulbook.models.form;

import be.vans.naheulbook.models.entities.Characteristic;
import be.vans.naheulbook.models.entities.Character;
import be.vans.naheulbook.models.entities.Job;
import be.vans.naheulbook.models.entities.Origin;
import be.vans.naheulbook.models.entities.Skill;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterAddForm {

    private String firstname;

    private String lastname;

    private int gold;

    private int fate;

    private List<Characteristic> characteristics;

    private Job job;

    private Origin origin;

    private List<Skill> skills;

   public Character toBll(){
       return Character.builder()
               .firstname(firstname)
               .lastname(lastname)
               .gold(gold)
               .fate(fate)
               .job(job)
               .origin(origin)
               .stats(characteristics)
               .skills(skills)
               .build();
   }

}
