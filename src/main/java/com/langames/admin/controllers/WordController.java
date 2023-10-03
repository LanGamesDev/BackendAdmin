package com.langames.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.langames.admin.entities.Word.WordDAO;
import com.langames.admin.entities.Word.WordModel;
import com.langames.admin.repositories.WordRepository;

import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/words")
public class WordController {
    @Autowired
    private WordRepository WordRepository;

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
	public WordModel createWord(@RequestBody WordModel word) {
		return WordRepository.save(word);
	}

    @PutMapping("/{id}")
	public ResponseEntity<WordModel> updateWord(@PathVariable Long id, @RequestBody WordModel wordDetails){
		WordModel _word = WordRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Word not exist with id :" + id));
		
		_word.setContent(wordDetails.getContent());
		
		WordModel updatedWord = WordRepository.save(_word);
		return ResponseEntity.ok(updatedWord);
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
