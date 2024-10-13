package com.Server.Server.Jobs;

import com.Server.Server.Jobs.classes.Job;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {
    JobService myJobservice ;

    JobController(JobService myJobservices){
        myJobservice = myJobservices;
    }

    @GetMapping
    public ResponseEntity<List<Job>> getJob(){
        return new ResponseEntity<>(myJobservice.findAllJobs(), HttpStatus.OK);
    }

    @PostMapping
    public  ResponseEntity<String> addJob(@RequestBody Job J){
        myJobservice.addJob(J);
        return new ResponseEntity<>("USER ADDED SUCCESSFULY",HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        if(myJobservice.getJobById(id) != null) return new ResponseEntity<>(myJobservice.getJobById(id),HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delById(@PathVariable Long id){
        boolean isDeleted = false;
        isDeleted = myJobservice.delById(id);
        if(isDeleted) return new ResponseEntity<>("Succesfully Delete",HttpStatus.OK);
        else return new ResponseEntity<>("Error While deleting",HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<String> putById(@PathVariable Long id,@RequestBody Job myJ){
        boolean updated = false;
        updated = myJobservice.updateById(id,myJ);
        if(updated) return new ResponseEntity<>("Updated Succesfully",HttpStatus.OK);
        else return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }
}
