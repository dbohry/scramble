package com.lhamacorp.scrumble.api;

import com.lhamacorp.scrumble.domain.Word;
import com.lhamacorp.scrumble.service.WordService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("word")
@AllArgsConstructor
public class WordController {

    private final WordService service;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<Word> getSomeWord() {
        return ResponseEntity.ok(service.getSomeWord());
    }

}
