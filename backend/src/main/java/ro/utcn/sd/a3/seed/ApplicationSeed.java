package ro.utcn.sd.a3.seed;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.sd.a3.entity.Grade;
import ro.utcn.sd.a3.entity.Question;
import ro.utcn.sd.a3.entity.Teacher;
import ro.utcn.sd.a3.repository.GradeRepository;
import ro.utcn.sd.a3.repository.QuestionRepository;
import ro.utcn.sd.a3.repository.TeacherRepository;

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
    private final GradeRepository gradeRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(String... args) throws ParseException {
        Teacher serban=new Teacher(0,"serban", passwordEncoder.encode("123"));
        teacherRepository.save(serban);
        Date date= new SimpleDateFormat("dd/MM/yyyy").parse("11/07/2015");
        if (questionRepository.findAll().isEmpty()) {
            questionRepository.save(new Question(
                    "Blender3D textures",
                    1,
                    "How do I texture a cube?",
                    date));
            questionRepository.save(new Question(
                    "mehh",
                    2,
                    "fd",
                    date));
            questionRepository.save(new Question(
                    " textures",
                    1,
                    "How ",
                    date));
        }

//        List<Grade> grades = Arrays.asList(
//                new Grade(0, 5, LocalDate.now(), serban),
//                new Grade(0, 6, LocalDate.now(), serban),
//                new Grade(0, 7, LocalDate.now(), serban)
//        );
//        gradeRepository.saveAll(grades);
//
//        john.setGrades(grades);
    }

    @Transactional
    public void clear() {
        gradeRepository.deleteAll();
        questionRepository.deleteAll();
        teacherRepository.deleteAll();

    }
}
