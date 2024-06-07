package com.an.storeeverything.controller;

import com.an.storeeverything.models.NoteEntity;
import com.an.storeeverything.services.NoteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
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

    @GetMapping("/new")
    public String addNewNote(Model model) {

        model.addAttribute("noteForm", new NoteEntity());


        return "add_note.html";
    }

    @PostMapping("/addNew")
    public String AddNew(
            @Valid NoteEntity note,
            BindingResult bindingResult,
            Model model
    ) {

        note.setPublicationDate(LocalDate.now());
        note.setId(null);
        noteService.addNote(note);

        List<NoteEntity> notes = noteService.getAllNotes();

        model.addAttribute("notes", notes);


        return "notes";
    }

}
