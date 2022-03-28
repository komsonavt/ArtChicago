package com.komsonavt.MetropolitanGallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.komsonavt.MetropolitanGallery.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, DepartmentsFragment())
//                .commitAllowingStateLoss()
//        }
    }
}