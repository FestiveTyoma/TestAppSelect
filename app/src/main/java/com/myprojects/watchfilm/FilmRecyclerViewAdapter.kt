package com.myprojects.watchfilm

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class FilmRecyclerViewAdapter internal constructor(context: Context?, data:Albums) :
    RecyclerView.Adapter<FilmRecyclerViewAdapter.ViewHolder>() {
    private val mData: Albums
    private val mInflater: LayoutInflater

    // inflates the row layout from xml when needed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(R.layout.recyclerview_row1, parent, false)
        return ViewHolder(view)
    }

    // binds the data to the TextView in each row
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val data = mData.results[position]
        if (position!=0) {
            holder.tvSong.text = data.trackName
            Log.d("Position_debag", "Имя трека " + data.trackName + "Позиция " + position)
            holder.tvNumberOfSong.text = data.trackNumber.toString()
            Log.d("Position_debag", "Номер трека " + data.trackNumber + "Позиция " + position)
        }

    }

    // total number of rows
    override fun getItemCount(): Int {
        return mData.resultCount
    }

    // stores and recycles views as they are scrolled off screen
    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvSong: TextView
        var tvNumberOfSong: TextView

        init {
            tvSong = itemView.findViewById(R.id.tvSong)
            tvNumberOfSong = itemView.findViewById(R.id.tvNumberOfSong)
        }
    }

    // data is passed into the constructor
    init {
        mInflater = LayoutInflater.from(context)
        mData = data
    }

}