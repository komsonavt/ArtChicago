package com.komsonavt.MetropolitanGallery.base

import androidx.recyclerview.widget.DiffUtil

class BaseDiffUtilItemCallback : DiffUtil.ItemCallback<BaseListItem>() {
    override fun areItemsTheSame(oldItem: BaseListItem, newItem: BaseListItem): Boolean {
        return oldItem.itemId == newItem.itemId
    }

    override fun areContentsTheSame(oldItem: BaseListItem, newItem: BaseListItem): Boolean {
        return oldItem.equals(newItem)
    }
}