package me.aravindraj.motionlayoutdemo

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

import java.io.File

class AlbumSongsAdapter(
    val context: Context,
    var allAlbumSongs: List<SongModel>
) : RecyclerView.Adapter<AlbumSongsAdapter.AlbumSongsViewHolder>() {
    override fun getItemCount(): Int {
        return allAlbumSongs.size
    }

    override fun onBindViewHolder(holderPerson: AlbumSongsViewHolder, position: Int) {
        val songModel = allAlbumSongs[position]

        if (songModel == null) {
            holderPerson.clear()
        } else {
            holderPerson.bind(songModel)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumSongsViewHolder {
        return AlbumSongsViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_song,
                parent, false
            )
        )
    }

    fun submitList(allSongsAlbumID: List<SongModel>) {
        allAlbumSongs = allSongsAlbumID
        notifyDataSetChanged()
    }


    class AlbumSongsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var songTitle: TextView = view.findViewById(R.id.textViewSongTitle)
        var songAlbum: TextView = view.findViewById(R.id.textViewSongAlbum)
        var songArtist: TextView = view.findViewById(R.id.textViewSongArtist)
        var songImgView: ImageView = view.findViewById(R.id.imageViewSong)

        fun bind(person: SongModel) {
            songTitle.text = person.title
            songAlbum.text = person.album
            songArtist.text = person.artist
            if (person.albumArtPath != null) {
                GlideApp.with(songImgView.context)
                    .load(Uri.fromFile(File(person.albumArtPath)))
                    .transforms(CenterCrop(), RoundedCorners(4))
                    .placeholder(R.mipmap.ic_launcher_round)
                    .into(songImgView)
            }else{
                songImgView.setImageDrawable(songImgView.context.getDrawable(R.mipmap.ic_launcher_round))
            }

        }

        fun clear() {
            songTitle.text = null
            songAlbum.text = null
            songArtist.text = null
        }
    }
}