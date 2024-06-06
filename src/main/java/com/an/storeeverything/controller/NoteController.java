package com.an.storeeverything.controller;

import com.an.storeeverything.models.NoteEntity;
import com.an.storeeverything.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping
    public NoteEntity addNote(@RequestBody NoteEntity note) {
        return noteService.addNote(note);
    }

    @PutMapping("/{id}")
    public void editNote(@PathVariable long id, @RequestBody NoteEntity note) {
        note.setId(id);
        noteService.editNote(note);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable long id) {
        noteService.deleteNote(id);
    }

    @GetMapping
    public ModelAndView getAllNotes() {
        var notes =  noteService.getAllNotes();

        Map<String, Object> model = new HashMap<>();
        model.put("Notatki", notes);

        ModelAndView modelAndView = new ModelAndView("notes");
        modelAndView.addObject(model);

        return modelAndView;
    }

}