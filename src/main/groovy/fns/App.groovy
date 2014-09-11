package fns

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.ComponentScan

@ComponentScan
@EnableAutoConfiguration
class App {

    public static ServiceContext getDefaultServiceContext() {
        def ctx = new AnnotationConfigApplicationContext(App.class)
        return new DefaultServiceContext(ctx)
    }

    public static void main(String[] args) {
        println "HEY"
        def ctx = getDefaultServiceContext()
        def service = ctx.getPersonService()
        service.save(new Person())
//      def printer = context.getMessagePrinter()
//      printer.printMessage()

//      def service = context.getPersonService()
//      def person = service.save(new Person(firstName: 'Groovy', lastName: 'Person'))
//      def groovyPerson = service.get(person.id)
//
//      println "Groovy Person with ID=${groovyPerson.id}"
    }
}
