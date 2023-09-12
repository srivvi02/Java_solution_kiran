package com.company.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	 private String locality;
	 private String postal_code;
	 private String premises;
	 private String address_line_1;
	 private String country;
}
