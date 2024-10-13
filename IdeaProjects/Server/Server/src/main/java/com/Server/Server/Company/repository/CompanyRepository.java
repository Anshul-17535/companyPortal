package com.Server.Server.Company.repository;

import com.Server.Server.Company.classes.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
