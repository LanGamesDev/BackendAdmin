package com.langames.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.langames.admin.entities.Translate.TranslateModel;


@Repository
public interface TranslateRepository extends JpaRepository<TranslateModel, Long> {

}