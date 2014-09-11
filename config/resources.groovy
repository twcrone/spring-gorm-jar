

beans {

    messageService(hello.MessageServiceImpl)

    messagePrinter(hello.MessagePrinter, ref('messageService'))


}
