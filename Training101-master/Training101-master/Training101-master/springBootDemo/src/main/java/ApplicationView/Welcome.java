package ApplicationView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {

    //private Hello hello;
    private Goodbye goodbye = new Goodbye();


    @RequestMapping()
    public String welcomeService(){
        return goodbye.goodbyeService();
    }
    @Component
    class Goodbye{
        public String goodbyeService(){
            return "It's done! Good Night";
        }
    }
}
