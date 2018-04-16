package com.hireme.resume

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.hireme.R
import kotlinx.android.synthetic.main.item_social_links_resume.view.*

/**
 * The adapter used for the resume list.
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
        val linkedinImageView = itemView.linkedinImageView
        val stackoverflowImageView = itemView.stackoverflowImageView
        val githubImageView = itemView.githubImageView
    }

    override fun getItemViewType(position: Int): Int {
        return if (position.isLast) SOCIAL_LINKS_VIEW_TYPE else RESUME_ITEM_VIEW_TYPE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutResId = if (viewType == RESUME_ITEM_VIEW_TYPE) {
            android.R.layout.simple_list_item_1
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
        holder.linkedinImageView.setOnClickListener { viewModel.openLinkedin() }
        holder.stackoverflowImageView.setOnClickListener { viewModel.openStackoverflow() }
        holder.githubImageView.setOnClickListener { viewModel.openGithub() }
    }

    private fun bindResumeItem(holder: ViewHolder, position: Int) {
        (holder.itemView as TextView).text = resumeItems[position].title
    }

    private val Int.isLast get() = this == resumeItems.size
}
