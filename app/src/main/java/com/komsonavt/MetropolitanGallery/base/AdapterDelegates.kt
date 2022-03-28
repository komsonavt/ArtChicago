package com.komsonavt.MetropolitanGallery.base

import android.app.Activity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.komsonavt.MetropolitanGallery.R
import com.komsonavt.MetropolitanGallery.catalog.CatalogItem
import com.komsonavt.MetropolitanGallery.databinding.CatalogImageItemBinding
import com.komsonavt.MetropolitanGallery.databinding.ArtworkImageItemBinding
import com.komsonavt.MetropolitanGallery.databinding.ProgressShimmerItemBinding
import com.komsonavt.MetropolitanGallery.artworks.ArtworkItem

object AdapterDelegates {

    fun departmentDelegate() = adapterDelegateViewBinding<ArtworkItem, BaseListItem, ArtworkImageItemBinding>(
        {inflater, container -> ArtworkImageItemBinding.inflate(inflater, container, false)}
    ){
        bind {
            binding.previewTitle.text = item.title

            val image = "https://www.artic.edu/iiif/2/${item.image_id}/full/200,/0/default.jpg"
            Glide.with(binding.root)
                .load("https://www.artic.edu/iiif/2/${item.image_id}/full/200,/0/default.jpg")
                .placeholder(R.drawable.no_image)
                .transform(CenterCrop(), RoundedCorners(binding.root.resources.getDimensionPixelOffset(R.dimen.preview_image_radius)))
                .transition(withCrossFade())
                .into(binding.previewImage)
        }

        onViewRecycled {
            if((binding.root.context as? Activity?)?.isDestroyed?.not() == true)
            Glide.with(binding.root).clear(binding.previewImage)
        }
    }

    val loadShimmerDelegate = adapterDelegateViewBinding<ProgressShimmerItem, BaseListItem, ProgressShimmerItemBinding>(
        {inflater, container -> ProgressShimmerItemBinding.inflate(inflater, container, false)}
    ){}

    fun catalogDelegates() = adapterDelegateViewBinding<CatalogItem, BaseListItem, CatalogImageItemBinding>(
        {inflater, container -> CatalogImageItemBinding.inflate(inflater, container, false)}
    ){
        bind {
            binding.previewTitle.text = item.title
            binding.year.text = item.year
            Glide.with(binding.root)
                .load(item.image)
                .placeholder(R.drawable.no_image)
                .transform(CenterCrop(), RoundedCorners(binding.root.resources.getDimensionPixelOffset(R.dimen.preview_image_radius)))
                .transition(withCrossFade())
                .into(binding.previewImage)
        }

        onViewRecycled {
            if((binding.root.context as? Activity?)?.isDestroyed?.not() == true)
                Glide.with(binding.root).clear(binding.previewImage)
        }
    }
}