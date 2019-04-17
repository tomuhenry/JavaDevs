package com.andela.tomusange.javadevsnairobi.view.view;

import android.content.Intent;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.filters.LargeTest;

import static org.junit.Assert.*;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class DetailActivityTest {

    private final String userName = "k33ptoo";
    private final String githubUrl = "";
    private final String imageUrl = "https://avatars0.githubusercontent.com/u/6637970?v=4";

    @Rule
    public ActivityTestRule<DetailActivity> detailActivityActivityTestRule = new
            ActivityTestRule<>(DetailActivity.class);

    @Rule
    public IntentsTestRule<DetailActivity> intentsTestRule = new
            IntentsTestRule<>(DetailActivity.class, true, false);

    @Before
    public void startActivity() throws InterruptedException {

    }

    @Test
    public void onCreate() {
    }

    @Test
    public void onCreateOptionsMenu() {
    }
}