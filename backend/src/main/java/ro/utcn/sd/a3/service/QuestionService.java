package ro.utcn.sd.a3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.sd.a3.dto.QuestionDTO;
import ro.utcn.sd.a3.dto.TagDTO;
import ro.utcn.sd.a3.entity.Question;
import ro.utcn.sd.a3.entity.QuestionTag;
import ro.utcn.sd.a3.entity.Tag;
import ro.utcn.sd.a3.event.QuestionCreatedEvent;
import ro.utcn.sd.a3.repository.QuestionRepository;
import ro.utcn.sd.a3.repository.QuestionTagRepository;
import ro.utcn.sd.a3.repository.TagRepository;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionTagRepository questionTagRepository;
    private final QuestionRepository questionRepository;
    private final TagRepository tagRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public List<QuestionDTO> listAll() {
        List<QuestionDTO> questionTag = new ArrayList<QuestionDTO>();
        List<Question> questions = questionRepository.findAll();
        for(Question q: questions){
            String tags="";
            for(QuestionTag t: questionTagRepository.findAll()){
                if(t.getQuestionId() == q.getId()){
                    tags+=tagRepository.findById(t.getTagId()).get().toString()+";";

                }
            }
            questionTag.add(QuestionDTO.ofEntity(q,tags));

        }
        return questionTag;
    }

    @Transactional
    public QuestionDTO create(QuestionDTO dto) {
        Question question = new Question();
        question.setAuthorId(dto.getAuthorId());
        question.setTitle(dto.getTitle());
        question.setText(dto.getText());
        question.setDate(new Date());
        questionRepository.save(question);

        for(String tag: dto.getTags().split(";")){
            if(tagRepository.findByText(tag)== null){
                tagRepository.save(new Tag(tag));
            }
            questionTagRepository.save(new QuestionTag(question.getId(),tagRepository.findByText(tag).getId()));
        }

        QuestionDTO output = QuestionDTO.ofEntity(question,dto.getTags());
        eventPublisher.publishEvent(new QuestionCreatedEvent(output));
        return output;
    }

}
