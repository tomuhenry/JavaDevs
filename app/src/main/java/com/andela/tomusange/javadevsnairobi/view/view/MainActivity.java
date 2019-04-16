package com.andela.tomusange.javadevsnairobi.view.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.andela.tomusange.javadevsnairobi.R;
import com.andela.tomusange.javadevsnairobi.view.adapter.GithubUserAdapter;
import com.andela.tomusange.javadevsnairobi.view.model.AllUserResponse;
import com.andela.tomusange.javadevsnairobi.view.model.UserDetail;
import com.andela.tomusange.javadevsnairobi.view.presenter.GitUserPresenter;
import com.andela.tomusange.javadevsnairobi.view.utility.CheckConnection;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AllUserView{

    private RecyclerView recyclerView;
    ProgressDialog loadingData;
    List<UserDetail> userDetails;
    SwipeRefreshLayout swipeContainer;
    GitUserPresenter gitUserPresenter = new GitUserPresenter(this);
    private CheckConnection checkConnection;
    private CoordinatorLayout coordinatorLayout;
    Parcelable listState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        if (savedInstanceState != null) {
            userDetails = savedInstanceState.getParcelableArrayList("items");
            listState = savedInstanceState.getParcelable("listState");
        } else {
            gitUserPresenter.getDevProfiles(this);
        }

        coordinatorLayout = findViewById(R.id.cordinator);
        checkConnection = new CheckConnection(this);
        if (!checkConnection.isConnected()) {
            showSnackbar();
            loadingData.hide();
        }

        swipeContainer = findViewById(R.id.swipeContainer);

        swipeContainer.setColorSchemeResources(android.R.color.background_light
        );
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData();
                Toast.makeText(MainActivity.this, "Refreshing Users", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initViews() {
        loadingData = new ProgressDialog(this);
        loadingData.setMessage("Fetching Nairobi Java Users...");
        loadingData.setCancelable(false);
        loadingData.show();
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    public void showSnackbar() {
        Snackbar snackbar = Snackbar.make(coordinatorLayout,
                "No Internet Connection, Connect to Mobile Data or Wifi",
                Snackbar.LENGTH_INDEFINITE);
        snackbar.show();
    }

    private void loadUsers(List<UserDetail> userDetails) {
        swipeContainer.setRefreshing(false);
        recyclerView.setAdapter(new GithubUserAdapter(userDetails, getApplicationContext()));
        loadingData.hide();
    }

    public void refreshData() {
        gitUserPresenter.getDevProfiles(this);
    }

    @Override
    public void showAllUsers(AllUserResponse response) {

        userDetails = response.getUserDetails();
        loadUsers(userDetails);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("items", (ArrayList<? extends Parcelable>) userDetails);
        outState.putParcelable("listState", recyclerView.getLayoutManager().onSaveInstanceState());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        userDetails = savedInstanceState.getParcelableArrayList("items");
        listState = savedInstanceState.getParcelable("listState");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (listState != null) {
            recyclerView.getLayoutManager().onRestoreInstanceState(listState);
            loadUsers(userDetails);
        }
    }
}