package com.domain.dao;

import com.domain.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class UserDaoImpl extends GenericDaoImpl<User> {
    public UserDaoImpl() {
        super(User.class);
    }

    public User findByLogin(String login) {
        Criteria criteria = getCurrentSession().createCriteria(User.class);
        return (User)criteria.add(Restrictions.eq("login", login)).uniqueResult();
    }

    public User findByEmail(String email) {
        Criteria criteria = getCurrentSession().createCriteria(User.class);
        return (User) criteria.add(Restrictions.eq("email", email)).uniqueResult();
    }
}
