package com.komsonavt.MetropolitanGallery.fullScreenImage

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.komsonavt.MetropolitanGallery.R
import com.komsonavt.MetropolitanGallery.databinding.FullScreenImageFragmentBinding
import com.komsonavt.MetropolitanGallery.viewBinding

class FullScreenImageFragment : Fragment(R.layout.full_screen_image_fragment) {
    private val args: FullScreenImageFragmentArgs by navArgs()
    private val binding by viewBinding { FullScreenImageFragmentBinding.bind(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(binding.root)
            .load("https://www.artic.edu/iiif/2/${args.imageUrl}/full/600,/0/default.jpg")
            .placeholder(R.drawable.no_image)
            .transform(
                CenterCrop(), RoundedCorners(
                    binding.root.resources.getDimensionPixelOffset(
                        R.dimen.preview_image_radius
                    )
                )
            )
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.fullScreenImage)

        binding.fullScreenImage.setOnLongClickListener() {
                view ->
            view.findNavController().navigateUp()
        }
    }
}