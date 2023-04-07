package be.vans.naheulbook.models.form;

import be.vans.naheulbook.models.entities.Character;
import be.vans.naheulbook.models.entities.Customer;
import be.vans.naheulbook.models.entities.Job;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCreateForm {

    private String pseudo;
    private String password;
    private String mail;
    private List<Character> characters;
    private List<Character> subsribe;

    public Customer toBll(){
        return Customer.builder()
                .pseudo(pseudo)
                .password(password)
                .mail(mail)
                .characters(characters)
                .subsribe(subsribe)
                .build();
    }

}
