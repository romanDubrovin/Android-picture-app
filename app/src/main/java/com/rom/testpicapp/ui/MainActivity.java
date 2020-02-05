package com.rom.testpicapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.rom.testpicapp.R;
import com.rom.testpicapp.net.NetworkService;
import com.rom.testpicapp.net.model.Result;
import com.rom.testpicapp.net.model.User;
import com.rom.testpicapp.ui.adapter.UserAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcv;
    private UserAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        fetchData();
    }

    private void initialize() {
        rcv = findViewById(R.id.rcv);

        rcv.setLayoutManager(new LinearLayoutManager(this));

        adapter = new UserAdapter();
        rcv.setAdapter(adapter);
    }

    private void fetchData() {
        Call<Result> call = NetworkService.createService().getUserList();

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if (response.body() != null) {
                    List<User> users = response.body().getItems();
                    adapter.update(users);

                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.d("Error", t.getMessage());
                Toast.makeText(MainActivity.this, "Error Fetching Data!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}