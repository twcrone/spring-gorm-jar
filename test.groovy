import blah.App
import blah.Person

println "1"
ctx = App.getDefaultServiceContext()
println "2"
service = ctx.getPersonService()
println "3"
p = new Person(firstName: 'Todd', lastName: 'Crone')
println "4"
service.save(p)
println "Person saved with ID=${p.id}"
