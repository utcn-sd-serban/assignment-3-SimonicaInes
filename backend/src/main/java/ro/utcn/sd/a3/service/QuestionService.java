package ro.utcn.sd.a3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.sd.a3.dto.QuestionDTO;
import ro.utcn.sd.a3.entity.Question;
import ro.utcn.sd.a3.event.StudentCreatedEvent;
import ro.utcn.sd.a3.repository.QuestionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public List<QuestionDTO> listAll() {
        return questionRepository.findAll().stream()
                .map(QuestionDTO::ofEntity)
                .collect(Collectors.toList());
    }

    @Transactional
    public QuestionDTO create(QuestionDTO dto) {
        Question question = new Question();
        question.setTitle(dto.getTitle());
        question.setText(dto.getText());
        question.setAuthorId(dto.getAuthorId());
        question.setDate(dto.getDate());

        QuestionDTO output = QuestionDTO.ofEntity(questionRepository.save(question));
        eventPublisher.publishEvent(new StudentCreatedEvent(output));
        return output;
    }

}
