package com.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.model.Company;
import com.company.service.CompanySearchService;

@RestController
@RequestMapping("/company")
public class CompanySearchController {

	@Autowired
	CompanySearchService compService;

	@GetMapping("/active-company-records")
	public List<Company> getActiveRecords() {
		return compService.getAllActiveCompany();
	}

}
