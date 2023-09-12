package com.company.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
	private String company_number;
    private String company_type;
    private String title;
    private String company_status;
    private String date_of_creation;
    private Address address;
    private List<Officer> officers;
}
