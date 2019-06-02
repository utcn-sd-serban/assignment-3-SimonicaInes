package ro.utcn.sd.a3.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ro.utcn.sd.a3.dto.QuestionDTO;

@Data
@EqualsAndHashCode(callSuper = true)
public class StudentCreatedEvent extends BaseEvent {
    private final QuestionDTO student;

    public StudentCreatedEvent(QuestionDTO student) {
        super(EventType.QUESTION_CREATED);
        this.student = student;
    }
}
