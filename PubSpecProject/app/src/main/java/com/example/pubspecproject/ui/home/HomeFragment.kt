package com.example.pubspecproject.ui.home

import android.app.Activity.RESULT_CANCELED
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.pubspecproject.R
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pubspecproject.ui.detailCpu.DetailCpuActivity
import com.example.pubspecproject.ui.detailVga.DetailVgaActivity
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
//    private var itemAdapter = ItemListAdapter()
    private lateinit var root : View
    private lateinit var recyclerBuildItem : RecyclerView
    private var listPrice = HashMap<String, Int>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater.inflate(R.layout.fragment_home, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

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
        if (requestCode == 1){

            if (resultCode == RESULT_OK){
                val nameCpu = data?.getStringExtra("name_cpu")
                val imageCpu = data?.getStringExtra("image_cpu")
                val priceCpu = data!!.getIntExtra("price_cpu", 0)

                text_name_cpu.text = nameCpu
                text_price_cpu.text = priceCpu.toString()

                Glide.with(context!!)
                    .load(imageCpu)
                    .into(image_cpu_build)


                listPrice["priceCpu"] = priceCpu

            }
            if (resultCode == RESULT_CANCELED){
                //NOTHING
            }
        }
        if (requestCode == 2){

            if (resultCode == RESULT_OK){
                val nameVga = data?.getStringExtra("name_vga")
                val imageVga = data?.getStringExtra("image_vga")
                val priceVga = data!!.getIntExtra("price_vga", 0)

                text_name_vga.text = nameVga
                text_price_vga.text = priceVga.toString()

                Glide.with(context!!)
                    .load(imageVga)
                    .into(image_vga_build)

                listPrice["priceVga"] = priceVga
            }
            if (resultCode == RESULT_CANCELED){
                //NOTHING
            }
        }

        totalPrice(listPrice)
    }

    private fun totalPrice(priceItem: HashMap<String, Int>){
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
}