package com.github.dmn1k.tfm;

import com.github.dmn1k.tfm.inserate.Inserat;
import com.github.dmn1k.tfm.inserate.InserateRepository;
import com.github.dmn1k.tfm.inserate.StoriesRepository;
import com.github.dmn1k.tfm.inserate.Story;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TestdataRunner implements ApplicationRunner {
    private final InserateRepository inserateRepository;
    private final StoriesRepository storiesRepository;

    @Override
    public void run(ApplicationArguments args) {
        inserateRepository.save(Inserat.builder()

            .titel("Inserat A")
            .beschreibung("bla blubb")
            .build());

        inserateRepository.save(Inserat.builder()

            .titel("Inserat B")
            .beschreibung("blubdiblubb")
            .build());

        inserateRepository.save(Inserat.builder()

            .titel("Inserat C")
            .beschreibung("blubdiblubb")
            .build());

        inserateRepository.save(Inserat.builder()

            .titel("Inserat D")
            .beschreibung("blubdiblubb")
            .build());

        inserateRepository.save(Inserat.builder()

            .titel("Inserat E")
            .beschreibung("blubdiblubb")
            .build());

        inserateRepository.save(Inserat.builder()

            .titel("Inserat F")
            .beschreibung("blubdiblubb")
            .build());

        storiesRepository.save(new Story(null, "Story 1", "Blablubb"));
        storiesRepository.save(new Story(null, "Story 2", "Blablubbnvnv"));
        storiesRepository.save(new Story(null, "Story 3", "Blablubbvnvn"));
        storiesRepository.save(new Story(null, "Story 4", "Blablubb gdfgdh"));
        storiesRepository.save(new Story(null, "Story 5", "Blablubbvhfghd hdhdh"));
        storiesRepository.save(new Story(null, "Story 6", "Blablubb hdhdfgh"));
        storiesRepository.save(new Story(null, "Story 7", "Blablubb hsdhsdh "));
        storiesRepository.save(new Story(null, "Story 8", "Blablubb hdhs hs"));
    }
}