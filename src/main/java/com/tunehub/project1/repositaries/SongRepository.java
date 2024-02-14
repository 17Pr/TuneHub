package com.tunehub.project1.repositaries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunehub.project1.entity.Song;

public interface SongRepository extends JpaRepository<Song, Integer>{

	public Song findByName(String name);
}
