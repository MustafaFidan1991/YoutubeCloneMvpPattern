package com.mustafafidan.youtubeclonemvppattern.ui.home


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mustafafidan.youtubeclonemvppattern.BR

import com.mustafafidan.youtubeclonemvppattern.R
import com.mustafafidan.youtubeclonemvppattern.base.BaseAdapter
import com.mustafafidan.youtubeclonemvppattern.base.BaseFragment
import com.mustafafidan.youtubeclonemvppattern.databinding.FragmentHomeBinding
import com.mustafafidan.youtubeclonemvppattern.model.Video
import java.util.ArrayList

class HomeFragment : BaseFragment<HomePresenter>(),HomeView {


    private lateinit var binding: FragmentHomeBinding


    override fun setVideos(videList: List<Video>) {
        binding.adapter!!.update(videList)
    }

    override fun showLoading() {

        binding.progressBar.visibility = View.VISIBLE
        binding.recyclerView.visibility = View.GONE
    }

    override fun hideLoading() {
        binding.progressBar.visibility = View.GONE
        binding.recyclerView.visibility = View.VISIBLE
    }


    override fun instantiatePresenter(): HomePresenter {
        return HomePresenter(this)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding  = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        binding.adapter = BaseAdapter(ArrayList<Video>(),activity!!.baseContext,R.layout.fragment_home_item, BR.video,presenter, BR.presenter)
        binding.layoutManager = LinearLayoutManager(activity)
        binding.dividerItemDecoration = DividerItemDecoration(activity, LinearLayoutManager.VERTICAL)



        presenter.getVideos()

        return binding.root
    }


}
