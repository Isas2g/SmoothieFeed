package com.example.smoothiefeedapp.presentation.fragments.main_fragment

import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.view.setMargins
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.smoothiefeedapp.databinding.ItemNewsBinding
import com.example.smoothiefeedapp.presentation.items.NewsItem


class MainFragmentViewHolder(
    private val binding: ItemNewsBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: NewsItem) {
        binding.itemNewsLlFirst.removeAllViews()
        binding.itemNewsLlSecond.removeAllViews()

        Glide.with(binding.root.context)
            .load(item.news.publicPhotoUrl)
            .circleCrop()
            .into(binding.itemNewsIvPublicImage)

        binding.itemNewsTvPublicName.text = item.news.publicName

        checkItemExpanded(item)

        binding.itemNewsPostsText.setOnClickListener {
            item.isExpended = !item.isExpended
            checkItemExpanded(item)
        }

        when {
            item.news.photoUrls.size < 3 -> {
                item.news.photoUrls.forEach {
                    binding.itemNewsLlFirst.addView(createAndDownloadImage(it))
                }
            }
            item.news.photoUrls.size in 3..4 -> {
                for (index: Int in 0..item.news.photoUrls.size - 1) {
                    if (index < 2) binding.itemNewsLlFirst.addView(createAndDownloadImage(item.news.photoUrls[index]))
                    else binding.itemNewsLlSecond.addView(createAndDownloadImage(item.news.photoUrls[index]))
                }
            }
            item.news.photoUrls.size in 5..6 -> {
                for (index: Int in 0..item.news.photoUrls.size - 1) {
                    if (index < 3) binding.itemNewsLlFirst.addView(createAndDownloadImage(item.news.photoUrls[index]))
                    else binding.itemNewsLlSecond.addView(createAndDownloadImage(item.news.photoUrls[index]))
                }
            }
            item.news.photoUrls.size > 6 -> {
                for (index: Int in 0..item.news.photoUrls.size - 1) {
                    if (index < 1) binding.itemNewsLlFirst.addView(createAndDownloadImage(item.news.photoUrls[index]))
                    else binding.itemNewsLlSecond.addView(createAndDownloadImage(item.news.photoUrls[index]))
                }
            }
        }
    }

    private fun checkItemExpanded(item: NewsItem) {
        if (item.isExpended) {
            binding.itemNewsPostsText.text = item.news.text
        } else {
            if (item.news.text.isNullOrEmpty()) {
                binding.itemNewsRl.visibility = View.GONE
            } else {
                binding.itemNewsRl.visibility = View.VISIBLE
                if (item.news.text.length > 95) binding.itemNewsPostsText.text =
                    item.news.text.substring(0, 95) + "..."
                else binding.itemNewsPostsText.text = item.news.text
            }

        }
    }

    private fun createAndDownloadImage(url: String): ImageView {
        val imgView = ImageView(binding.root.context).apply {
            layoutParams =
                LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
                    .apply {
                        setMargins(8)
                    }
            scaleType = ImageView.ScaleType.FIT_XY
        }

        Glide.with(imgView)
            .load(url)
            .into(imgView)

        return imgView
    }
}