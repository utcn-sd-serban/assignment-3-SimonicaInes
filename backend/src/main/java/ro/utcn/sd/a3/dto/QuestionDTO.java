package ro.utcn.sd.a3.dto;

import lombok.Data;
import ro.utcn.sd.a3.entity.Question;


//Question-Tag association
@Data
public class QuestionDTO {
    private int authorId;
    private String title;
    private String text;
    private String tags;
    private String date;


    public static QuestionDTO ofEntity(Question question, String tags) {
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setAuthorId(question.getAuthorId());//sau parametru?-- conclusion: no
        questionDTO.setTitle(question.getTitle());
        questionDTO.setText(question.getText());
        questionDTO.setTags(tags);
        questionDTO.setDate(question.getDate().toString());

        return questionDTO;
    }
}
