package com.hireme.resume

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hireme.R
import kotlinx.android.synthetic.main.item_resume.view.*
import kotlinx.android.synthetic.main.item_social_links_resume.view.*

/**
 * The adapter used for the resume list. It has a different item in the end of the list.
 */
class ResumeAdapter(
    private val viewModel: ResumeViewModel,
    private val resumeItems: List<ResumeItem>
) : RecyclerView.Adapter<ResumeAdapter.ViewHolder>() {

    companion object {
        private const val RESUME_ITEM_VIEW_TYPE = 0
        private const val SOCIAL_LINKS_VIEW_TYPE = 1
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindSocialLinks(
            stackoverflowClickListener: View.OnClickListener,
            linkedinClickListener: View.OnClickListener,
            githubClickListener: View.OnClickListener
        ) {
            itemView.stackoverflowImageView.setOnClickListener(stackoverflowClickListener)
            itemView.linkedinImageView.setOnClickListener(linkedinClickListener)
            itemView.githubImageView.setOnClickListener(githubClickListener)
        }

        fun bindResumeItem(resumeItem: ResumeItem, itemViewClickListener: View.OnClickListener) {
            with(resumeItem) {
                itemView.titleTextView.text = title
                itemView.datesTextView.text = dates
                itemView.descriptionTextView.text = description
                itemView.imageView.setImageResource(imageResId)
                itemView.setOnClickListener(itemViewClickListener)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position.isLast) SOCIAL_LINKS_VIEW_TYPE else RESUME_ITEM_VIEW_TYPE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutResId = if (viewType == RESUME_ITEM_VIEW_TYPE) {
            R.layout.item_resume
        } else {
            R.layout.item_social_links_resume
        }
        val view = LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = resumeItems.size + 1

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position.isLast) {
            bindSocialLinks(holder)
        } else {
            bindResumeItem(holder, position)
        }
    }

    private fun bindSocialLinks(holder: ViewHolder) {
        holder.bindSocialLinks(View.OnClickListener {
            viewModel.openStackoverflow()
        }, View.OnClickListener {
            viewModel.openLinkedin()
        }, View.OnClickListener {
            viewModel.openGithub()
        })
    }

    private fun bindResumeItem(holder: ViewHolder, position: Int) {
        val item = resumeItems[position]
        holder.bindResumeItem(item, View.OnClickListener { viewModel.openUrl(item.url) })
    }

    private val Int.isLast get() = this == resumeItems.size
}
