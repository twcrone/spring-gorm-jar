package model;

import hello.Person;

public interface PersonService {
    public Person save(Person person);
    public Person get(Long id);
}
