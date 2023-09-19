package com.langames.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/words")
public class WordController {
    @Autowired
    private WordRepository WordRepository;

    @GetMapping
    public List<Word> getAllWords() {
        return WordRepository.findAll();
    }

    @PostMapping
	public Word createWord(@RequestBody Word word) {
		return WordRepository.save(word);
	}
}
