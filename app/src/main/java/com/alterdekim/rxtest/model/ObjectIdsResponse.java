package com.alterdekim.rxtest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ObjectIdsResponse {
    @SerializedName("objectIDs")
    @Expose
    private final List<Integer> objectIDs;

    public ObjectIdsResponse(List<Integer> objectIDs) {
        this.objectIDs = objectIDs;
    }

    public List<Integer> getObjectIDs() {
        return objectIDs;
    }
}
