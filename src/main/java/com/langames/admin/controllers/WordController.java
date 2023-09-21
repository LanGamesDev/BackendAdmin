package com.langames.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/words")
public class WordController {
    @Autowired
    private WordRepository WordRepository;

    @GetMapping
    public List<Word> getAllWords() {
        return WordRepository.findAllByOrderByIdAsc();
    }

    @PostMapping
	public Word createWord(@RequestBody Word word) {
		return WordRepository.save(word);
	}

    @PutMapping("/{id}")
	public ResponseEntity<Word> updateWord(@PathVariable Long id, @RequestBody Word wordDetails){
		Word _word = WordRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Word not exist with id :" + id));
		
		_word.setContent(wordDetails.getContent());
		
		Word updatedWord = WordRepository.save(_word);
		return ResponseEntity.ok(updatedWord);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Long> deleteWord(@PathVariable Long id) {

		Optional<Word> optionalWord = WordRepository.findById(id);

		if (optionalWord.isPresent()) {
			Word wordToDelete = optionalWord.get();
			WordRepository.deleteById(id);
			return ResponseEntity.ok(id);
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
}
