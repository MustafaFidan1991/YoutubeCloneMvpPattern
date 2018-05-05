// Safe here as method are used by Data binding
@file:Suppress("unused")

package com.mustafafidan.youtubeclonemvppattern.utils

import android.databinding.BindingAdapter
import android.graphics.Bitmap
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory
import android.support.v7.app.ActionBar
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.bumptech.glide.signature.StringSignature
import com.mustafafidan.youtubeclonemvppattern.base.BaseAdapter

/**
 * Sets an adapter to a RecyclerView (to be used in view with one RecyclerView)
 * @param view the RecyclerView on which to set the adapter
 * @param adapter the adapter to set to the RecyclerView
 */
@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: BaseAdapter<*>) {
    view.adapter = adapter
}

/**
 * Sets a LayoutManager to a RecyclerView (to be used in view with one RecyclerView)
 * @param view the RecyclerView on which to set the LayoutManager
 * @param layoutManager the LayoutManager to set to the RecyclerView
 */
@BindingAdapter("layoutManager")
fun setLayoutManager(view: RecyclerView, layoutManager: RecyclerView.LayoutManager) {
    view.layoutManager = layoutManager
}

/**
 * Adds a DividerItemDecoration to a RecyclerView (to be used in view with one RecyclerView)
 * @param view the RecyclerView on which to set the DividerItemDecoration
 * @param dividerItemDecoration the DividerItemDecoration to set to the RecyclerView
 */
@BindingAdapter("dividerItemDecoration")
fun setDividerItemDecoration(view: RecyclerView, dividerItemDecoration: DividerItemDecoration) {
    view.addItemDecoration(dividerItemDecoration)
}






@BindingAdapter("setToolbarTitle")
fun setToolbarTitle(view: Toolbar, title: String) {
    view.title = title
}


@BindingAdapter("isToolbarBackButtonEnable")
fun isToolbarBackButtonEnable(view: Toolbar, isEnable: Boolean) {
    
}


@BindingAdapter("app:image_url")
fun loadImage(v: ImageView, imgUrl: String) {
    Glide.with(v.context).load(imgUrl).into(v)
}

@BindingAdapter("app:image_circular_url")
fun loadImageCircular(v: ImageView, imgUrl: String) {
    Glide.with(v.context).load(imgUrl)
            .asBitmap()
            .signature(StringSignature(System.currentTimeMillis().toString()))
            .centerCrop()
            .into(object : BitmapImageViewTarget(v) {
                override fun setResource(resource: Bitmap) {
                    val circularBitmapDrawable = RoundedBitmapDrawableFactory.create(v.context.resources, resource)
                    circularBitmapDrawable.isCircular = true
                    v.setImageDrawable(circularBitmapDrawable)
                }
            })
}