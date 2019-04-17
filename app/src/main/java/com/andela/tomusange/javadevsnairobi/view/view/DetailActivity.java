package com.andela.tomusange.javadevsnairobi.view.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.util.Linkify;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.andela.tomusange.javadevsnairobi.R;
import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    TextView Link, Username;
    ImageView imageView;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageView = findViewById(R.id.user_image);
        Username = findViewById(R.id.git_user_name);
        Link = findViewById(R.id.github_url);

        String username = getIntent().getExtras().getString("userName");
        String avatarUrl = getIntent().getExtras().getString("imageUrl");
        String link = getIntent().getExtras().getString("githubUrl");

        Link.setText(link);
        Linkify.addLinks(Link, Linkify.WEB_URLS);

        Username.setText(username);
        Glide.with(this)
                .load(avatarUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView);

        getSupportActionBar().setTitle("Details Activity");
    }

    private Intent createShareForcastIntent(){
        String username = getIntent().getExtras().getString("userName");
        String link = getIntent().getExtras().getString("githubUrl");

        Intent shareIntent = ShareCompat.IntentBuilder.from(this)
                .setType("text/plain")
                .setText("Check out this awesome developer @" + username + " , " + link )
                .getIntent();
        return shareIntent;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.share_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.share_menu);
        menuItem.setIntent(createShareForcastIntent());
        return true;
    }
}