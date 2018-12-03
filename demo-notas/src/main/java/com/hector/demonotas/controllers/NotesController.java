package com.hector.demonotas.controllers;

import javax.validation.Valid;

import com.hector.demonotas.models.Note;
import com.hector.demonotas.repositories.NoteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotesController {

    @Autowired
    private NoteRepository noteRepository;

    @GetMapping(path = "/api/notes", produces = "application/json")
    public Iterable<Note> index(){
        return noteRepository.findAll();
    }

    @PostMapping(path = "/api/notes/store", consumes = "application/json", produces = "application/json")
    public void store(@RequestBody @Valid Note newNote){
        noteRepository.save(newNote);
        return;
    }

}