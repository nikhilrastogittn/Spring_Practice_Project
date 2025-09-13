package com.project.main.controller;


import com.project.main.Dto.ResponseDto;
import com.project.main.entity.JournalEntry;
import com.project.main.entity.User;
import com.project.main.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/id/{id}")
    public ResponseDto<?> getById(@PathVariable String id) {
        return ResponseDto
                .builder()
                .data(userService.getById(id))
                .message("success")
                .status(HttpStatus.OK.value())
                .build();
    }

    @PostMapping("")
    public ResponseDto<?> add(@RequestBody User user) {

        userService.add(user);
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
                .data(userService.getAll())
                .message("success")
                .status(HttpStatus.OK.value())
                .build();

    }

    @DeleteMapping("/{id}")
    public ResponseDto<?> deleteById(@PathVariable String id) {
        userService.deleteById(id);
        return ResponseDto
                .builder()
                .data("Successfully Deleted")
                .message("success")
                .status(HttpStatus.OK.value())
                .build();
    }


    @PutMapping("")
    public ResponseDto<?> update(@RequestBody User user) {

        userService.update(user);

        return ResponseDto
                .builder()
                .data("Successfully Updated")
                .message("success")
                .status(HttpStatus.OK.value())
                .build();
    }


}
