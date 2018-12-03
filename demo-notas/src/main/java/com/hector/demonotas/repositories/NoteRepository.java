package com.hector.demonotas.repositories;

import com.hector.demonotas.models.Note;

import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note,Integer>{

}