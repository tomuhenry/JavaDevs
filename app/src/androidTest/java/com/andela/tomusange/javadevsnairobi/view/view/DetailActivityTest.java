package com.andela.tomusange.javadevsnairobi.view.view;

import android.content.Intent;
import android.os.SystemClock;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.andela.tomusange.javadevsnairobi.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class DetailActivityTest {


    @Rule
    public IntentsTestRule<DetailActivity> activityIntentsTestRule =
            new IntentsTestRule<>(DetailActivity.class, true, false);

    @Before
    public void stubUserName(){
        Intent intent = new Intent();

        intent.putExtra("userName", "jumaallan");
        intent.putExtra("imageUrl", "https://avatars3.githubusercontent.com/u/25085146?v=4");
        intent.putExtra("gihubUrl", "https://github.com/jumaallan");
        activityIntentsTestRule.launchActivity(intent);
    }

    @Test
    public void test_username_displayed(){
        onView(withId(R.id.git_user_name)).check(matches(withText("jumaallan")));
    }

    @Test
    public void test_share_intent(){
        SystemClock.sleep(3000);
        onView(withId(R.id.share_menu)).perform(click());
    }

}