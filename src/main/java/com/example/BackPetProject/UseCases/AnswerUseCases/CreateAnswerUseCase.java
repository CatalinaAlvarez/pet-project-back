package com.example.BackPetProject.UseCases.AnswerUseCases;

import com.example.BackPetProject.DTO.AnswerDto;
import com.example.BackPetProject.Mappers.AnswerMapper;
import com.example.BackPetProject.Repositories.AnswerRepository;
import com.example.BackPetProject.Repositories.QuestionRepository;
import com.example.BackPetProject.Repositories.UserRepository;
import com.example.BackPetProject.UseCases.QuestionUseCases.FindQuestionById;
import com.example.BackPetProject.UseCases.UserUseCases.FindUserById;
import com.example.BackPetProject.UseCases.Utils.SendEmailUseCase;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CreateAnswerUseCase implements CreateAnswer{

    private final AnswerRepository answerRepository;
    private final AnswerMapper answerMapper;
    private final SendEmailUseCase sendEmailUseCase;
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;

    public CreateAnswerUseCase(AnswerRepository answerRepository, AnswerMapper answerMapper, SendEmailUseCase sendEmailUseCase, FindUserById findUserById, FindQuestionById findQuestionById, UserRepository userRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.answerMapper = answerMapper;
        this.sendEmailUseCase = sendEmailUseCase;
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
    }


    @Override
    public Mono<AnswerDto> createAnswer(AnswerDto answerDto) {
        return userRepository.findById(
                questionRepository.findById(answerDto.getParentId()).
                        map(question -> question.getUserId()))
                .map(user -> sendEmailUseCase.sendMail(user.getEmail(),
                        "Han respondido a tu pregunta",
                        "Un usuario ha respondido a tu pregunta")).
                then(answerRepository.save(answerMapper.mapToNewAnswer().apply(answerDto))
                .map(answerMapper.mapToAnswerDto()));

    }
}
