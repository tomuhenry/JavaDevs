package com.andela.tomusange.javadevsnairobi.view.presenter;
import android.content.Context;
import android.widget.Toast;

import com.andela.tomusange.javadevsnairobi.view.model.AllUserResponse;
import com.andela.tomusange.javadevsnairobi.view.service.GithubService;
import com.andela.tomusange.javadevsnairobi.view.view.AllUserView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GitUserPresenter {
    GithubService githubService;
    Context context;

    public GitUserPresenter(Context context){
        this.githubService = new GithubService();
        this.context = context;
    }

    public void getDevProfiles(final AllUserView allUserView) {
        try{
            githubService.getAPI().getItems().enqueue(new Callback<AllUserResponse>() {

                @Override
                public void onResponse(Call<AllUserResponse> call, Response<AllUserResponse> response) {

                    allUserView.showAllUsers(response.body());
                }

                @Override
                public void onFailure(Call<AllUserResponse> call, Throwable t) {
                    Toast.makeText(context, "Error Fetching Data, Check Connection!", Toast.LENGTH_SHORT).show();

                }
            });

        } catch (Exception error){
            Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show();
        }
    }

}
