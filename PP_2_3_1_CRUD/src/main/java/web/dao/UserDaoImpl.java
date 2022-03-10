package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> index() {
        return entityManager.createQuery("FROM user", User.class).getResultList();
    }

    @Override
    public void save(User user) { entityManager.persist(user); }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(int id, User user) { entityManager.merge(user); }

    @Override
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

}
