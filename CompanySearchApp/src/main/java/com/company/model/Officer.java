package com.company.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Officer {
	private Address address;
	private String name;
	private String appointed_on;
	private String officer_role;
    @JsonIgnore
	private OfficerLinks links;
    @JsonIgnore
	private OfficerDateOfBirth date_of_birth;
    @JsonIgnore
	private String occupation;
    @JsonIgnore
	private String country_of_residence;
    @JsonIgnore
	private String nationality;
	private String resigned_on;
}
