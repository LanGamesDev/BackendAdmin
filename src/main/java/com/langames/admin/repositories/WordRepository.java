package com.langames.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.langames.admin.entities.Word.WordModel;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<WordModel, Long> {
    public List<WordModel> findAllByOrderByIdAsc();
}