package com.alekseyd.spring.springboot.services;

import com.alekseyd.spring.springboot.dto.QuestionDto;

import java.io.IOException;
import java.util.List;


public interface MyService {

    QuestionDto getQuestionById(int id);

    QuestionDto getRandomQuestion();

    QuestionDto getRandomQuestionBySection(String section);

    void saveQuestionFromChat(QuestionDto questionDto) throws IOException;

    QuestionDto getQuestionDto(List<Integer> questionIds);

}
