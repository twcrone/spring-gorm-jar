import blah.*;
import blah.ServiceContext;
import org.springframework.context.ApplicationContext;

public class Test {
    public static void main(String[] args) {
        println("1");
        ServiceContext ctx = App.getDefaultServiceContext();
        println("1");
        PersonService service = ctx.getPersonService();
        println("1");
        Person p = new Person();
        p.setFirstName("Todd");
        p.setLastName("Crone");
        println("1");
        service.save(p);
        println("1");
    }

    static void println(String s) {
        System.out.println(s);
    }
}
