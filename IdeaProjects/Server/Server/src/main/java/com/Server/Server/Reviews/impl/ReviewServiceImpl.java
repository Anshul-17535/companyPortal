package com.Server.Server.Reviews.impl;

import com.Server.Server.Company.CompanyService;
import com.Server.Server.Company.classes.Company;
import com.Server.Server.Reviews.ReviewService;
import com.Server.Server.Reviews.classes.Review;
import com.Server.Server.Reviews.repo.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    ReviewRepository myReviewRepo;
    CompanyService myCompanyService;

    public ReviewServiceImpl(ReviewRepository myReviewRepo, CompanyService myCompanyService) {
        this.myReviewRepo = myReviewRepo;
        this.myCompanyService = myCompanyService;
    }

    @Override
    public List<Review> findReviewByCompanyId(Long companyId) {
        return myReviewRepo.findAllByCompanyId(companyId);
    }

    @Override
    public Review getReviewById(Long Id) {
        return myReviewRepo.findById(Id).orElse(null);
    }

    @Override
    public void addReviewById(Long companyId, Review r) {
        Company c = myCompanyService.getCompanyByID(companyId);
        if(c!=null) {
            r.setCompany(c);
            myReviewRepo.save(r);
        }
        myReviewRepo.save(r);
    }

    @Override
    public boolean updateReviewById(Long Id,Review R) {
        Optional<Review> oPT = myReviewRepo.findById(Id);
        if(oPT.isPresent()){
            Review orig = oPT.get();
            orig.setReview(R.getReview());
            myReviewRepo.save(orig);
            return true;
        }
        else return false;
    }

    @Override
    public boolean deleteById(Long id) {
        try{
             myReviewRepo.deleteById(id);
             return true;
        }catch (Exception e){
            return false;
        }
    }
}
