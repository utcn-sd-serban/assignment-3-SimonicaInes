package ro.utcn.sd.a3.dto;

import lombok.Data;
import org.springframework.util.CollectionUtils;
import ro.utcn.sd.a3.entity.Grade;
import ro.utcn.sd.a3.entity.Question;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private int authorId;
    private String text;
    private Date date;

    public static QuestionDTO ofEntity(Question question) {
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setId(question.getId());
        questionDTO.setTitle((question.getTitle()));
        questionDTO.setAuthorId((question.getAuthorId()));
        questionDTO.setText((question.getText()));
        questionDTO.setDate((question.getDate()));

        return questionDTO;
    }
}
