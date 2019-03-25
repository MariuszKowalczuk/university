package entities;

import lombok.*;

import javax.persistence.*;

/**
 * @author Mariusz Kowalczuk
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(exclude = "faculty")
@ToString(exclude = "faculty")
public class Room extends AbstractEntity {
    private String name;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;


}
