package com.Server.Server.Jobs.impl;

import com.Server.Server.Jobs.JobService;
import com.Server.Server.Jobs.classes.Job;
import com.Server.Server.Jobs.repo.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    JobRepository myRepo;

    public JobServiceImpl(JobRepository myRepo) {
        this.myRepo = myRepo;
    }

    @Override
    public List<Job> findAllJobs() {
        return myRepo.findAll();
    }

    @Override
    public void addJob(Job j) {
        myRepo.save(j);
        return;
    }

    @Override
    public Job getJobById( Long id){
        return myRepo.findById(id).orElse(null);
    }

    @Override
    public boolean delById(Long id) {
        try{
            myRepo.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean updateById(Long id,Job upJ) {
        Optional<Job> myJob = myRepo.findById(id);
        if(myJob.isPresent()){
            Job myJ = myJob.get();
            myJ.setId(upJ.getId());
            myJ.setName(upJ.getName());
            myJ.setSalary(upJ.getSalary());
            myJ.setMaxSalary(upJ.getMaxSalary());
            myJ.setDescription(upJ.getDescription());
            myJ.setCompany(upJ.getCompany());
            myJ.setCompany(upJ.getCompany());
            myRepo.save(myJ);
            return true;
        }
        return false;
    }
}
