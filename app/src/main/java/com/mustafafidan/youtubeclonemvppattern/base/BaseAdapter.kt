package com.mustafafidan.youtubeclonemvppattern.base

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class BaseAdapter<T : BaseModel>(
        internal var entityList: List<T>,
        internal var context: Context,
        internal var viewId: Int,
        internal var dataId: Int,
        internal var presenter: BasePresenter<*>,
        internal var viewModelId: Int
) : RecyclerView.Adapter<BaseAdapter.BaseViewHolder<T>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(parent!!.context), viewId, parent, false)
        return BaseViewHolder<T>(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder!!.bindto(entityList[position], dataId, viewModelId, presenter)
    }


    override fun getItemCount(): Int {
        return entityList.size
    }


    fun update(entityList:List<T>) {
        this.entityList = entityList
        notifyDataSetChanged()
    }


    fun getList() : List<T> {
        return entityList
    }


    class BaseViewHolder<T : BaseModel>(internal var binding: android.databinding.ViewDataBinding) : android.support.v7.widget.RecyclerView.ViewHolder(binding.getRoot()) {
        fun bindto(data: T?, dataId: Int, viewModelId: Int, presenter: BasePresenter<*>) {
            if (data != null) binding.setVariable(dataId, data)
            if (presenter != null) binding.setVariable(viewModelId, presenter)
            binding.executePendingBindings()

        }
    }

}