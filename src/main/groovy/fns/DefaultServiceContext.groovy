package fns

import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class DefaultServiceContext implements ServiceContext {

    ApplicationContext applicationContext

    DefaultServiceContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext
    }

    PersonService getPersonService() {
        this.applicationContext.getBean('personService')
    }
}
