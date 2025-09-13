package com.project.main.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "users")
public class User {

    @Id
    private String id;
    @Indexed(unique = true)
    @NotBlank(message = "username required")
    private String username;
    @NotBlank(message = "password required")
    private String password;
    @DBRef
    private List<JournalEntry> journalEntryList=new ArrayList<>();

}
