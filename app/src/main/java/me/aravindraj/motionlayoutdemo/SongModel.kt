package me.aravindraj.motionlayoutdemo

data class SongModel(
    val id: Long,
    val title: String,
    val albumId: Long,
    val album: String,
    val artist: String,
    val albumArtPath: String?,
    val songPath: String
)