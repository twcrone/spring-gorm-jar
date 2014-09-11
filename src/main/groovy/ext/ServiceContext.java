package ext;

import hello.MessagePrinter;
import model.PersonService;

public interface ServiceContext {

    PersonService getPersonService();

    MessagePrinter getMessagePrinter();
}
