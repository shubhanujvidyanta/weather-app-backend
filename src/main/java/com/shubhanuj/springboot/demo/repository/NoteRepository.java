package com.shubhanuj.springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shubhanuj.springboot.demo.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}