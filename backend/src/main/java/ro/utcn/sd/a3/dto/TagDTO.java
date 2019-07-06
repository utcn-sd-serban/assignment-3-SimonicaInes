package ro.utcn.sd.a3.dto;

import lombok.Data;
import ro.utcn.sd.a3.entity.Tag;


@Data
public class TagDTO {
    private int id;
    private String text;

    public static TagDTO ofEntity(Tag tag) {
        TagDTO tagDTO = new TagDTO();
        tagDTO.setText(tag.getText());

        return tagDTO;
    }
}
