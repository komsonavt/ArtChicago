package com.komsonavt.MetropolitanGallery.catalog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.komsonavt.MetropolitanGallery.R
import com.komsonavt.MetropolitanGallery.base.AdapterDelegates
import com.komsonavt.MetropolitanGallery.base.BaseDiffUtilItemCallback
import com.komsonavt.MetropolitanGallery.base.BaseListItem

class CatalogAdapter: AsyncListDifferDelegationAdapter<BaseListItem>(BaseDiffUtilItemCallback()) {
    init {
        delegatesManager.addDelegate(
            AdapterDelegates.departmentDelegate()
        )
            .addDelegate(AdapterDelegates.loadShimmerDelegate)
    }
}

//
//class CatalogAdapter : ListAdapter<CatalogItem, CatalogViewHolder>(CatalogDiffCallback()) {
//    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
//        val masterpiece = getItem(position)
//        if (masterpiece != null) {
//            holder.bind(masterpiece)
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
//        return CatalogViewHolder(
//            CatalogImageItemBinding.inflate(
//                LayoutInflater.from(parent.context), parent, false
//            )
//        )
//    }
//
//    fun addValue(catalogItem: CatalogItem){
//        notifyItemChanged(this.itemCount +1, catalogItem)
//        notifyDataSetChanged()
//    }
//}
//
//class CatalogViewHolder(private val binding: CatalogImageItemBinding
//) : RecyclerView.ViewHolder(binding.root) {
//
//    fun bind(item : CatalogItem) {
//        binding.previewTitle.text = item.title
//        binding.year.text = item.year
//        Glide.with(binding.root)
//            .load(item.image)
//            .placeholder(R.drawable.no_image)
//            .transform(CenterCrop(), RoundedCorners(binding.root.resources.getDimensionPixelOffset(R.dimen.preview_image_radius)))
//            .transition(DrawableTransitionOptions.withCrossFade())
//            .into(binding.previewImage)
//    }
//}
//
//private class CatalogDiffCallback : DiffUtil.ItemCallback<CatalogItem>() {
//    override fun areItemsTheSame(oldItem: CatalogItem, newItem: CatalogItem): Boolean {
//        return oldItem.id == newItem.id
//    }
//
//    override fun areContentsTheSame(oldItem: CatalogItem, newItem: CatalogItem): Boolean {
//        return oldItem == newItem
//    }
//}

