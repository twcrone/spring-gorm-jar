package hello

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class MessagePrinter {

    final private MessageService service

    @Autowired
    MessagePrinter(MessageService service) {
        this.service = service
    }

    void printMessage() {
        println(this.service.getMessage())
    }
}
