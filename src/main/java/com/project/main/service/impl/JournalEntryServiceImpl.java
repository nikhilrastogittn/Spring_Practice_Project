package com.project.main.service.impl;

import com.project.main.entity.JournalEntry;
import com.project.main.repository.JournalEntryRepository;
import com.project.main.service.JournalEntryService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class JournalEntryServiceImpl implements JournalEntryService {

    private final JournalEntryRepository journalEntryRepository;


    @Override
    public void add(JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }


    @Override
    public List<JournalEntry> addAll(List<JournalEntry> journalEntryList) {
        return journalEntryRepository.saveAll(journalEntryList);
    }

    @Override
    public List<JournalEntry> getAll() {

        var data = journalEntryRepository.findAll();

        return data;

    }

    @Override
    public JournalEntry getById(String id) {
        return journalEntryRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(String id) {
        journalEntryRepository.deleteById(id);
    }

    @Override
    public void update(JournalEntry journalEntry) {

        JournalEntry currentJournalEntry = journalEntryRepository.findById(journalEntry.getId()).orElse(null);

        if (currentJournalEntry != null) {
            if (journalEntry.getContent() != null)
                currentJournalEntry.setContent(journalEntry.getContent());
            if (journalEntry.getTitle() != null)
                currentJournalEntry.setTitle(journalEntry.getTitle());

            journalEntryRepository.save(journalEntry);

        } else throw new RuntimeException("Data Not found or Invalid Data");

    }

    @Override
    public void deleteAll(List<JournalEntry> journalEntryList){
        journalEntryRepository.deleteAll(journalEntryList);
    }


}
