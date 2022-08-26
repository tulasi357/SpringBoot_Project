package com.DSSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DSSystem.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie,Integer>{

}
