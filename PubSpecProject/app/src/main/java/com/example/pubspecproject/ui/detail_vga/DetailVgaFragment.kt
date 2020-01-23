package com.example.pubspecproject.ui.detail_vga

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pubspecproject.R

class DetailVgaFragment : Fragment() {

    companion object {
        fun newInstance() = DetailVgaFragment()
    }

    private lateinit var viewModel: DetailVgaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.detail_vga_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetailVgaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
