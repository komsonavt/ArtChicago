package com.komsonavt.MetropolitanGallery.catalog

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.komsonavt.MetropolitanGallery.R
import com.komsonavt.MetropolitanGallery.databinding.CatalogFragmentBinding
import com.komsonavt.MetropolitanGallery.di.CatalogComponent
import com.komsonavt.MetropolitanGallery.viewBinding

class CatalogFragment : Fragment(R.layout.catalog_fragment) {
//    private val args : CatalogFragmentArgs by navArgs()
    private val component by lazy { CatalogComponent.create() }
    private val binding by viewBinding { CatalogFragmentBinding.bind(it) }
    private val adapter = CatalogAdapter()
    private val viewModel by viewModels<CatalogViewModel> { component.viewModelFactory() }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val departmentId = 1 //TODO

        with(binding){
            catalog.adapter = adapter
            lifecycleScope.launchWhenResumed {
//                    viewModel.catalogData(args.departmentId).collectLatest {
//                        adapter.addValue(it)
//                    }
                }
//
                viewModel.catalogLiveData.observe(viewLifecycleOwner, Observer {
                    adapter.items = it
                })
            }
        }
}