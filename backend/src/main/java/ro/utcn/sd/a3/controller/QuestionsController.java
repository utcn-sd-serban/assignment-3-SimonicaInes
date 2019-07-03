package ro.utcn.sd.a3.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.utcn.sd.a3.command.Command;
import ro.utcn.sd.a3.dto.QuestionDTO;
import ro.utcn.sd.a3.event.BaseEvent;
import ro.utcn.sd.a3.service.QuestionService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class QuestionsController {
    private final SimpMessagingTemplate messagingTemplate;
    private final Command command;
    @GetMapping("/questions")
    public List<QuestionDTO> readAll() {
        return command.handleCommands("listAll", null);
    }

    @PostMapping("/questions")
    public QuestionDTO create(@RequestBody QuestionDTO dto) {
        return command.handleCommands("createQuestion", dto).get(0);
    }

    @EventListener(BaseEvent.class)
    public void handleEvent(BaseEvent event) {
        log.info("Got an event: {}.", event);
        messagingTemplate.convertAndSend("/topic/events", event);
    }
}
