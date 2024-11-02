package com.alekseyd.spring.springboot.services;
import com.alekseyd.spring.springboot.dto.QuestionDto;
import com.alekseyd.spring.springboot.entity.Question;
import com.alekseyd.spring.springboot.entity.Section;
import com.alekseyd.spring.springboot.repositories.QuestionsRepository;
import org.apache.catalina.User;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class MyExcelServiceImp implements MyExcelService {

    public MyExcelServiceImp(QuestionsRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
    }

    private final QuestionsRepository questionsRepository;





    public void saveExcelData(MultipartFile file) throws IOException {
        List<Question> questions = new ArrayList<>();
        Workbook workbook = WorkbookFactory.create(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            Question question = new Question();
            Section section = new Section();
            if(!Objects.equals(row.getCell(0).getStringCellValue(), "")) {
                question.setQuestion(row.getCell(0).getStringCellValue());
                question.setAnswer(row.getCell(1).getStringCellValue());
                section.setName(workbook.getSheetName(0));
                section.setId(2);
                question.setSection(section);
                questions.add(question);
            }
        }

        questionsRepository.saveAll(questions);
        workbook.close();

    }

}
