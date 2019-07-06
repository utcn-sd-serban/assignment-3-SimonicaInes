package ro.utcn.sd.a3.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ro.utcn.sd.a3.dto.QuestionDTO;
import ro.utcn.sd.a3.entity.Question;
import ro.utcn.sd.a3.repository.QuestionRepository;
import ro.utcn.sd.a3.service.QuestionService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
@AllArgsConstructor
public class Command {
    private final QuestionService questionService;

    public List<QuestionDTO> handleCommands(String command, Object o){
        if(command.equals("listAll")){
            return questionService.listAll();
        }
        else if(command.equals("createQuestion")){
            List<QuestionDTO> l = new ArrayList<>();
            l.add(questionService.create((QuestionDTO)o));
            return l;
        }
        else{
            return new ArrayList<>();
        }
    }
}
