package com.tunehub.project1.repositaries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunehub.project1.entity.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer>{

}
