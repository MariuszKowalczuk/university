package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

/**
 * @author Mariusz Kowalczuk
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Faculty extends AbstractEntity {
    private String name;


}
