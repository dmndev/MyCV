package com.dmndev.mycv

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class FragmentTest {

    @get:Rule
    var activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    fun init(){
        activityTestRule.activity.supportFragmentManager.beginTransaction()
    }

    @Test
    fun testCompleteView() {
        onView(withId(R.id.fullName)).check(matches(isDisplayed()))

        onView(withId(R.id.email)).check(matches(isDisplayed()))

        onView(withId(R.id.phone)).check(matches(isDisplayed()))
    }

    @Test
    fun testNavigation() {
        onView(withId(R.id.navigation_dashboard)).check(matches(isDisplayed()))
        onView(withId(R.id.navigation_dashboard)).perform(click())
        onView(withId(R.id.experienceScreen)).check(matches(isDisplayed()))
    }
}