package com.alterdekim.rxtest.network;

import com.alterdekim.rxtest.model.DepartmentsResponse;
import com.alterdekim.rxtest.model.EmployeeResponse;
import com.alterdekim.rxtest.model.ObjectIdsResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

//    https://metmuseum.github.io/
//    https://collectionapi.metmuseum.org/public/collection/v1/departments
//    https://collectionapi.metmuseum.org/public/collection/v1/

 //   https://collectionapi.metmuseum.org/public/collection/v1/objects/10
//    {
//        "departments": [
//        {
//            "departmentId": 1,
//                "displayName": "American Decorative Arts"
//        },
//        {
//            "departmentId": 3,
//                "displayName": "Ancient Near Eastern Art"
//        },

    @GET("departments")
    Observable<DepartmentsResponse> getDepartments();

    @GET("objects")
    Observable<ObjectIdsResponse> getObjects(@Query("departmentIds") int departmentId);

    @GET("testTask.json")
    Observable<EmployeeResponse> getEmployees();

}
