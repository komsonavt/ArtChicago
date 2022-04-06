package com.komsonavt.MetropolitanGallery.descriptionMasterpiece

import android.R.attr.delay
import android.animation.ValueAnimator
import android.app.Activity
import android.graphics.drawable.Animatable2
import android.graphics.drawable.Animatable2.AnimationCallback
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.vectordrawable.graphics.drawable.Animatable2Compat
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.komsonavt.MetropolitanGallery.R
import com.komsonavt.MetropolitanGallery.artworks.ArtworkFragmentDirections
import com.komsonavt.MetropolitanGallery.artworks.ArtworkFragmentDirections.Companion.actionDepartmentsFragmentToCatalogFragment
import com.komsonavt.MetropolitanGallery.databinding.DescriptionMasterpieceFragmentBinding
import com.komsonavt.MetropolitanGallery.di.MasterpieceComponent
import com.komsonavt.MetropolitanGallery.viewBinding
import kotlinx.coroutines.flow.collectLatest


class MasterpieceFragment : Fragment(R.layout.description_masterpiece_fragment) {

    private val args: MasterpieceFragmentArgs by navArgs()
    private val component by lazy {
        MasterpieceComponent.create(
            args.masterpieceId,
            args.imageGUID
        )
    }
    private val binding by viewBinding { DescriptionMasterpieceFragmentBinding.bind(it) }
    private val viewModel by viewModels<MasterpieceViewModel> { component.viewModelFactory() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViews()
        setupListeners()
    }

    private fun setupViews() {
        lifecycleScope.launchWhenResumed {
            viewModel.masterpieceData.collectLatest { masterpiece ->
                binding.toolbarLayout.title = masterpiece.name
                binding.name.text = masterpiece.name
                binding.startCreationYear.text = masterpiece.startYear
                binding.endCreationYear.text = masterpiece.endYear
                binding.yearBye.text = masterpiece.yearCreate
                binding.manifest.text = masterpiece.manifest?.description?.get(0)?.string

                Glide.with(binding.root)
                    .load("https://www.artic.edu/iiif/2/${masterpiece.image}/full/200,/0/default.jpg")
                    .placeholder(R.drawable.no_image)
                    .transform(
                        CenterCrop(), RoundedCorners(
                            binding.root.resources.getDimensionPixelOffset(
                                R.dimen.preview_image_radius
                            )
                        )
                    )
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(binding.detailImage)

                binding.detailImage.setOnClickListener {
                    val direction =
                        MasterpieceFragmentDirections.actionDescriptionFragmentToFullScreenFragment(masterpiece.image!!)
                    it.findNavController().navigate(direction)
                }
            }
        }
    }

    private fun setupListeners() {
        binding.toolbar.setNavigationOnClickListener { view ->
            view.findNavController().navigateUp()
        }
        var isToolbarShown = false
        binding.masterpieceDetailScrollview.setOnScrollChangeListener(
            NestedScrollView.OnScrollChangeListener { _, _, scrollY, _, _ ->

                val shouldShowToolbar = scrollY > binding.toolbar.height

                if (isToolbarShown != shouldShowToolbar) {


                    isToolbarShown = shouldShowToolbar
                    if(isToolbarShown){
                        val anim = binding.toolbar.navigationIcon as AnimatedVectorDrawable
                        anim.start()
                        binding.toolbar.setNavigationIcon(R.drawable.ic_back_anim_reverse)
                    }
                    else{
                        val anim = binding.toolbar.navigationIcon as AnimatedVectorDrawable
                        anim.start()
                        binding.toolbar.setNavigationIcon(R.drawable.ic_back_anim)
                    }
                    binding.appbar.isActivated = shouldShowToolbar
                    binding.toolbarLayout.isTitleEnabled = shouldShowToolbar
                }
            })

    }
}