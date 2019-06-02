package ro.utcn.sd.a3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"id", "title", "authorId","text","date"})
@Table(name="question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int authorId;
    @Column (name= "textq")
    private String text;
    @Column (name= "dateq")
    private Date date;
    //@OneToMany(fetch = FetchType.EAGER)
    //@JoinColumn
    //private List<Question> grades;

    public Question(String title, int authorId, String text, Date date) {
        this.title = title;
        this.authorId = authorId;
        this.text = text;
        this.date = date;
    }
}
