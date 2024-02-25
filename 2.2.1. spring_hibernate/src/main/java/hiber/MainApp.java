package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);
      CarService carService = context.getBean(CarService.class);



      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru",new Car("Lada", 321)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru",new Car("BMV", 32113)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru",new Car("ZIL", 3545124)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru",new Car("Lada", 32552)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user.toString());
      }


      context.close();
   }
}
