package com.br.apptest.presenter.activity

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class RepoActivityTest{
    @get:Rule
    val activityRule = ActivityScenarioRule(RepoActivity::class.java)
}
