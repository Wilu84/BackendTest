package entities.pet.subEntities;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Category {
    private String name;
    private Integer id;
}