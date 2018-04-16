package com.hireme

import android.app.Activity
import android.content.pm.ActivityInfo
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import junit.framework.Assert.assertEquals
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Espresso!
 */
@RunWith(AndroidJUnit4::class)
class BottomNavigationTest {

    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun shouldShowTwoNavigationItems() {
        onView(withId(R.id.menu_cover_letter)).check(matches(isDisplayed()))
        onView(withId(R.id.menu_resume)).check(matches(isDisplayed()))
    }

    @Test
    fun shouldMaintainStateOnOrientationChange() {
        onView(withText("Hire me!")).check(matches(isDisplayed()))
        onView(withId(R.id.menu_resume)).perform(click())
        onView(withText("Hire me!")).check(matches(not(isDisplayed())))
        activityTestRule.rotateScreen()
        onView(withText("Hire me!")).check(matches(not(isDisplayed())))
    }

    @Test
    fun shouldAlwaysHaveOnlyTwoFragmentsLoaded() {
        fun assertOnlyTwoFragments() {
            assertEquals(2, activityTestRule.activity.supportFragmentManager.fragments.size)
        }

        assertOnlyTwoFragments()

        onView(withId(R.id.menu_resume)).perform(click())
        assertOnlyTwoFragments()

        onView(withId(R.id.menu_cover_letter)).perform(click())
        assertOnlyTwoFragments()

        activityTestRule.rotateScreen()
        assertOnlyTwoFragments()

        onView(withId(R.id.menu_resume)).perform(click())
        assertOnlyTwoFragments()
    }
}

private fun <T : Activity> ActivityTestRule<T>.rotateScreen() {
    activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    InstrumentationRegistry.getInstrumentation().waitForIdleSync()
}
