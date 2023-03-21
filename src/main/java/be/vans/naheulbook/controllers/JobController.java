package be.vans.naheulbook.controllers;

import be.vans.naheulbook.exceptions.HttpNotFoundException;
import be.vans.naheulbook.models.dtos.JobDTO;
import be.vans.naheulbook.models.entities.Job;
import be.vans.naheulbook.models.form.JobAddForm;
import be.vans.naheulbook.services.job.JobService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }


    @GetMapping("")
    public ResponseEntity<Collection<JobDTO>> getAllAction(
            Pageable pageable
    ){
        return ResponseEntity.ok(this.jobService.readAllByActive(pageable).map(JobDTO :: toDTO).toList());
    }

    @PostMapping("")
    public ResponseEntity<JobDTO> addJobAction(
            @Valid @RequestBody JobAddForm jobAddForm
    ){
        Job job = new Job();
        job = this.jobService.save(jobAddForm.toBll());
        return ResponseEntity.ok(JobDTO.toDTO(job));
    }

    @PutMapping(path="/{id:[0-9]+}")
    public ResponseEntity<JobDTO> updateOne(
            @PathVariable int id,
            @Valid @RequestBody JobAddForm jobAddForm
    ){
     Job job = this.jobService.readOneByKey(id).orElseThrow(() ->
             new HttpNotFoundException("There is no job with id:("+ id + ")"));

     job.setName(jobAddForm.getName());
     job.setDescription(jobAddForm.getDescription());
     job.setRequierement(jobAddForm.getRequierement());
     job.setBannedOrigin(jobAddForm.getBannedOrigin());
     job.setHeritatedSkill(jobAddForm.getHeritatedSkill());
     job.setSkillToChoose(jobAddForm.getSkillToChoose());

     this.jobService.save(job);
     return ResponseEntity.ok(JobDTO.toDTO(job));
    }

    @DeleteMapping("/{id:[0-9]+}")
    public ResponseEntity<JobDTO> deleteAction(
            @PathVariable int id
    ){
        Job job = this.jobService.readOneByKey(id).orElseThrow(()-> new HttpNotFoundException("job doesn't exist "));
        job.setActive(false);
        this.jobService.save(job);
        return ResponseEntity.ok(JobDTO.toDTO(job));
    }





}
