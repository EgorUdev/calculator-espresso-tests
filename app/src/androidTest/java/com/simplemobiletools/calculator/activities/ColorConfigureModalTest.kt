package com.simplemobiletools.calculator.activities

/*
* Work in progress
* Can not find solution to check colors of the view
* */

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.simplemobiletools.calculator.R
import org.hamcrest.Matchers
import org.hamcrest.Matchers.allOf
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import android.graphics.drawable.ColorDrawable
import android.widget.Button

import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.equalTo


@RunWith(AndroidJUnit4ClassRunner::class)

class ColorConfigureModalTest() {
    @get:Rule
    val activityRule = ActivityScenarioRule(SettingsActivity::class.java)

    @Test
    fun test_colorSettingUp() {
        onView(withId(R.id.settings_customize_widget_colors_label)).perform(click())
        onView(withId(R.id.config_text_color)).perform(click())
        onView(allOf(withId(R.id.color_picker_old_hex), withText("#F57C00"))).check(matches(isDisplayed()))
        onView(allOf(withId(R.id.color_picker_new_hex), withText("F57C00"))).perform(typeText("6699CC"))
        onView(allOf(withId(android.R.id.button1), withText("OK"))).perform(click())
    }
}