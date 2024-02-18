package com.alterdekim.rxtest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DepartmentsResponse {
    @SerializedName("departments")
    @Expose
    private final List<Department> departments;

    public DepartmentsResponse(List<Department> departments) {
        this.departments = departments;
    }

    public List<Department> getDepartments() {
        return departments;
    }


}
