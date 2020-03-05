package com.example.pubspecproject.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.pubspecproject.R
import com.example.pubspecproject.model.CpuBuild
import com.example.pubspecproject.model.VgaBuild
import com.example.pubspecproject.ui.detailCpu.DetailCpuActivity
import com.example.pubspecproject.ui.detailVga.DetailVgaActivity
import kotlinx.android.synthetic.main.fragment_home.*




class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        return root
    }

    override fun onStart() {
        super.onStart()
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val nameObserverCpu = Observer<CpuBuild> { newName ->
            // Update the UI
            text_name_cpu.text = newName.name_cpu
            text_price_cpu.text = newName.price_cpu.toString()

            Glide.with(context!!)
                .load(newName.image_cpu)
                .into(image_cpu_build)
        }

        homeViewModel.updateBuildCpu().observe(this, nameObserverCpu)
        val nameObserverVga = Observer<VgaBuild> { newName ->
            // Update the UI
            text_name_vga.text = newName.name_vga
            text_price_vga.text = newName.price_vga.toString()

            Glide.with(context!!)
                .load(newName.image_vga)
                .into(image_vga_build)
        }

        homeViewModel.updateBuildVga().observe(this, nameObserverVga)

        val totalPriceObserver = Observer<HashMap<String, Int?>> { newName ->
            // Update the UI

            totalPrice(newName)
        }
        homeViewModel.callTotalPrice().observe(this, totalPriceObserver)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        cardViewCpu.setOnClickListener {
            val intent = Intent(context, DetailCpuActivity::class.java)
            intent.putExtra("Cpu Name", "CpuDetail")
            startActivityIntent(intent, 1)
        }

        cardViewVga.setOnClickListener {
            val intent = Intent(context, DetailVgaActivity::class.java)
            intent.putExtra("Vga Name", "VgaDetail")
            startActivityIntent(intent, 2)
        }
    }

    private fun startActivityIntent(intent : Intent, requestCode: Int){
        startActivityForResult(intent, requestCode)
        activity?.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        homeViewModel.onActivityResult(requestCode, resultCode, data)
    }

    private fun totalPrice(priceItem: HashMap<String, Int?>){
        var pCpu = 0
        var pVga = 0

        if (priceItem["priceCpu"] != null){
            pCpu = priceItem["priceCpu"]!!
        }
        if (priceItem["priceVga"] != null){
            pVga = priceItem["priceVga"]!!
        }

        val totalPrice = pCpu + pVga

        total_price.text = totalPrice.toString()
    }


    companion object{
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}