package com.langames.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.langames.admin.entities.Translate.*;
import com.langames.admin.entities.Word.*;
import com.langames.admin.repositories.TranslateRepository;
import com.langames.admin.repositories.WordRepository;

import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/words")
public class WordController {
    @Autowired
    private WordRepository WordRepository;
	@Autowired
    private TranslateRepository TranslateRepository;

    @GetMapping
    public List<WordDAO> getAllWords() {
		List<WordModel> wordModel = WordRepository.findAllByOrderByIdAsc();
		List<WordDAO> wordDao = new ArrayList<>();

		for (WordModel wm : wordModel) {
			wordDao.add(wm.toDao());
		}

        return wordDao;
    }

    @PostMapping
	public ResponseEntity<WordDAO> createWord(@RequestBody WordDAO word) {
		WordModel modelWord = word.toModel();
		List<TranslateModel> translates = new ArrayList<>();

		for (TranslateDAO translateDao : word.translates) {
			TranslateModel modelTranslate = translateDao.toModel();
			modelTranslate.setWord(modelWord);
			modelTranslate.setFechaCreacion(new Date());
			translates.add(modelTranslate);
		}

		modelWord.setTranslates(translates);
		modelWord = WordRepository.save(modelWord);
		return ResponseEntity.ok(modelWord.toDao());
	}

    @PutMapping("/{id}")
	public ResponseEntity<WordDAO> updateWord(@PathVariable Long id, @RequestBody WordDAO wordDetails){
		WordModel modelWord = wordDetails.toModel();
		WordModel _word = WordRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Word not exist with id :" + id));

		List<TranslateModel> translates = new ArrayList<>();

		for (TranslateDAO translateDao : wordDetails.translates) {
			System.out.println(translateDao.printModel());
			TranslateModel modelTranslate = translateDao.toModel();
			modelTranslate.setWord(_word);
			modelTranslate.setFechaCreacion(new Date());
			System.out.println(modelTranslate.printModel());
			
			translates.add(modelTranslate);
		}
		_word.setContent(modelWord.getContent());
		_word.setTranslates(translates);
		
		WordModel updatedWord = WordRepository.save(_word);

		for (TranslateDAO translateDao : wordDetails.deletedTranslates) {
			TranslateRepository.deleteById(translateDao.id);
		}

		return ResponseEntity.ok(updatedWord.toDao());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Long> deleteWord(@PathVariable Long id) {

		Optional<WordModel> optionalWord = WordRepository.findById(id);

		if (optionalWord.isPresent()) {
			WordRepository.deleteById(id);
			return ResponseEntity.ok(id);
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
}
