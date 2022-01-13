package com.lhamacorp.scrumble.repository;

import com.lhamacorp.scrumble.domain.Word;
import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "scrumble")
@Value
public class WordProps {

    List<Word> props;

}
