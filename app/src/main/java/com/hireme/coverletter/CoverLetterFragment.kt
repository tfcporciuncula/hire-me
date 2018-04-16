package com.hireme.coverletter

import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.graphics.Palette
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hireme.R
import kotlinx.android.synthetic.main.fragment_cover_letter.*

class CoverLetterFragment : Fragment(), CoverLetter.View {

    companion object {
        val TAG: String = CoverLetterFragment::class.java.name

        fun newInstance() = CoverLetterFragment()
    }

    // Dagger would make things prettier here
    private val presenter: CoverLetter.Presenter by lazy {
        CoverLetterPresenter(this, CoverLetterRepository(context!!))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_cover_letter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupHireMeButtonAnimation()
        setContentScrimColor()

        presenter.loadCoverLetter()
    }

    private fun setupHireMeButtonAnimation() {
        appBarLayout.addOnOffsetChangedListener { appBarLayout, verticalOffset ->
            val percentCollapsed = Math.abs(verticalOffset).toDouble() / appBarLayout.totalScrollRange

            if (percentCollapsed >= 0.80) {
                hireMeButton.fadeOut()
            } else {
                hireMeButton.fadeIn()
            }
        }
    }

    override fun showCoverLetter(coverLetterContent: String) {
        coverLetterTextView.text = coverLetterContent
    }

    private fun setContentScrimColor() {
        val defaultScrimColor = ContextCompat.getColor(context!!, R.color.colorAccent)
        val bitmap = (pictureImageView.drawable as BitmapDrawable).bitmap
        Palette.from(bitmap).generate {
            collapsingToolbarLayout.setContentScrimColor(it.getMutedColor(defaultScrimColor))
        }
    }
}

private fun View.fadeOut() {
    animation?.cancel()
    animate()
        .alpha(0f)
        .withStartAction { tag = "startedFadingOut" }
        .withEndAction { visibility = View.GONE }
        .start()
}

private fun View.fadeIn() {
    if (tag != "startedFadingOut") return

    animation?.cancel()
    animate()
        .alpha(1f)
        .withStartAction {
            tag = null
            visibility = View.VISIBLE
        }
        .start()
}
