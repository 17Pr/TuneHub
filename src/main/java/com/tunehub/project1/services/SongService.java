package com.tunehub.project1.services;

import java.util.List;

import com.tunehub.project1.entity.Song;

public interface SongService {
	
	public void addSong(Song song);
	public List<Song> fetchAllSongs();
	public boolean songExists(String name);
	public void updateSong(Song song);
	

}
