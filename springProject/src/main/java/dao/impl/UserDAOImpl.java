package dao.impl;

import dao.UserDAO;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private HibernateTemplate template;

    @Autowired
    //- через данную аннотацию указывается бин, который необходимо проинжектить в текущий класс
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    @Transactional
    @Override
    public void add(User user) {
      template.save(user);
        template.flush();
    }
    @Transactional
    @Override
    public void update(User user) {
        template.saveOrUpdate(user);
        template.flush();
    }
    @Transactional
    @Override
    public void delete(User user) {
        template.delete(user);
        template.flush();
    }
    @Transactional
    @Override
    public User getById(Long id) {
        return (User) template.get(User.class, id);
    }
    @Transactional
    @Override
    public List<User> getAll() {
        return template.find("from Users");
    }
}
