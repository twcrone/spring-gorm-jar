package blah

import org.springframework.context.ApplicationContext

class DefaultServiceContext implements ServiceContext {

    ApplicationContext applicationContext

    DefaultServiceContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext
    }

    PersonService getPersonService() {
        this.applicationContext.getBean('personService')
    }
}
