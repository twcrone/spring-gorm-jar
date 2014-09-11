package fns

import org.springframework.context.ApplicationContext

class DefaultServiceContext implements ServiceContext {

    ApplicationContext context

    DefaultServiceContext(ApplicationContext context) {
        this.context = context
    }

    PersonService getPersonService() {
        this.context.getBean('personService')
    }
}
