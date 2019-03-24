package repositories;

import entities.AbstractEntity;
import lombok.AllArgsConstructor;
import utils.HibernateUtils;

import java.util.List;

/**
 * @author Mariusz Kowalczuk
 */
@AllArgsConstructor
public abstract class AbstractHibernateRepository<T extends AbstractEntity> {
    private Class<T> clazz;

    public T findById(Integer id) {

        return HibernateUtils.getInTransaction(
                session -> session.find(clazz, id)
        );

    }


    public List<T> findAll() {

        List<T> result = HibernateUtils.getInTransaction(
                session -> session.createQuery
                        ("select e from " + clazz.getSimpleName() + " e", clazz).getResultList());

        return result;
    }

    public T save(T entity) {

        return HibernateUtils.getInTransaction(session -> {
                    if(entity.getId() == null){
                        session.persist(entity);
                    }
                    return (T) session.merge(entity);
                }
        );
    }

    public void remove(T entity) {
        HibernateUtils.getInTransaction(session -> {
            session.delete(entity);
            return null;
        });

    }

}
