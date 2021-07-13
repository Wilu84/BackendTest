package entities.pet;

import entities.pet.subEntities.Category;
import entities.pet.subEntities.Tags;
import lombok.*;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pet {

    private List<String> photoUrls;
    private String name;
    private int id;
    private Category category;
    private List<Tags> tags;
    private String status;

}


