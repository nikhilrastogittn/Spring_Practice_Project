package com.project.main.entity;


import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "journal_entries")
@Data
public class JournalEntry {

    @Id
    private String id;

    private String title;

    private String content;

}
