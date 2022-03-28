package com.komsonavt.MetropolitanGallery.artworks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.komsonavt.MetropolitanGallery.R
import com.komsonavt.MetropolitanGallery.databinding.ArtworkFragmentBinding
import com.komsonavt.MetropolitanGallery.di.ArtworkComponent
import com.komsonavt.MetropolitanGallery.viewBinding
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest

class ArtworkFragment : Fragment(R.layout.artwork_fragment) {
    private val component by lazy {ArtworkComponent.create() }
    private val binding by viewBinding { ArtworkFragmentBinding.bind(it) }
    private val adapter = ArtworkAdapter()
    private val viewModel by viewModels<ArtworkViewModel> { component.viewModelFactory() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            departmentList.adapter = adapter
            lifecycleScope.launchWhenResumed {
                viewModel.getItems().collectLatest {
                    adapter.submitData(it)
                }
            }
        }
    }

}