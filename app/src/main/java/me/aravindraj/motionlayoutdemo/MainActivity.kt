package me.aravindraj.motionlayoutdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlideApp.with(this)
            .load(R.drawable.ic_guitar)
            .apply(RequestOptions.circleCropTransform())
            .placeholder(R.mipmap.ic_launcher_round)
            .into(albumThumbnailImg)


        val adapter = AlbumSongsAdapter(this, emptyList<SongModel>())
        val recyclerview = findViewById<RecyclerView>(R.id.allSongsListView)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = adapter
        adapter.submitList(getSongsList())
    }

    private fun getSongsList(): List<SongModel> {
        val songModelList = mutableListOf<SongModel>()
        songModelList.add(SongModel(0L,"Song One",0L,"Album One","Artist One",null,""))
        songModelList.add(SongModel(0L,"Song Two",0L,"Album One","Artist One",null,""))
        songModelList.add(SongModel(0L,"Song Three",0L,"Album One","Artist One",null,""))
        songModelList.add(SongModel(0L,"Song Four",0L,"Album One","Artist One",null,""))
        songModelList.add(SongModel(0L,"Song Five",0L,"Album One","Artist One",null,""))
        return songModelList
    }
}
