package com.andela.tomusange.javadevsnairobi.view.view;

import android.os.SystemClock;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.andela.tomusange.javadevsnairobi.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity>
            activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void scroll_to_position() {
        SystemClock.sleep(4000);
        onView(withId(R.id.recycler_view))
                .perform(actionOnItemAtPosition(10, click()));
    }

    @Test
    public void swipe_to_refresh() {
        SystemClock.sleep(4000);
        onView(withId(R.id.swipeContainer))
                .perform(ViewActions.swipeDown());
    }
}