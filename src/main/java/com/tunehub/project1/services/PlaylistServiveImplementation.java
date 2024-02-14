package com.tunehub.project1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.project1.entity.Playlist;
import com.tunehub.project1.repositaries.PlaylistRepository;

@Service
public class PlaylistServiveImplementation implements PlaylistService {
 @Autowired
 PlaylistRepository repo;
	@Override
	public void addPlaylist(Playlist playlist) {
		repo.save(playlist);
		
		
	}
	@Override
	public List<Playlist> fetchAllPlaylists() {
		
		return repo.findAll();
	}

}
