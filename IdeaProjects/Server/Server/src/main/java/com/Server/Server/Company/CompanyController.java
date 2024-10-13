package com.Server.Server.Company;

import com.Server.Server.Company.classes.Company;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    CompanyService myService;

    public CompanyController(CompanyService myService) {
        this.myService = myService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAll(){
        return new ResponseEntity<>(myService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getAll(@PathVariable Long id){
        return new ResponseEntity<>(myService.getCompanyByID(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody Company myC){
        myService.addCompany(myC);
        return new ResponseEntity<>("Company Added SuccessFully",HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delByID(@PathVariable Long id){
        boolean isPresent =myService.deleteCompanyById(id);
        if(isPresent){
            return new ResponseEntity<>("Comapny Deleted Successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> putById(@PathVariable Long id,@RequestBody Company myC){
        boolean isPresent =myService.updateCompany(id,myC);
        if(isPresent){
            return new ResponseEntity<>("Comapny Updated Successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
    }
}
