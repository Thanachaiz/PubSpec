package com.example.pubspecproject.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.pubspecproject.R
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import com.example.pubspecproject.ui.detailVga.DetailVgaActivity


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        val cardViewVga: CardView = root.findViewById(R.id.cardViewCPU)
        val recyclerBuildItem : RecyclerView = root.findViewById(R.id.recyclerBuildList)
        homeViewModel.text.observe(this, Observer {
//            textView.text = it

//            cardViewVga.setOnClickListener {
//                val intent = Intent(root.context, DetailVgaActivity::class.java)
//                startActivity(intent)
//                activity?.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
//            }
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


    }
}