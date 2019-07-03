package ro.utcn.sd.a3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.sd.a3.entity.Question;
import ro.utcn.sd.a3.entity.QuestionTag;
import ro.utcn.sd.a3.entity.Tag;
import ro.utcn.sd.a3.repository.QuestionTagRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionTagService {
    private final QuestionTagRepository questionTagRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public void addQuestionTag(Question question, Tag tag){
        QuestionTag questionTag = new QuestionTag(question.getId(), tag.getId());
        questionTagRepository.save(questionTag);
    }

    @Transactional
    public List<QuestionTag> listTagsFromQuestion(Question question){
        List<QuestionTag> l = new ArrayList<QuestionTag>();
        for(QuestionTag i : questionTagRepository.findAll()){
            if(i.getQuestionId() == question.getId()){
                l.add(i);
            }
        }
        return l;
    }
    @Transactional
    public List<QuestionTag> listQuestionFromTag(Tag tag){
        List<QuestionTag> l = new ArrayList<QuestionTag>();
        for(QuestionTag i : questionTagRepository.findAll()){
            if(i.getTagId() == tag.getId()){
                l.add(i);
            }
        }
        return l;
    }

}
