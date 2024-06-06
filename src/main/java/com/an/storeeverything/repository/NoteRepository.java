package com.an.storeeverything.repository;

import com.an.storeeverything.models.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<NoteEntity, Long> {

    List<NoteEntity> findByUserId(long userID);

    List<NoteEntity> findByTitle(String title);

    NoteEntity findById(long noteID);
}
