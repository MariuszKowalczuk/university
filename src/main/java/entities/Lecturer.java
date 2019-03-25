package entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Mariusz Kowalczuk
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data


public class Lecturer extends AbstractEntity {
    private String name;
    private String surname;
    private String grade;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "faculty_lecturer",
            joinColumns = @JoinColumn(name = "lecturer_id"),
            inverseJoinColumns = @JoinColumn(name = "faculty_id"))

    private Set<Faculty> faculties;


}
