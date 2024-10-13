package com.Server.Server.Reviews;

import com.Server.Server.Reviews.classes.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}/reviews")
public class ReviewController {
    ReviewService myService;

    @Autowired
    public ReviewController(ReviewService myService) {
        this.myService = myService;
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long Id){
        return new ResponseEntity<>(this.myService.getReviewById(Id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> postReview(@PathVariable Long companyId, @RequestBody Review myR){
        myService.addReviewById(companyId,myR);
        return new ResponseEntity<>("Review Added Successfully", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReview(@PathVariable Long companyId){
        return  new ResponseEntity<>(myService.findReviewByCompanyId(companyId),HttpStatus.OK);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<String> putReview(@PathVariable Long Id,@RequestBody Review r){
        boolean upDValue=myService.updateReviewById(Id,r);
        if(upDValue){
            return  new ResponseEntity<>("Review Updated",HttpStatus.OK);
        }else{
            return  new ResponseEntity<>("Review Not found",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<String> delReview(@PathVariable Long Id){
        boolean upDValue=myService.deleteById(Id);
        if(upDValue){
            return  new ResponseEntity<>("Review Deleted",HttpStatus.OK);
        }else{
            return  new ResponseEntity<>("Review Not found",HttpStatus.NOT_FOUND);
        }
    }

}
