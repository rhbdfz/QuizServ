package com.alekseyd.spring.springboot.dto;

public class QuestionDto {

    int questionNumber;
    String question;
    String answer;
    String section;

//    public QuestionDto(int questionNumber, String question, String answer, String section) {
//        this.questionNumber = questionNumber;
//        this.question = question;
//        this.answer = answer;
//        this.section = section;
//    }

    public void toDto(int questionNumber, String question, String answer, String section) {
        this.questionNumber = questionNumber;
        this.question = question;
        this.answer = answer;
        this.section = section;
    }

    @Override
    public String toString() {
        return "QuestionDto{" +
                "questionNumber=" + questionNumber +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", section='" + section + '\'' +
                '}';
    }

    public QuestionDto() {
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
