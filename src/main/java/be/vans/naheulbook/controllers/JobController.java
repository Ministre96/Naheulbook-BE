package be.vans.naheulbook.controllers;

import be.vans.naheulbook.exceptions.HttpPreConditionFailedException;
import be.vans.naheulbook.models.dtos.JobDTO;
import be.vans.naheulbook.models.entities.Job;
import be.vans.naheulbook.models.form.JobAddForm;
import be.vans.naheulbook.services.job.JobService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping("")
    public ResponseEntity<JobDTO> addJobAction(
            @Valid @RequestBody JobAddForm jobAddForm
    ){
        Job job = new Job();
        try{
            job = this.jobService.save(jobAddForm.toBll());
        }catch (Exception exception){
            throw new HttpPreConditionFailedException(exception.getMessage(), new ArrayList<>());
        }
        return ResponseEntity.ok(JobDTO.toDTO(job));


    }
}
