package com.example.garon.service;

import com.example.garon.domain.Form;
import com.example.garon.dto.AddFormRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface FormService {
    @POST("/forms")
    Call<Form> addForm(@Body AddFormRequest request);

    @GET("/forms/{studentId}")
    Call<Form> findFormByStudentId(@Path("studentId") long studentId);
}
