package ro.utcn.sd.a3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int authorId;
    private String title;
    private String text;
    private Date date;

    public Question(int authorId, String title, String text, Date date){
        this.authorId=authorId;
        this.title=title;
        this.text=text;
        this.date=date;
    }

}


