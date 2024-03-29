package blah

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.ComponentScan

@ComponentScan
@EnableAutoConfiguration
class App {

    static ServiceContext defaultServiceContext

    public static void main(String[] args) {
        def ctx = getDefaultServiceContext()
        def service = ctx.getPersonService()
        def p = new Person(firstName: 'Todd', lastName: 'Crone')
        service.save(p)
        println "Person saved with ID=${p.id}"
    }

    static ServiceContext getDefaultServiceContext() {
        if(defaultServiceContext == null) {
            def ctx = new AnnotationConfigApplicationContext(App.class)
            defaultServiceContext = new DefaultServiceContext(ctx)
        }
        return defaultServiceContext
    }

}
