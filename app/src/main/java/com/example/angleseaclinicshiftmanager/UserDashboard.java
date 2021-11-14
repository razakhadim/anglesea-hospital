package com.example.angleseaclinicshiftmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserDashboard extends AppCompatActivity {

    TextView cv_staff_info_name, cv_staff_info_dob, cv_staff_info_role, cv_staff_info_id_number;
    ImageView cv_staff_image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        cv_staff_info_name = findViewById(R.id.cv_staff_info_name);
        cv_staff_info_dob = findViewById(R.id.cv_staff_info_dob);
        cv_staff_info_role = findViewById(R.id.cv_staff_info_role);
        cv_staff_info_id_number = findViewById(R.id.cv_staff_info_id_number);

        cv_staff_image = findViewById(R.id.cv_staff_image);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://address")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AngleseaAPI angleseaAPI = retrofit.create(AngleseaAPI.class);

        Call<List<StaffData>> call = AngleseaAPI.getStaffData();

        call.enqueue(new Callback<List<StaffData>>() {
            @Override
            public void onResponse(Call<List<StaffData>> call, Response<List<StaffData>> response) {
                if (!response.isSuccessful()) {
                    cv_staff_info_name.setText("CODE: " + response.code());
                    return;
                }

                List<StaffData> staffdata = response.body();

                for (StaffData staffData : staffdata) {
                 //   String
                }
            }

            @Override
            public void onFailure(Call<List<StaffData>> call, Throwable t) {

            }
        });

    }
}