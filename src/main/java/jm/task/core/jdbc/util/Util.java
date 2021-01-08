package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
//import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
//import org.hibernate.metamodel.MetadataSources;
import org.hibernate.service.ServiceRegistry;

public class Util {
    // реализуйте настройку соеденения с БД

    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration config = new Configuration();
                config.addAnnotatedClass(User.class);
                Properties hiberSettings = new Properties();
                hiberSettings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                hiberSettings.put(Environment.URL, "jdbc:mysql://localhost:3306/finalprojectlibrary");
                hiberSettings.put(Environment.USER, "root");
                hiberSettings.put(Environment.PASS, "root");
                hiberSettings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
                hiberSettings.put(Environment.SHOW_SQL, "true");
                hiberSettings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                hiberSettings.put(Environment.HBM2DDL_AUTO, "create-drop");

                config.setProperties(hiberSettings);
                registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();

                sessionFactory = config.buildSessionFactory(registry);
                System.out.println("connect ok ");
            } catch (Exception e) {
                System.err.println("Ошибка создания сессии " + e);
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}

//    private static String db_driver = "com.mysql.jdbc.Driver";
//    private static String url = "jdbc:mysql://localhost:3306/finalprojectlibrary";
//    private static String userName = "root";
//    private static String pass = "root";
//
//    public Connection getConnBD() throws ClassNotFoundException, SQLException {
//
//        Connection connection = null;
//        Class.forName(db_driver);
//        connection = DriverManager.getConnection(url, userName, pass);
//        System.out.println("okey");
//        return connection;
//    }
//}