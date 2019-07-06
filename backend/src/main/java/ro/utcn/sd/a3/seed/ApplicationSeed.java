package ro.utcn.sd.a3.seed;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.sd.a3.entity.*;
import ro.utcn.sd.a3.repository.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ApplicationSeed implements CommandLineRunner {
    private final TeacherRepository teacherRepository;
    private final QuestionRepository questionRepository;
    private final QuestionTagRepository questionTagRepository;
    private final TagRepository tagRepository;
    private final GradeRepository gradeRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(String... args) throws ParseException {
        Teacher serban = new Teacher(0, "serban", passwordEncoder.encode("password"));
        teacherRepository.save(serban);
        Date date= new SimpleDateFormat("dd/MM/yyyy").parse("11/07/2015");
        Question q1 = new Question(
                1,
                1,
                "How do I texture a cube?",
                "Blender3D",
                date
                );
        Question q2 = new Question(
                2,
                1,
                "What is a 404?",
                "PC",
                date
        );
        Question q3 = new Question(
                3,
                1,
                "Is sugar sugar free?",
                "Food",
                date
        );

        questionRepository.save(q1);
        questionRepository.save(q2);
        questionRepository.save(q3);

        Tag t1= new Tag("Food");
        Tag t2= new Tag("PC");
        Tag t3= new Tag("Blender3D");
        tagRepository.save(t1);
        tagRepository.save(t2);
        tagRepository.save(t3);

        QuestionTag qt1 = new QuestionTag(1,3);
        QuestionTag qt2 = new QuestionTag(2,2);
        QuestionTag qt3 = new QuestionTag(3,1);
        questionTagRepository.save(qt1);
        questionTagRepository.save(qt2);
        questionTagRepository.save(qt3);
    }

    @Transactional
    public void clear() {
        gradeRepository.deleteAll();
        questionRepository.deleteAll();
        teacherRepository.deleteAll();
    }
}
