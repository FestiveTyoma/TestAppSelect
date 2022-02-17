package com.myprojects.watchfilm

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class FilmRecyclerViewAdapter internal constructor(context: Context?, data: Albums) :
    RecyclerView.Adapter<FilmRecyclerViewAdapter.ViewHolder>() {
    private val mData: Albums
    private val mInflater: LayoutInflater
    private var mClickListener: ItemClickListener? = null
    // inflates the row layout from xml when needed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(R.layout.recyclerview_row_table, parent, false)
        return ViewHolder(view)
    }

    // binds the data to the TextView in each row
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = mData.results.get(position)
        holder.tvAlbumName.text=data.collectionName
        holder.tvArtistName.text=data.artistName
        holder.tvSongNumber.text=data.trackCount.toString()
        Glide.with(holder.logoImageView.context).load(data.artworkUrl60).override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
            .error(R.drawable.ic_launcher_background).listener(object :RequestListener<Drawable>{
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    Log.e("MY_TAG", "GlideError"+e?.toString())
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }

            }).into(holder.logoImageView)



    }

    // total number of rows
    override fun getItemCount(): Int {
        return mData.resultCount
    }

    // stores and recycles views as they are scrolled off screen
    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener {
        var tvAlbumName: TextView
        var tvArtistName: TextView
        var tvSongNumber: TextView
        var logoImageView: ImageView
        init {
            tvAlbumName = itemView.findViewById(R.id.tvAlbumName)
            tvArtistName = itemView.findViewById(R.id.tvArtistName)
            tvSongNumber = itemView.findViewById(R.id.tvSongsNumber)
            logoImageView=itemView.findViewById(R.id.logoImageView)
            itemView.setOnClickListener(this)

        }

        override fun onClick(view: View?) {
            if (mClickListener != null) mClickListener!!.onItemClick(view, adapterPosition)
        }

    }

    // data is passed into the constructor
    init {
        mInflater = LayoutInflater.from(context)
        mData = data
    }

    fun setClickListener(itemClickListener: ItemClickListener?) {
        mClickListener = itemClickListener
    }
    interface ItemClickListener {
        fun onItemClick(view: View?, position: Int)
    }

}