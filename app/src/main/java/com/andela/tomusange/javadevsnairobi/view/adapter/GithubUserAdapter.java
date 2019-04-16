package com.andela.tomusange.javadevsnairobi.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andela.tomusange.javadevsnairobi.R;
import com.andela.tomusange.javadevsnairobi.view.view.DetailActivity;
import com.andela.tomusange.javadevsnairobi.view.model.UserDetail;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GithubUserAdapter extends RecyclerView.Adapter<GithubUserAdapter.ViewHolder>{
    private static final String TAG = "GithubUserAdapter";

    private List<UserDetail> userDetails;
    private Context context;

    public GithubUserAdapter(List<UserDetail> userDetails, Context context) {
        this.userDetails = userDetails;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.userName.setText(userDetails.get(i).getUserName());
        viewHolder.githubUrl.setText(userDetails.get(i).getGithubUrl());

        Picasso.get()
                .load(userDetails.get(i).getImageUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .into(viewHolder.userImage);

    }

    @Override
    public int getItemCount() {
        return userDetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView userName,githubUrl;
        ImageView userImage;
        CardView ParentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.user_name);
            githubUrl = itemView.findViewById(R.id.github_link);
            userImage = itemView.findViewById(R.id.image);
            ParentLayout = itemView.findViewById(R.id.parent_layout);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        UserDetail clickedDataUserDetail = userDetails.get(position);
                        Intent intent = new Intent(context, DetailActivity.class);
                        intent.putExtra("userName", userDetails.get(position).getUserName());
                        intent.putExtra("githubUrl", userDetails.get(position).getGithubUrl());
                        intent.putExtra("imageUrl", userDetails.get(position).getImageUrl());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                }
            });
        }
    }
}