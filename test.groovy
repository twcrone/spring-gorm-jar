import ext.DefaultServiceContext
import hello.*

def gcontext = new DefaultServiceContext()
def gprinter = gcontext.getMessagePrinter()
gprinter.printMessage()

def service = gcontext.getPersonService()
p = service.save(new Person(firstName: 'Groovy', lastName: 'Person'))
def groovyPerson = service.get(p.id)

println "Groovy Person with ID=${groovyPerson.id}"