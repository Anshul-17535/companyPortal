package com.Server.Server.Jobs.repo;

import com.Server.Server.Jobs.classes.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Long> {
}
