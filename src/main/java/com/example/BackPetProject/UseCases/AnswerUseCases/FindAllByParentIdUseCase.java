package com.example.BackPetProject.UseCases.AnswerUseCases;

import com.example.BackPetProject.DTO.AnswerDto;
import com.example.BackPetProject.Mappers.AnswerMapper;
import com.example.BackPetProject.Repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

@Service
@Validated
public class FindAllByParentIdUseCase implements FindAllByParentId{

    private final AnswerRepository answerRepository;
    private final AnswerMapper answerMapper;

    @Autowired
    public FindAllByParentIdUseCase(AnswerRepository answerRepository, AnswerMapper answerMapper){
        this.answerRepository = answerRepository;
        this.answerMapper = answerMapper;
    }


    @Override
    public Flux<AnswerDto> findAllByParentId(String id) {
        return answerRepository.findAllByParentId(id)
                .map(answerMapper.mapToAnswerDto());
    }
}
