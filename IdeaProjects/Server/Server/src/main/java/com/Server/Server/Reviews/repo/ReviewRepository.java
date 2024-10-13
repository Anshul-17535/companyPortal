package com.Server.Server.Reviews.repo;

import com.Server.Server.Reviews.classes.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    List<Review> findAllByCompanyId(Long id);
}
