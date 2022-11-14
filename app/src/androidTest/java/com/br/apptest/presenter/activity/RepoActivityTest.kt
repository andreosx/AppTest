package com.br.apptest.presenter.activity

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.br.apptest.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class RepoActivityTest{

    @get:Rule
    val activityRule = ActivityScenarioRule(RepoActivity::class.java)

    @Test
    fun testVisibilityRecyclerView() {
        Thread.sleep(1000)
        onView(ViewMatchers.withId(R.id.rv_repository))
    }

    @Test
    fun scrollTopositionTest(){
        Thread.sleep(2000)
        onView(withId(R.id.rv_repository))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(10))
    }
}
