package com.project.main.service;

import com.project.main.entity.JournalEntry;
import org.bson.types.ObjectId;

import java.util.List;

public interface JournalEntryService {
    void add(JournalEntry journalEntry);

    List<JournalEntry> addAll(List<JournalEntry> journalEntryList);

    Object getAll();

    Object getById(String id);

    void deleteById(String id);

    void update(JournalEntry journalEntry);

    void deleteAll(List<JournalEntry> journalEntryList);
}
