package ApplicationView;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main (String args[]){
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        //Welcome hello = new Welcome();

        Welcome goodbye = new Welcome();

        goodbye.welcomeService();
    }



}
