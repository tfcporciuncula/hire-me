package com.hireme.coverletter

import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Html
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.hireme.HireMeApplication
import com.hireme.R
import kotlinx.android.synthetic.main.fragment_cover_letter.*
import javax.inject.Inject

/**
 * A fragment with a nice collapsing toolbar. And my cover letter.
 */
class CoverLetterFragment : Fragment(), CoverLetter.View {

    companion object {
        val TAG: String = CoverLetterFragment::class.java.name

        fun newInstance() = CoverLetterFragment()
    }

    @Inject
    lateinit var presenter: CoverLetter.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        HireMeApplication
            .getComponent(requireContext())
            .plus(CoverLetterModule(this))
            .inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_cover_letter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupHireMeButtonAnimation()
        loadImages()

        presenter.loadCoverLetter()
        hireMeButton.setOnClickListener { presenter.startYouAreHiredEmail() }
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

    private fun loadImages() {
        Glide.with(this).load(R.drawable.desk).into(pictureImageView)
        Glide.with(this).load(R.drawable.signature).into(signatureImageView)
    }

    override fun showCoverLetter(coverLetterContent: String) {
        coverLetterTextView.text = coverLetterContent.fromHtml()
        coverLetterTextView.movementMethod = LinkMovementMethod.getInstance()
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

private fun String.fromHtml(): Spanned {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(this, Html.FROM_HTML_MODE_COMPACT)
    } else {
        Html.fromHtml(this)
    }
}
