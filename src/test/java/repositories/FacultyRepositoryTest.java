package repositories;

import entities.Faculty;
import org.hibernate.query.Query;
import org.junit.Test;
import utils.HibernateUtils;

import java.util.List;


/**
 * @author Mariusz Kowalczuk
 */
public class FacultyRepositoryTest {
    FacultyRepository facultyRepository = new FacultyRepository();

    @Test
    public void findAllFaculty() {

        System.out.println(facultyRepository.findAll());
    }

    @Test
    public void savingFaculty() {
        Faculty faculty = new Faculty();
        faculty.setName("Wydział Prawa i Administracji");
        facultyRepository.save(faculty);

    }

    @Test
    public void findByIdTest() {
        System.out.println(facultyRepository.findById(4));
    }

    @Test
    public void FindAndDestroyTest() {
        Faculty byId = facultyRepository.findById(3);
        facultyRepository.remove(byId);
    }

    @Test
    public void findAllFacultiesWithRooms() {
        List<Faculty> inTransaction = HibernateUtils.getInTransaction(
                session -> {
                    Query query = session.createQuery(
                            "select distinct f from Faculty f left join fetch f.rooms", Faculty.class
                    );
                    return query.getResultList();

                });
        inTransaction.forEach(System.out::println);


    }
}