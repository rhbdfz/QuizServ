package com.alekseyd.spring.springboot.services;
import com.alekseyd.spring.springboot.dto.QuestionDto;
import com.alekseyd.spring.springboot.entity.Question;
import com.alekseyd.spring.springboot.entity.Section;
import com.alekseyd.spring.springboot.repositories.QuestionsRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class MyServiceImp implements MyService {

    public MyServiceImp(QuestionsRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
    }

    private final QuestionsRepository questionsRepository;

    @Override
    public QuestionDto getQuestionById(int id) {
        List<Integer> questionIds = new ArrayList<>();
        questionIds.add(id);
        return getQuestionDto(questionIds);
    }

    @Override
    public QuestionDto getRandomQuestion() {
        List<Integer> questionIds = questionsRepository.findAllIds();
        return getQuestionDto(questionIds);
    }

    @Override
    public QuestionDto getRandomQuestionBySection(String section) {
        List<Integer> questionIds = questionsRepository.findAllIdsBySection(section);
        return getQuestionDto(questionIds);
    }

    @Override
    public void saveQuestionFromChat(QuestionDto questionDto) throws IOException {
        Question question = new Question();
        Section section = new Section();
        question.setQuestion(questionDto.getQuestion());
        question.setAnswer(questionDto.getAnswer());
        switch (questionDto.getSection()) {
            case "core-1":
                section.setId(2);
                break;
            case "core-2":
                section.setId(3);
                break;
            case "Multithreading":
                section.setId(4);
                break;
        }
        section.setName(questionDto.getSection());
        question.setSection(section);
        //System.out.println(question);
        questionsRepository.save(question);
    }

    @Override
    public QuestionDto getQuestionDto(List<Integer> questionIds) {
        QuestionDto questionDto = new QuestionDto();
        Random random = new Random();
        int index = random.nextInt(questionIds.size());
        Optional<Question> gotQuestion = questionsRepository.findById(questionIds.get(index));
        if(gotQuestion.isPresent()) {
            questionDto.toDto(
                    gotQuestion.get().getId(),
                    gotQuestion.get().getQuestion(),
                    gotQuestion.get().getAnswer(),
                    gotQuestion.get().getSection().getName());
            return questionDto;
        }
        return questionDto;
    }
}
