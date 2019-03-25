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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode//(exclude = "rooms")
//@ToString//(exclude = "rooms")
public class Faculty extends AbstractEntity {
    private String name;
    @OneToMany(mappedBy = "faculty", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private Set<Room> rooms;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "faculty_lecturer",
            joinColumns = @JoinColumn(name = "faculty_id"),
            inverseJoinColumns = @JoinColumn(name = "lecturer_id"))

    private Set<Lecturer> lecturers;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "faculty_course",
            joinColumns = @JoinColumn(name = "faculty_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses;

    @Override
    public String toString() {
        return super.toString()  +" "+ name +
                ", rooms=" + rooms +
                ", lecturers=" + lecturers +
                ", courses=" + courses
                ;
    }
}
