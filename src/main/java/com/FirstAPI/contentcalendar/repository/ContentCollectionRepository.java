package com.FirstAPI.contentcalendar.repository;

// NOTE: You hadn't imported the Content class, which is why any mention of it was red.
import com.FirstAPI.contentcalendar.model.Content;
import com.FirstAPI.contentcalendar.model.Status;
import com.FirstAPI.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.security.IdentityScope;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    private final List<Content> content = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll() {
        return content;
    }

    public Optional<Content> findById(Integer id) {
        return content.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    @PostConstruct
    private void init() {
        Content c =  new Content(1,
                "My First Blog",
                "My first blog",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "");

        // Inserting the commands only worked when putting in the values not the function or name
        // I Attempted lines  45-52 but, they caused even more errors.

         /* Content c = new Content( id: 1,
                title: "My First Blog Post",
                desc: "My first blog post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                dateUpdated: null,
                url: ""); */

        content.add(c);
    }

}
