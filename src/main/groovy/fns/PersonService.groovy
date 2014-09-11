package fns

import org.springframework.stereotype.Service

@Service(value='personService')
class PersonService {

    Person save(Person) {
        println "Saving Person..."
    }
}
