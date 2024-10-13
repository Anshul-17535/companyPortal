package com.Server.Server.Jobs;

import com.Server.Server.Jobs.classes.Job;

import java.util.List;

public interface JobService {
    List<Job> findAllJobs();
    void addJob(Job j);
    Job getJobById(Long id);
    boolean delById(Long id);
    boolean updateById(Long id,Job j);
}
