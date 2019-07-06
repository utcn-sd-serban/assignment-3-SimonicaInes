//package ro.utcn.sd.a3.controller;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.event.EventListener;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import ro.utcn.sd.a3.dto.TagDTO;
//import ro.utcn.sd.a3.event.BaseEvent;
//import ro.utcn.sd.a3.service.TagService;
//
//import java.util.List;
//
//@Slf4j
//@RestController
//@RequiredArgsConstructor
//public class TagsController {
//    private final TagService tagService;
//    private final SimpMessagingTemplate messagingTemplate;
//
//    @GetMapping("/tags")
//    public List<TagDTO> readAll() {
//        return tagService.listAll();
//    }
//
//    @PostMapping("/tags")
//    public TagDTO create(@RequestBody TagDTO dto) {
//        return tagService.create(dto);
//    }
//
//    @EventListener(BaseEvent.class)
//    public void handleEvent(BaseEvent event) {
//        log.info("Got an event: {}.", event);
//        messagingTemplate.convertAndSend("/topic/events", event);
//    }
//}
