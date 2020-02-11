package com.example.pubspecproject.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.pubspecproject.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pubspecproject.`interface`.onClickBuildListener
import com.example.pubspecproject.adapter.ItemListAdapter
import com.example.pubspecproject.model.ItemListModel
import com.example.pubspecproject.ui.detailVga.DetailVgaActivity


class HomeFragment : Fragment(), onClickBuildListener {

    private lateinit var homeViewModel: HomeViewModel
    private var itemAdapter = ItemListAdapter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        val cardViewVga: CardView = root.findViewById(R.id.cardViewCPU)
        val recyclerBuildItem : RecyclerView = root.findViewById(R.id.recyclerBuildList)

        homeViewModel.text.observe(this, Observer {
//            textView.text = it
            val result = it

//            cardViewVga.setOnClickListener {
//                val intent = Intent(root.context, DetailVgaActivity::class.java)
//                startActivity(intent)
//                activity?.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
//            }

            recyclerBuildItem.also {
                it.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                it.setHasFixedSize(true)
                it.adapter = itemAdapter
                itemAdapter.submitList(result)
            }
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    override fun onClickBuildItem(itemListModel: ItemListModel, position: Int, status: String) {
        when(status){
            "ClickSelect" ->{
                val intent = Intent(context, DetailVgaActivity::class.java)
                startActivity(intent)
                activity?.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            }
        }
    }
}