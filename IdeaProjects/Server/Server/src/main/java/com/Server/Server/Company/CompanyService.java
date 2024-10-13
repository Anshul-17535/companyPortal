package com.Server.Server.Company;

import com.Server.Server.Company.classes.Company;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();
    Company getCompanyByID(Long id);
    void addCompany(Company c);
    boolean deleteCompanyById(Long id);
    boolean updateCompany(Long id,Company c);
}
