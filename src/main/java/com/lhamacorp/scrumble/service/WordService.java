package com.lhamacorp.scrumble.service;

import com.lhamacorp.scrumble.domain.Word;
import com.lhamacorp.scrumble.repository.WordProps;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
public class WordService {

    private final WordProps props;

    public Word getSomeWord() {
        var rand = new Random();
        var words = props.getProps();
        var randomIndex = rand.nextInt(words.size());
        var word = words.get(randomIndex);

        word.setShuffled(shuffle(word.getWord()));

        return word;
    }

    private String shuffle(String word) {
        var characters = word.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            int index = (int) (Math.random() * characters.length);
            char temp = characters[i];
            characters[i] = characters[index];
            characters[index] = temp;
        }

        return new String(characters);
    }

}
