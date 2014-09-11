package fns

import org.springframework.stereotype.Service

@Service(value='personService')
class PersonService {

    Person save(Person person) {
        person.save()
    }
}
