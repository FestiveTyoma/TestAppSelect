package com.myprojects.watchfilm

import android.content.Context
import android.graphics.drawable.Drawable


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener

import com.myprojects.watchfilm.POJO.Film

class FilmRecyclerViewAdapter internal constructor(context: Context?, data: Film) :
    RecyclerView.Adapter<FilmRecyclerViewAdapter.ViewHolder>() {
    private val mData: Film
    private val mInflater: LayoutInflater
    // inflates the row layout from xml when needed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(R.layout.recyclerview_row_table, parent, false)
        return ViewHolder(view)
    }

    // binds the data to the TextView in each row
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = mData.results.get(position)

        Glide.with(holder.logoImageView.context).load(data.multimedia.src).override(com.bumptech.glide.request.target.Target.SIZE_ORIGINAL,com.bumptech.glide.request.target.Target.SIZE_ORIGINAL)
            .error(R.drawable.ic_launcher_background).listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    Log.e("MY_TAG", "GlideError"+e?.toString())
                    return false
                }
                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: com.bumptech.glide.request.target.Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }
            }).into(holder.logoImageView)
        holder.tvFilmName.text=data.displayTitle
        holder.tvDescription.text=data.summaryShort



    }

    // total number of rows
    override fun getItemCount(): Int {
        return mData.numResults
    }

    // stores and recycles views as they are scrolled off screen
    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvFilmName: TextView
        var tvDescription: TextView
        var logoImageView: ImageView
        init {
            tvFilmName = itemView.findViewById(R.id.tvFilmName)
            tvDescription = itemView.findViewById(R.id.tvDescription)
            logoImageView=itemView.findViewById(R.id.logoImageView)
        }
    }

    // data is passed into the constructor
    init {
        mInflater = LayoutInflater.from(context)
        mData = data
    }

}