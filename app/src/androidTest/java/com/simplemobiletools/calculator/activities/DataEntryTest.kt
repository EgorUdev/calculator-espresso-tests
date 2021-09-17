package com.simplemobiletools.calculator.activities

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.longClick
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.simplemobiletools.calculator.R
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)

class DataEntryTest{
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testIsEnteredDataVisible() {
        //Check for entering numbers
        onView(allOf(withId(R.id.result), withText("0"))).check(matches(isDisplayed()))
        onView(withId(R.id.btn_3)).perform(click())
        onView(allOf(withId(R.id.result), withText("3"))).check(matches(isDisplayed()))

        onView(withId(R.id.btn_2)).perform(click())
        onView(allOf(withId(R.id.result), withText("32"))).check(matches(isDisplayed()))

        //Check for separator of thousands
        onView(withId(R.id.btn_1)).perform(click())
        onView(withId(R.id.btn_0)).perform(click())
        onView(allOf(withId(R.id.result), withText("3,210"))).check(matches(isDisplayed()))

        //Check if last number is deleted after single tap at C
        onView(withId(R.id.btn_clear)).perform(click())
        onView(allOf(withId(R.id.result), withText("321"))).check(matches(isDisplayed()))

        //Check if all data is deleted after long press at C
        onView(allOf(withId(R.id.result), withText("321"))).check(matches(isDisplayed()))
        onView(withId(R.id.btn_clear)).perform(longClick())
        onView(allOf(withId(R.id.result), withText("0"))).check(matches(isDisplayed()))

        //Check for decimal point separator with default 0
        onView(withId(R.id.btn_decimal)).perform(click())
        onView(allOf(withId(R.id.result), withText("0."))).check(matches(isDisplayed()))
        onView(withId(R.id.btn_7)).perform(click())
        onView(allOf(withId(R.id.result), withText("0.7"))).check(matches(isDisplayed()))
        onView(withId(R.id.btn_clear)).perform(longClick())

        //Check for decimal point separator with other numbers
        onView(allOf(withId(R.id.result), withText("0"))).check(matches(isDisplayed()))
        onView(withId(R.id.btn_1)).perform(click())
        onView(withId(R.id.btn_decimal)).perform(click())
        onView(withId(R.id.btn_5)).perform(click())
        onView(allOf(withId(R.id.result), withText("1.5"))).check(matches(isDisplayed()))
        onView(withId(R.id.btn_clear)).perform(longClick())
        onView(allOf(withId(R.id.result), withText("0"))).check(matches(isDisplayed()))

    }

    @Test
    fun test_SeparatorLogic() {

        onView(withId(R.id.btn_1)).perform(click())
        onView(withId(R.id.btn_decimal)).perform(click())
        onView(withId(R.id.btn_5)).perform(click())
        onView(allOf(withId(R.id.result), withText("1.5"))).check(matches(isDisplayed()))
        onView(withId(R.id.btn_decimal)).perform(click())
        onView(allOf(withId(R.id.result), withText("1.5"))).check(matches(isDisplayed()))
        onView(withId(R.id.btn_clear)).perform(longClick())
        onView(allOf(withId(R.id.result), withText("0"))).check(matches(isDisplayed()))

    }

    @Test
    fun test_ResultDisplaying() {
        onView(withId(R.id.btn_1)).perform(click())
        onView(withId(R.id.btn_plus)).perform(click())
        onView(withId(R.id.btn_2)).perform(click())
        onView(withId(R.id.btn_equals)).perform(click())
        onView(allOf(withId(R.id.result), withText("3"))).check(matches(isDisplayed()))
        onView(allOf(withId(R.id.formula), withText("1+2"))).check(matches(isDisplayed()))

    }
}