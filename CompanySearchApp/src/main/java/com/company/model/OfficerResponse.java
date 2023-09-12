package com.company.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfficerResponse {
    @JsonIgnore
	private String etag;
    @JsonIgnore
    private OfficerLinks links;
    @JsonIgnore
    private String kind;
    @JsonIgnore
    private int items_per_page;
    private List<Officer> items;
    @JsonIgnore
    private int active_count;
    @JsonIgnore
    private int total_results;
    @JsonIgnore
    private int resigned_count;

}
