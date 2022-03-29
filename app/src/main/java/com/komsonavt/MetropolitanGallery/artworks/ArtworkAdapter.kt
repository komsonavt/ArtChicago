package com.komsonavt.MetropolitanGallery.artworks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.komsonavt.MetropolitanGallery.R
import com.komsonavt.MetropolitanGallery.base.AdapterDelegates
import com.komsonavt.MetropolitanGallery.base.BaseDiffUtilItemCallback
import com.komsonavt.MetropolitanGallery.base.BaseListItem
import com.komsonavt.MetropolitanGallery.databinding.ArtworkImageItemBinding
import com.komsonavt.MetropolitanGallery.descriptionMasterpiece.MasterpieceItem
import com.komsonavt.core_network.model.Artwork

//class ArtworkAdapter : AsyncListDifferDelegationAdapter<BaseListItem>(BaseDiffUtilItemCallback()) {
//    init {
//        delegatesManager.addDelegate(
//            AdapterDelegates.departmentDelegate())
//            .addDelegate(AdapterDelegates.loadShimmerDelegate)
//    }
//}

class ArtworkAdapter : PagingDataAdapter<Artwork, ArtworkViewHolder>(ArtworkDiffCallback()) {
    override fun onBindViewHolder(holder: ArtworkViewHolder, position: Int) {
        val artwork = getItem(position)
        if (artwork != null) {
            holder.bind(artwork)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtworkViewHolder {
        return ArtworkViewHolder(
            ArtworkImageItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}

class ArtworkViewHolder(
    private val binding: ArtworkImageItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    private fun navigateToMasterpiece(
        artwork: Artwork,
        view: View
    ) {
        val direction =
            ArtworkFragmentDirections.actionDepartmentsFragmentToCatalogFragment(artwork.id!!,artwork.image_id!!)
        view.findNavController().navigate(direction)
    }

    fun bind(item: Artwork) {
        binding.apply {
            binding.previewTitle.text = item.title

            val image =
                "https://www.artic.edu/iiif/2/${item.image_id}/full/200,/0/default.jpg"
            Glide.with(binding.root)
                .load("https://www.artic.edu/iiif/2/${item.image_id}/full/200,/0/default.jpg")
                .placeholder(R.drawable.no_image)
                .transform(
                    CenterCrop(), RoundedCorners(
                        binding.root.resources.getDimensionPixelOffset(
                            R.dimen.preview_image_radius
                        )
                    )
                )
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.previewImage)
        }
        binding.root?.setOnClickListener{
            navigateToMasterpiece(item, it)
        }
    }

}

private class ArtworkDiffCallback : DiffUtil.ItemCallback<Artwork>(){
    override fun areItemsTheSame(oldItem: Artwork, newItem: Artwork): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Artwork, newItem: Artwork): Boolean {
        return oldItem == newItem
    }

}
