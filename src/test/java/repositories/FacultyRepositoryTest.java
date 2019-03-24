package repositories;

import org.junit.Test;


/**
 * @author Mariusz Kowalczuk
 */
public class FacultyRepositoryTest {
    @Test
    public void testing(){
       FacultyRepository facultyRepository = new FacultyRepository();
        System.out.println(facultyRepository.findAll());
    }

}