package com.hireme

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

/**
 * My second name is Frederico, so people actually call me Fred. And I like these kinds of comments on top of classes.
 * Not really a fan of comments in the middle of the code, though, I'm with Uncle Bob on that one.
 */
class FredActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBottomNavigation()
        setupFragments()
    }

    private fun setupBottomNavigation() {
        bottomNavigationView.setOnNavigationItemSelectedListener {
            onNavigationItemSelected(it)
        }
        bottomNavigationView.setOnNavigationItemReselectedListener {}
    }

    private fun setupFragments() = with(supportFragmentManager) {
        val transaction = beginTransaction()

        if (findFragmentByTag(CoverLetterFragment.TAG) == null) {
            Timber.d("Creating and adding a new CoverLetterFragment.")
            transaction.add(
                R.id.fragmentContainer,
                CoverLetterFragment.newInstance(),
                CoverLetterFragment.TAG
            )
        }
        if (findFragmentByTag(ResumeFragment.TAG) == null) {
            Timber.d("Creating and adding a new ResumeFragment.")
            val fragment = ResumeFragment.newInstance()
            transaction.add(
                R.id.fragmentContainer,
                fragment,
                ResumeFragment.TAG
            ).hide(fragment)
        }

        transaction.commit()
    }

    private fun onNavigationItemSelected(menuItem: MenuItem) = when {
        menuItem.itemId == R.id.menu_cover_letter -> {
            Timber.i("Cover Letter selected.")
            switchFragment(CoverLetterFragment.TAG)
            true
        }
        menuItem.itemId == R.id.menu_resume -> {
            Timber.i("Resume selected.")
            switchFragment(ResumeFragment.TAG)
            true
        }
        else -> false
    }

    private fun switchFragment(newFragmentTag: String) = with(supportFragmentManager) {
        val newFragment = findFragmentByTag(newFragmentTag)
        val currentFragment = fragments.first { it.isVisible }
        beginTransaction()
            .hide(currentFragment)
            .show(newFragment)
            .commit()
    }
}
