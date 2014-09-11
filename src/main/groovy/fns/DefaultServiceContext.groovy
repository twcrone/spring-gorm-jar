package fns

import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class DefaultServiceContext implements ServiceContext {

    static instance

    ApplicationContext applicationContext

    static ServiceContext getDefaultInstance() {
        if(instance == null) {
            def ctx = new AnnotationConfigApplicationContext(App.class)
            instance = new DefaultServiceContext(ctx)
        }
        return instance
    }

    private DefaultServiceContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext
    }

    PersonService getPersonService() {
        this.applicationContext.getBean('personService')
    }
}
