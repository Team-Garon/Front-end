package com.example.garon.controller;

import com.example.garon.RetrofitClient;
import com.example.garon.domain.Form;
import com.example.garon.dto.AddFormRequest;
import com.example.garon.service.FormService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FormController {

    private FormService formService;

    public FormController() {
        Retrofit retrofit = RetrofitClient.getRetrofitInstance();
        formService = retrofit.create(FormService.class);
    }

    public void addForm(AddFormRequest request, final Callback<Form> callback) {
        Call<Form> call = formService.addForm(request);
        call.enqueue(new Callback<Form>() {
            @Override
            public void onResponse(Call<Form> call, Response<Form> response) {
                callback.onResponse(call, response);
            }

            @Override
            public void onFailure(Call<Form> call, Throwable t) {
                callback.onFailure(call, t);
            }
        });
    }

    public void findFormByStudentId(long studentId, final Callback<Form> callback) {
        Call<Form> call = formService.findFormByStudentId(studentId);
        call.enqueue(new Callback<Form>() {
            @Override
            public void onResponse(Call<Form> call, Response<Form> response) {
                callback.onResponse(call, response);
            }

            @Override
            public void onFailure(Call<Form> call, Throwable t) {
                callback.onFailure(call, t);
            }
        });
    }
}

