package com.project.main.controller;

import com.project.main.dto.ResponseDto;
import com.project.main.entity.JournalEntry;
import com.project.main.service.JournalEntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping("/journal")
@RestController
@RequiredArgsConstructor
public class JournalEntryController {

    private final JournalEntryService journalEntryService;

    @GetMapping("/id/{id}")
    public ResponseDto<?> getById(@PathVariable String id) {
        return ResponseDto
                .builder()
                .data(journalEntryService.getById(id))
                .message("success")
                .status(HttpStatus.OK.value())
                .build();
    }

    @PostMapping("")
    public ResponseDto<?> add(@RequestBody JournalEntry journalEntry) {

        journalEntryService.add(journalEntry);
        return ResponseDto
                .builder()
                .data("Successfully Added")
                .message("success")
                .status(HttpStatus.CREATED.value())
                .build();
    }

    @GetMapping("")
    public ResponseDto<?> getAll() {

        return ResponseDto
                .builder()
                .data(journalEntryService.getAll())
                .message("success")
                .status(HttpStatus.OK.value())
                .build();

    }

    @DeleteMapping("/{id}")
    public ResponseDto<?> deleteById(@PathVariable String id) {
        journalEntryService.deleteById(id);
        return ResponseDto
                .builder()
                .data("Successfully Deleted")
                .message("success")
                .status(HttpStatus.OK.value())
                .build();
    }


    @PutMapping("")
    public ResponseDto<?> update(@RequestBody JournalEntry journalEntry){

        journalEntryService.update(journalEntry);

        return ResponseDto
                .builder()
                .data("Successfully Updated")
                .message("success")
                .status(HttpStatus.OK.value())
                .build();
    }

}
