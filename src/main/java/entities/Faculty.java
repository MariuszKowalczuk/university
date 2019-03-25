package entities;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Mariusz Kowalczuk
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode//(exclude = "rooms")
@ToString//(exclude = "rooms")
public class Faculty extends AbstractEntity {
    private String name;
    @OneToMany(mappedBy = "faculty", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    private Set<Room> rooms;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "faculty_lecturer",
            joinColumns = @JoinColumn(name = "faculty_id"),
            inverseJoinColumns = @JoinColumn(name = "lecturer_id"))

    private Set<Lecturer> lecturers;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "faculty_course",
            joinColumns = @JoinColumn(name = "faculty_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses;



}
