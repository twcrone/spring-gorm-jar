import blah.App
import blah.Person

ctx = App.getDefaultServiceContext()
service = ctx.getPersonService()
p = new Person(firstName: 'Todd', lastName: 'Crone')
service.save(p)
println "Person saved with ID=${p.id}"
