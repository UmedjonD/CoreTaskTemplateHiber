package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        User user = new User();
        UserServiceImpl userService = new UserServiceImpl();

//        userService.createUsersTable();
//        System.out.println("успешно создали таблицу");
//
//        User user1 = new User("Khabib", "Nur", (byte) 43);
//        userService.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
//
//        User user2 = new User("Umed", "Sobirov", (byte) 23);
//        userService.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
//
//        User user3 = new User("Andrei", "Kotlin", (byte) 23);
//        userService.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
//        System.out.println("add user");

//        userService.removeUserById(2);

//        System.out.println(userService.getAllUsers());

//        userService.cleanUsersTable();


//        userService.cleanUsersTable();
//        System.out.println("clean table");
        //userService.dropUsersTable();
//        System.out.println("дропнули таблицу успешно");







        //--------------------------------------------------------//
        //jdbc

//        List<User> list = new ArrayList<>();
//        User user = new User();
//        UserServiceImpl userService = new UserServiceImpl();

        /**если таблица существует , то просто вывод сообщение, экспешн не кидает*/
//        userService.createUsersTable();
//        System.out.println("успешно создали таблицу");

        /** вывод юзеров, работает*/
//        list = userService.getAllUsers();
//        for (User u : list) {
//            System.out.println(u);
//        }

//        user.setAge((byte) 25);
//        user.setName("Umed");
//        user.setLastName("Sobirov");

        /** добавление нового юзера, работает */
//        userService.saveUser(user.getName(), user.getLastName(), user.getAge());

        /** очищаем таблицу user, работает */
//        userService.cleanUsersTable();
//        System.out.println("очистка таблицы"); // все четко работает

        /** удаляем данные по id, работает */
//        userService.removeUserById(3);
//        System.out.println("удалили 3 юзера"); // работает

        /** дропаем таблицу, работает */
//        userService.dropUsersTable();
//        System.out.println("дропнули таблицу успешно"); // работает


    }
}
