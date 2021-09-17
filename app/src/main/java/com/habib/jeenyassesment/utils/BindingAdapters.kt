package com.habib.jeenyassesment.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

/**
 * Binding adapter used to hide the spinner once data is available.
 */
@BindingAdapter("isNetworkError", "articles")
fun hideIfNetworkError(view: View, isNetWorkError: Boolean, articles: Any?) {
    view.visibility = if (articles != null) View.GONE else View.VISIBLE

    if(isNetWorkError) {
        view.visibility = View.GONE
    }
}
/**
 * Binding adapter used to display images from URL using Glide
 */
@BindingAdapter("imageUrl","imageWidth","imageHeight")
fun setImageUrl(imageView: ImageView?, url: String?, imageWidth: Int?, imageHeight: Int?) {
    imageView?.let {imageViewOk->
        imageWidth?.let { imageWidthOk->
            imageHeight?.let {imageHeightOk->
                url?.let { urlOk->
                    if (urlOk.isNotEmpty())
                        Picasso.get().load(urlOk).resize(imageWidthOk,imageHeightOk).into(imageViewOk)
                }
            }
        }
    }
}