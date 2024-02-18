package com.alterdekim.rxtest.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Department {
    @SerializedName("departmentId")
    private final int departmentId;

    @SerializedName("displayName")
    private final String displayName;

    private List<Integer> objectIDs;

    public Department(int departmentId, String displayName) {
        this.departmentId = departmentId;
        this.displayName = displayName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getDisplayName() {
        return displayName;
    }


    public List<Integer> getObjectIDs() {
        return objectIDs;
    }

    public void setObjectIDs(List<Integer> objectIDs) {
        this.objectIDs = objectIDs;
    }
}
