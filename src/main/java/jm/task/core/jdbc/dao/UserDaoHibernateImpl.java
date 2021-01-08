package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    private Transaction transaction = null;
    private Session session = null;

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        try {
            session = Util.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS user (id integer not null auto_increment primary key,\n" +
                    "name varchar(50), lastName varchar(50), age integer);").executeUpdate();
            transaction.commit();
            System.out.println("create table ok ");
        } catch (Exception e) {
            System.err.println("error creating table " + e);
            transaction.rollback();
        }
        finally {
            session.close();
        }
    }

    @Override
    public void dropUsersTable() {
        try {
            session = Util.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            String sql = "DROP TABLE IF EXISTS user";
            session.createSQLQuery(sql).executeUpdate();
            transaction.commit();
            System.out.println("droping ok ");
        } catch (Exception e) {
            System.err.println(" eror droping user " + e);
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try {
            session = Util.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(new User(name, lastName, age));
            transaction.commit();
            System.out.println("User с именем – " + name + " добавлен");
        } catch (Exception e) {
            System.err.println("error saving user" + e);
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void removeUserById(long id) {
        try {
            session = Util.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            User user = (User) session.load(User.class, id);
            session.delete(user);
            transaction.commit();
            System.out.println("removing ok ");
        } catch (Exception e) {
            System.err.println("error removing by id " + e);
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = null;
        try {
            session = Util.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            users = session.createQuery("From User").list();
            System.out.println(" all users ok");
        } catch (Exception e) {
            System.err.println(" error getAll users " + e);
            transaction.rollback();
        } finally {
            session.close();
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {
        try {
            session = Util.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.createSQLQuery("DELETE FROM USER").executeUpdate();
            transaction.commit();
            System.out.println("clean ok ");
        } catch (Exception e) {
            System.err.println("error cleaning " + e);
            transaction.rollback();
        } finally {
            session.close();
        }
    }
}
