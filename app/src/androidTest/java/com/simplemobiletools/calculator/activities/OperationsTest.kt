package com.simplemobiletools.calculator.activities

import android.util.Log
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.longClick
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.google.android.material.internal.ContextUtils.getActivity
import com.simplemobiletools.calculator.R
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.simplemobiletools.calculator.activities.ToastMatcher.Companion.onToast


@RunWith(AndroidJUnit4ClassRunner::class)

class OperationsTest{
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_multiply() {
        onView(allOf(withId(R.id.result),withText("0"))).check(matches(isDisplayed()))
        onView(withId(R.id.btn_2)).perform(click())
        onView(withId(R.id.btn_multiply)).perform(click())
        onView(withId(R.id.btn_3)).perform(click())
        onView(withId(R.id.btn_equals)).perform(click())
        onView(allOf(withId(R.id.result),withText("6"))).check(matches(isDisplayed()))
        onView(withId(R.id.btn_clear)).perform(longClick())
        onView(allOf(withId(R.id.result),withText("0"))).check(matches(isDisplayed()))
    }

    @Test
    fun test_divide() {
        onView(withId(R.id.btn_4)).perform(click())
        onView(withId(R.id.btn_divide)).perform(click())
        onView(withId(R.id.btn_2)).perform(click())
        onView(withId(R.id.btn_equals)).perform(click())
        onView(allOf(withId(R.id.result),withText("2"))).check(matches(isDisplayed()))
        onView(withId(R.id.btn_clear)).perform(longClick())
        onView(allOf(withId(R.id.result),withText("0"))).check(matches(isDisplayed()))
    }

    @Test
    fun test_addition() {
        onView(withId(R.id.btn_4)).perform(click())
        onView(withId(R.id.btn_plus)).perform(click())
        onView(withId(R.id.btn_5)).perform(click())
        onView(withId(R.id.btn_equals)).perform(click())
        onView(allOf(withId(R.id.result),withText("9"))).check(matches(isDisplayed()))
        onView(withId(R.id.btn_clear)).perform(longClick())
        onView(allOf(withId(R.id.result),withText("0"))).check(matches(isDisplayed()))
    }

    @Test
    fun test_subtraction() {
        onView(withId(R.id.btn_5)).perform(click())
        onView(withId(R.id.btn_minus)).perform(click())
        onView(withId(R.id.btn_4)).perform(click())
        onView(withId(R.id.btn_equals)).perform(click())
        onView(allOf(withId(R.id.result),withText("1"))).check(matches(isDisplayed()))
        onView(withId(R.id.btn_clear)).perform(longClick())
        onView(allOf(withId(R.id.result),withText("0"))).check(matches(isDisplayed()))
    }

    @Test
    fun test_sequence() {
        onView(withId(R.id.btn_5)).perform(click())
        onView(withId(R.id.btn_minus)).perform(click())
        onView(withId(R.id.btn_4)).perform(click())
        onView(withId(R.id.btn_plus)).perform(click())
        onView(allOf(withId(R.id.result),withText("1+"))).check(matches(isDisplayed()))
        onView(withId(R.id.btn_1)).perform(click())
        onView(withId(R.id.btn_0)).perform(click())
        onView(withId(R.id.btn_multiply)).perform(click())
        onView(allOf(withId(R.id.result),withText("11×"))).check(matches(isDisplayed()))
        onView(withId(R.id.btn_4)).perform(click())
        onView(allOf(withId(R.id.result),withText("11×4"))).check(matches(isDisplayed()))
        onView(withId(R.id.btn_equals)).perform(click())
        onView(allOf(withId(R.id.result),withText("44"))).check(matches(isDisplayed()))
        onView(withId(R.id.btn_clear)).perform(longClick())
        onView(allOf(withId(R.id.result),withText("0"))).check(matches(isDisplayed()))
    }

    @Test
    fun test_negativeNumberInTheResult() {
        onView(withId(R.id.btn_4)).perform(click())
        onView(withId(R.id.btn_minus)).perform(click())
        onView(withId(R.id.btn_5)).perform(click())
        onView(withId(R.id.btn_equals)).perform(click())
        onView(allOf(withId(R.id.result),withText("-1"))).check(matches(isDisplayed()))
        onView(withId(R.id.btn_clear)).perform(longClick())
        onView(allOf(withId(R.id.result),withText("0"))).check(matches(isDisplayed()))
    }

    @Test
    fun test_nullInTheResult() {
        onView(withId(R.id.btn_4)).perform(click())
        onView(withId(R.id.btn_minus)).perform(click())
        onView(withId(R.id.btn_4)).perform(click())
        onView(withId(R.id.btn_equals)).perform(click())
        onView(allOf(withId(R.id.result),withText("0"))).check(matches(isDisplayed()))
        onView(withId(R.id.btn_clear)).perform(longClick())
        onView(allOf(withId(R.id.result),withText("0"))).check(matches(isDisplayed()))
    }

    @Test
    fun test_notAnIntegerInTheResult() {
        onView(withId(R.id.btn_4)).perform(click())
        onView(withId(R.id.btn_minus)).perform(click())
        onView(withId(R.id.btn_2)).perform(click())
        onView(withId(R.id.btn_decimal)).perform(click())
        onView(withId(R.id.btn_2)).perform(click())
        onView(withId(R.id.btn_equals)).perform(click())
        onView(allOf(withId(R.id.result),withText("1.8"))).check(matches(isDisplayed()))
        onView(withId(R.id.btn_clear)).perform(longClick())
        onView(allOf(withId(R.id.result),withText("0"))).check(matches(isDisplayed()))
    }

    @Test
    fun test_divideZero() {

/*
*   This test will fail if device runs Android 11, targetSdkVersion = 30 and compileSdkVersion 30.
*   targetSDK and compileSdk are lowered tp 29 because of it.
*   Link to original bug report https://github.com/android/android-test/issues/803
* */
        onView(withId(R.id.btn_4)).perform(click())
        onView(withId(R.id.btn_divide)).perform(click())
        onView(withId(R.id.btn_0)).perform(click())
        onView(withId(R.id.btn_equals)).perform(click())
        onToast(R.string.formula_divide_by_zero_error).check(matches(isDisplayed()))
        onView(withId(R.id.btn_clear)).perform(longClick())
        onView(allOf(withId(R.id.result),withText("0"))).check(matches(isDisplayed()))
    }

    @Test
    fun test_errorOccurred() {

/*
*   This test will fail if device runs Android 11, targetSdkVersion = 30 and compileSdkVersion 30.
*   targetSDK and compileSdk are lowered tp 29 because of it.
*   Link to original bug report https://github.com/android/android-test/issues/803
* */
        onView(withId(R.id.btn_4)).perform(click())
        onView(withId(R.id.btn_divide)).perform(click())
        onView(withId(R.id.btn_0)).perform(click())
        onView(withId(R.id.btn_decimal)).perform(click())
        onView(withId(R.id.btn_0)).perform(click())
        onView(withId(R.id.btn_0)).perform(click())
        onView(withId(R.id.btn_0)).perform(click())
        onView(withId(R.id.btn_0)).perform(click())
        onView(withId(R.id.btn_0)).perform(click())
        onView(withId(R.id.btn_0)).perform(click())
        onView(withId(R.id.btn_0)).perform(click())
        onView(withId(R.id.btn_0)).perform(click())
        onView(withId(R.id.btn_0)).perform(click())
        onView(withId(R.id.btn_0)).perform(click())
        onView(withId(R.id.btn_0)).perform(click())
        onView(withId(R.id.btn_0)).perform(click())
        onView(withId(R.id.btn_0)).perform(click())
        onView(withId(R.id.btn_1)).perform(click())
        onView(withId(R.id.btn_equals)).perform(click())
        onToast(R.string.unknown_error_occurred).check(matches(isDisplayed()))
        onView(withId(R.id.btn_clear)).perform(longClick())
        onView(allOf(withId(R.id.result),withText("0"))).check(matches(isDisplayed()))
    }

/*
    @Test
    fun test_errorOccurred1() {
        var resultReached = true
        var i = 0
        val requiredZeros = "0.0000000000000"

        onView(withId(R.id.btn_4)).perform(click())
        onView(withId(R.id.btn_divide)).perform(click())
        onView(withId(R.id.btn_0)).perform(click())
        onView(withId(R.id.btn_decimal)).perform(click())

        try {
            onView(withId(R.id.btn_0)).perform(click())
            i++
        } catch (e: Exception) {
            resultReached = false
        }
        while (resultReached) {
            try {
                onView(withId(R.id.btn_0)).perform(click())
                i++
            } catch (e: Exception) {
                resultReached = false
            }
        }

        i= 0
        resultReached = true

        onView(allOf(withId(R.id.result),withText(requiredZeros))).check(matches(isDisplayed()))
        onView(withId(R.id.btn_1)).perform(click())

    }
*/
}
