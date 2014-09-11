import fns.App
import fns.Person

ctx = App.defaultServiceContext
service = ctx.personService
service.save(new Person())