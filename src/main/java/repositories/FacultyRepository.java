package repositories;

import entities.Faculty;

/**
 * @author Mariusz Kowalczuk
 */
public class FacultyRepository extends AbstractHibernateRepository<Faculty> {
    public FacultyRepository() {
        super(Faculty.class);
    }
}
