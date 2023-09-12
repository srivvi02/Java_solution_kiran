package com.company.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.company.model.Company;
import com.company.model.CompanyResponse;
import com.company.model.Officer;
import com.company.model.OfficerResponse;

@Service
public class CompanySearchService {
	@Autowired
	private RestTemplate restTemplate;
	@Value("${externalSearchApiUrl}")
	private  String externalSearchApiUrl;
	@Value("${externalOfficersApiUrl}")
	private  String externalOfficersApiUrl;
	@Value("${apiKey}")
	private  String apiKey;

	public List<Company> getAllActiveCompany() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("x-api-key", apiKey);
		HttpEntity<String> entity = new HttpEntity<>(headers);

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(externalSearchApiUrl)
				.queryParam("Query", "06500244").queryParam("company_status", "active");
		
		try {

		ResponseEntity<CompanyResponse> responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET,
				entity, CompanyResponse.class);

		UriComponentsBuilder builder1 = UriComponentsBuilder.fromUriString(externalOfficersApiUrl)
				.queryParam("CompanyNumber", "06500244");

		
	                
		CompanyResponse companyResponse = responseEntity.getBody();
		if (companyResponse != null && companyResponse.getItems() != null) {
			List<Company> finalList = new ArrayList<Company>();
			// return companyResponse.getItems();
			for (Company companyItem : companyResponse.getItems()) {
				if (companyItem.getCompany_status().equals("active")) {

					ResponseEntity<OfficerResponse> offResponseEntity  = restTemplate.exchange(builder1.toUriString(), HttpMethod.GET,
							entity,OfficerResponse.class);
					OfficerResponse officerListResponse  = offResponseEntity.getBody();
					List<Officer> offRes= officerListResponse.getItems().stream().filter(o->o.getResigned_on() == null).collect(Collectors.toList());
					 if (offRes != null && offRes != null) {
						 	companyItem.setOfficers(offRes);
				        }
					finalList.add(companyItem);
				}
			}
			return finalList;
		} else {
			return Collections.emptyList();
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
