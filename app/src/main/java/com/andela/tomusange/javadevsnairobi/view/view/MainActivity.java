package com.andela.tomusange.javadevsnairobi.view.view;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.andela.tomusange.javadevsnairobi.R;
import com.andela.tomusange.javadevsnairobi.view.adapter.GithubUserAdapter;
import com.andela.tomusange.javadevsnairobi.view.presenter.GitUserPresenter;
import com.andela.tomusange.javadevsnairobi.view.model.UserDetail;
import com.andela.tomusange.javadevsnairobi.view.model.AllUserResponse;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AllUserView{

    private RecyclerView recyclerView;
    ProgressDialog loadingData;
    List<UserDetail> userDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        GitUserPresenter gitUserPresenter = new GitUserPresenter(this);
        gitUserPresenter.getDevProfiles(this);

    }

    private void initViews() {
        loadingData = new ProgressDialog(this);
        loadingData.setMessage("Fetching Nairobi Java Users...");
        loadingData.setCancelable(false);
        loadingData.show();
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.smoothScrollToPosition(0);
    }

    private void loadUsers(List<UserDetail> userDetails) {
        recyclerView.setAdapter(new GithubUserAdapter(userDetails, getApplicationContext()));
        recyclerView.smoothScrollToPosition(0);
        loadingData.hide();
    }

    @Override
    public void showAllUsers(AllUserResponse response) {

        userDetails = response.getUserDetails();
        loadUsers(userDetails);
    }
}