package com.tunehub.project1.services;

import java.util.List;

import com.tunehub.project1.entity.Playlist;

public interface PlaylistService {

	public void addPlaylist(Playlist playlist);

	public List<Playlist> fetchAllPlaylists();

}
