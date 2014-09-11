package ext

import hello.MessagePrinter
import model.PersonService
import org.springframework.context.ApplicationContext
import org.springframework.context.support.GenericGroovyApplicationContext

class DefaultServiceContext implements ServiceContext {

    ApplicationContext context

    DefaultServiceContext() {
        context = new GenericGroovyApplicationContext("file:config/resources.groovy");
    }

    PersonService getPersonService() {
        context.getBean('personService')
    }

    MessagePrinter getMessagePrinter() {
        context.getBean('messagePrinter')
    }

}
