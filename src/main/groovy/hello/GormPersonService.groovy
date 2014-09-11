package hello

import model.PersonService

class GormPersonService implements PersonService {

    Person save(Person person) {
        person.save()
        person
    }

    Person get(Long id) {
        Person.get(id)
    }

}
