package repositories;

import entities.Faculty;
import org.junit.Test;


/**
 * @author Mariusz Kowalczuk
 */
public class FacultyRepositoryTest {
    FacultyRepository facultyRepository = new FacultyRepository();
    @Test
    public void findAllFaculty(){

        System.out.println(facultyRepository.findAll());
    }
    @Test
    public void savingFaculty(){
        facultyRepository.save(new Faculty("Wydział Prawa i Administracji"));

    }
    @Test
    public void findByIdTest(){
        System.out.println(facultyRepository.findById(3));
    }
    @Test
    public void FindAndDestroyTest(){
        Faculty byId = facultyRepository.findById(3);
        facultyRepository.remove(byId);
    }


}