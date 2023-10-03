package com.FirstAPI.contentcalendar.repository;

// NOTE: You hadn't imported the Content class, which is why any mention of it was red.

import com.FirstAPI.contentcalendar.model.Content;
import com.FirstAPI.contentcalendar.model.Status;
import com.FirstAPI.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public void save(Content content) {
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
    }

    @PostConstruct
    private void init() {
        Content content = new Content(1,
                "My First Blog Post",
                "My first blog post",
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
    }

    public boolean existsById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
    }

    public void delete(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }
}
// Class would usually be named ContentCollection or ContentRepository