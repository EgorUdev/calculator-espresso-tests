package com.simplemobiletools.calculator.activities


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.simplemobiletools.calculator.R
import org.hamcrest.Matchers.allOf


import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)


class MainActivityTest{
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testViewsVisibility() {

        onView(withId(R.id.calculator_holder)).check(matches(isDisplayed()))
        onView(withId(R.id.formula)).check(matches(isDisplayed()))
        onView(withText("Calculator_debug")).check(matches(isDisplayed()))
        onView(withContentDescription("More options")).check(matches(isDisplayed()))
        onView(allOf(withId(R.id.result), withText("0"))).check(matches(isDisplayed()))
        onView(withId(R.id.btn_percent)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_power)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_root)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_clear)).check(matches(isDisplayed()))

        onView(withId(R.id.btn_7)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_8)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_9)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_divide)).check(matches(isDisplayed()))

        onView(withId(R.id.btn_4)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_5)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_6)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_multiply)).check(matches(isDisplayed()))

        onView(withId(R.id.btn_1)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_2)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_3)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_minus)).check(matches(isDisplayed()))

        onView(withId(R.id.btn_0)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_decimal)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_equals)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_plus)).check(matches(isDisplayed()))

    }
}
