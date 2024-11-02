package com.alekseyd.spring.springboot.controllers;
import com.alekseyd.spring.springboot.dto.QuestionDto;
import com.alekseyd.spring.springboot.services.MyExcelService;
import com.alekseyd.spring.springboot.services.MyService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class MyController {

    public MyController(MyService myService, MyExcelService myExcelService) {
        this.myService = myService;
        this.myExcelService = myExcelService;
    }

    private final MyService myService;
    private final MyExcelService myExcelService;

    @GetMapping("/question/{id}")
    public QuestionDto getQuestionById(@PathVariable int id) {
        return myService.getQuestionById(id);
    }

    @GetMapping("/question/randomq")
    public QuestionDto getRandomQuestion() {
        return myService.getRandomQuestion();
    }

    @GetMapping("/question/random/{section}")
    public QuestionDto getRandomQuestionBySection(@PathVariable String section) {
        return myService.getRandomQuestionBySection(section);
    }

    @PostMapping("/question/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            myExcelService.saveExcelData(file);
            return "success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @PostMapping("/question/new")
    public void uploadNewQuestionFromChat (@RequestBody QuestionDto questionDto) throws IOException {
            myService.saveQuestionFromChat(questionDto);
    }
}
