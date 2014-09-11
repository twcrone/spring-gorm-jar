package hello

//import org.springframework.context.ApplicationContext
import org.springframework.context.support.GenericGroovyApplicationContext;
import org.springframework.context.annotation.*
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration

@EnableAutoConfiguration
@ComponentScan
class Application {

    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            String getMessage() {
              return "Hello World!"
            }
        }
    }

  public static void main(String[] args) {
      def context =
          new AnnotationConfigApplicationContext(Application.class)
      def gcontext = new GenericGroovyApplicationContext("file:config/resources.groovy");
      def printer = context.getBean(MessagePrinter.class)
      def gprinter = gcontext.getBean('messagePrinter')
      printer.printMessage()
      gprinter.printMessage()

      def p = new Person(firstName: 'Todd', lastName: 'Crone').save()

      println "${p.id}"
  }
}
