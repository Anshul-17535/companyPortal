package com.Server.Server.Reviews;

import com.Server.Server.Reviews.classes.Review;

import java.util.List;

public interface ReviewService {
    List<Review> findReviewByCompanyId(Long companyId);
    Review getReviewById(Long Id);
    void addReviewById(Long companyId,Review r);
    boolean updateReviewById(Long Id,Review r);
    boolean deleteById(Long id);
}
