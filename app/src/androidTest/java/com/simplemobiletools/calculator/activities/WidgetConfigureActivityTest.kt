package com.simplemobiletools.calculator.activities

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.simplemobiletools.calculator.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.hamcrest.Matchers.allOf
import androidx.test.espresso.action.Press

import android.widget.SeekBar

import androidx.test.espresso.action.CoordinatesProvider

import androidx.test.espresso.action.Tap

import androidx.test.espresso.action.GeneralClickAction




@RunWith(AndroidJUnit4ClassRunner::class)

class WidgetConfigureActivityTest(){

    @get:Rule
    val activityRule = ActivityScenarioRule(SettingsActivity::class.java)

    @Test
    fun test_viewsAreVisible() {
        onView(withId(R.id.settings_customize_widget_colors_label)).perform(click())
        onView(withId(R.id.config_calc)).check(matches(isDisplayed()))
        onView(withId(R.id.config_bg_color)).check(matches(isDisplayed()))
        onView(allOf(withId(R.id.config_bg_seekbar_holder), withChild(withId(R.id.config_bg_seekbar))))
            .check(matches(isDisplayed()))
        onView(withId(R.id.config_text_color)).check(matches(isDisplayed()))
        onView(withId(R.id.config_save)).check(matches(isDisplayed()))
    }

    @Test
    fun test_launchAndVisibilityOfConfigs() {
        //Launch
        onView(withId(R.id.settings_customize_widget_colors_label)).perform(click())
        onView(withId(R.id.config_bg_color)).perform(click())

        //Check visibility of background color config views
        onView(withId(R.id.color_picker_square)).check(matches(isDisplayed()))
        onView(withId(R.id.color_picker_hue)).check(matches(isDisplayed()))
        onView(allOf(withId(R.id.color_picker_old_hex), withText("#000000"))).check(matches(isDisplayed()))
        onView(withId(R.id.color_picker_hex_arrow)).check(matches(isDisplayed()))
        onView(allOf(withId(R.id.color_picker_new_hex_label), withText("#"))).check(matches(isDisplayed()))
        onView(allOf(withId(R.id.color_picker_new_hex), withText("000000"))).check(matches(isDisplayed()))
        onView(withId(R.id.color_picker_old_color)).check(matches(isDisplayed()))
        onView(withId(R.id.color_picker_arrow)).check(matches(isDisplayed()))
        onView(withId(R.id.color_picker_new_color)).check(matches(isDisplayed()))
        onView(allOf(withId(android.R.id.button2), withText("CANCEL"))).check(matches(isDisplayed()))
        onView(allOf(withId(android.R.id.button1), withText("OK"))).check(matches(isDisplayed()))

        //Return to widget config screen and check if it is displayed
        onView(allOf(withId(android.R.id.button1), withText("OK"))).perform(click())
        onView(withId(R.id.settings_customize_widget_colors_label)).perform(click())
        onView(withId(R.id.config_calc)).check(matches(isDisplayed()))
        onView(withId(R.id.config_bg_color)).check(matches(isDisplayed()))
        onView(allOf(withId(R.id.config_bg_seekbar_holder), withChild(withId(R.id.config_bg_seekbar))))
            .check(matches(isDisplayed()))
        onView(withId(R.id.config_text_color)).check(matches(isDisplayed()))
        onView(withId(R.id.config_save)).check(matches(isDisplayed()))
    }

    @Test
    fun test_seekbar() {
        onView(withId(R.id.settings_customize_widget_colors_label)).perform(click())
        onView(withId( R.id.config_bg_seekbar)).perform(clickSeekBar(10))


    }
    fun clickSeekBar(pos: Int): ViewAction? {
        return GeneralClickAction(
            Tap.SINGLE,
            { view ->
                val seekBar = view as SeekBar
                val screenPos = IntArray(2)
                seekBar.getLocationOnScreen(screenPos)

                // get the width of the actual bar area
                // by removing padding
                val trueWidth = (seekBar.width
                        - seekBar.paddingLeft - seekBar.paddingRight)

                // what is the position on a 0-1 scale
                //  add 0.3f to avoid roundoff to the next smaller position
                var relativePos = (0.3f + pos) / seekBar.max.toFloat()
                if (relativePos > 1.0f) relativePos = 1.0f

                // determine where to click
                val screenX = (trueWidth * relativePos + screenPos[0]
                        + seekBar.paddingLeft)
                val screenY = seekBar.height / 2f + screenPos[1]
                floatArrayOf(screenX, screenY)
            },
            Press.FINGER
        )
    }
}