package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Mariusz Kowalczuk
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Course extends AbstractEntity{
    private String name;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "faculty_course",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "faculty_id")
    )
    private Set<Faculty> faculties;

}
