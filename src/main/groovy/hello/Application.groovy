package hello

import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.*

@Configuration
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
      def printer = context.getBean(MessagePrinter.class)
      printer.printMessage()
  }
}
