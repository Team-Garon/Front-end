package com.example.garon;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.garon.controller.FormController;
import com.example.garon.domain.Form;
import com.example.garon.dto.AddFormRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private FormController formController;
    private EditText startDateEditText;
    private EditText startTimeEditText;
    private EditText studentIdEditText;
    private EditText nameEditText;
    private EditText sexEditText;
    private EditText phoneEditText;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startDateEditText = findViewById(R.id.date_input);
        startTimeEditText = findViewById(R.id.time_input);
        studentIdEditText = findViewById(R.id.student_id_input);
        nameEditText = findViewById(R.id.name_id_input);
        sexEditText = findViewById(R.id.sex_id_input);
        phoneEditText = findViewById(R.id.phonenum_id_input);
        addButton = findViewById(R.id.button_id);

        formController = new FormController();

        addButton.setOnClickListener(view -> {
            String startDateString = startDateEditText.getText().toString();
            String startTimeString = startTimeEditText.getText().toString();
            String studentIdString = studentIdEditText.getText().toString();
            String name = nameEditText.getText().toString();
            String sex = sexEditText.getText().toString();
            String phone = phoneEditText.getText().toString();

            AddFormRequest request = new AddFormRequest();

            // startDateString을 Date로 변환하여 설정
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            try {
//                Date startDate = dateFormat.parse(startDateString);
//                request.setStartDate(startDate);
//            } catch (ParseException e) {
//                e.printStackTrace();
//                Toast.makeText(MainActivity.this, "Invalid date format", Toast.LENGTH_SHORT).show();
//                return;
//            }
            request.setStartDate(startDateString);
            request.setStartTime(startTimeString);

            // studentIdString을 Long으로 변환하여 설정
            try {
                Long studentId = Long.parseLong(studentIdString);
                request.setStudentId(studentId);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                Toast.makeText(MainActivity.this, "Invalid student ID format", Toast.LENGTH_SHORT).show();
                return;
            }

            request.setName(name);
            request.setSex(sex);
            request.setPhone(phone);


            formController.addForm(request, new Callback<Form>() {
                @Override
                public void onResponse(Call<Form> call, Response<Form> response) {
                    if (response.isSuccessful()) {
                        Form form = response.body();
                        // 서버에서 받아온 데이터 처리
                        Toast.makeText(MainActivity.this, "Form added: " + form.toString(), Toast.LENGTH_SHORT).show();
                    } else {
                        // 서버 오류 처리
                        Toast.makeText(MainActivity.this, "Failed to add form", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Form> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}