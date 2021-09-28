package com.simplemobiletools.calculator.activities

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.simplemobiletools.calculator.R
import com.simplemobiletools.calculator.R.string.customize_colors
import org.hamcrest.Matchers.allOf
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SettingsActivityTest{
    @get:Rule
    val activityRule = ActivityScenarioRule(SettingsActivity::class.java)

    @Test
    fun test_isDataVisible() {
        onView(allOf(withId(R.id.settings_purchase_thank_you), withText(R.string.purchase_simple_thank_you))).check(matches(isDisplayed()))
        onView(allOf(withId(R.id.settings_customize_colors_label), withText(R.string.customize_colors_locked))).check(matches(isDisplayed()))
        onView(allOf(withId(R.id.settings_customize_widget_colors_label), withText(R.string.customize_widget_colors))).check(matches(isDisplayed()))
        onView(allOf(withId(R.id.settings_vibrate_holder), withChild((allOf(withId(R.id.settings_vibrate),
            withText(R.string.vibrate_on_button_press))))))
            .check(matches(isDisplayed()))
        onView(allOf(withId(R.id.settings_prevent_phone_from_sleeping_holder), withChild((allOf(withId(R.id.settings_prevent_phone_from_sleeping),
            withText(R.string.prevent_phone_from_sleeping))))))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_vibrateToggleOff() {
        onView(allOf(withId(R.id.settings_vibrate), withText(R.string.vibrate_on_button_press)))
            .check(matches(isChecked()))
        onView(allOf(withId(R.id.settings_vibrate), withText(R.string.vibrate_on_button_press)))
            .perform(click())
        onView(allOf(withId(R.id.settings_vibrate), withText(R.string.vibrate_on_button_press)))
            .check(matches(isNotChecked()))
        onView(allOf(withId(R.id.settings_vibrate), withText(R.string.vibrate_on_button_press)))
            .perform(click())
        onView(allOf(withId(R.id.settings_vibrate), withText(R.string.vibrate_on_button_press)))
            .check(matches(isChecked()))
    }

    @Test
    fun test_preventiveToggleOff() {
        onView(allOf(withId(R.id.settings_prevent_phone_from_sleeping), withText(R.string.prevent_phone_from_sleeping)))
            .check(matches(isChecked()))
        onView(allOf(withId(R.id.settings_prevent_phone_from_sleeping), withText(R.string.prevent_phone_from_sleeping)))
            .perform(click())
        onView(allOf(withId(R.id.settings_prevent_phone_from_sleeping), withText(R.string.prevent_phone_from_sleeping)))
            .check(matches(isNotChecked()))
        onView(allOf(withId(R.id.settings_prevent_phone_from_sleeping), withText(R.string.prevent_phone_from_sleeping)))
            .perform(click())
        onView(allOf(withId(R.id.settings_prevent_phone_from_sleeping), withText(R.string.prevent_phone_from_sleeping)))
            .check(matches(isChecked()))
    }
}