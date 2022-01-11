package com.example.BackPetProject.UseCases.QuestionUseCases;

import com.example.BackPetProject.Mappers.QuestionMapper;
import com.example.BackPetProject.Repositories.AnswerRepository;
import com.example.BackPetProject.Repositories.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class DeleteQuestionByIdUseCaseTest {

    QuestionRepository questionRepository;
    DeleteQuestionByIdUseCase deleteQuestionByIdUseCase;
    AnswerRepository answerRepository;

    @BeforeEach
    public void setUp(){
        questionRepository = mock(QuestionRepository.class);
        deleteQuestionByIdUseCase = new DeleteQuestionByIdUseCase(questionRepository, answerRepository);
    }

    @Test
    void

}