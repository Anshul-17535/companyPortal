package com.Server.Server.Company.impl;

import com.Server.Server.Company.CompanyService;
import com.Server.Server.Company.classes.Company;
import com.Server.Server.Company.repository.CompanyRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ComanyServiceImpl implements CompanyService {
    CompanyRepository myRepo;

    public ComanyServiceImpl(CompanyRepository myRepo) {
        this.myRepo = myRepo;
    }

    @Override
    public List<Company> findAll() {
        return myRepo.findAll();
    }

    @Override
    public Company getCompanyByID(Long id) {
        return myRepo.findById(id).orElse(null);
    }

    @Override
    public void addCompany(Company c) {
        myRepo.save(c);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        try{
            myRepo.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateCompany(Long id, Company c) {
        Optional<Company> myComp = myRepo.findById(id);
        if(myComp.isPresent()){
            Company myC = myComp.get();
            myC.setCompanyName(c.getCompanyName());
            myC.setId(c.getId());
            myC.setJobs(c.getJobs());
            myC.setLocation(c.getLocation());
            myC.setReviews(c.getReviews());
            myC.setMaxSalary(c.getMaxSalary());
            myRepo.save(myC);
            return true;
        }
        return false;
    }
}
