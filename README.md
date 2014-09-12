FNS GORM POC
============

Very rough attempt at using GORM with minimal Spring/Hibernate support in
stand-alone JAR.

From project root, simply run:

`gradle run`

Output should be:

```
Person saved with ID=1
```

Output illustrates:

1.  Spring core present for auto-wiring dependencies.
2.  GORM can persist `Person` in H2 and an `id` is assigned.

Now try packaging as a 'fat' JAR and run similarly...

```
gradle clean build
groovy -cp build/libs/blah-gorm-1.0-SNAPSHOT.jar test.groovy
```


Here is current stacktrace on this:

```
[main] INFO org.springframework.context.annotation.AnnotationConfigApplicationContext - Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@7a2145e6: startup date [Fri Sep 12 11:23:34 EDT 2014]; root of context hierarchy
Caught: java.lang.IllegalStateException: Method on class [blah.Person] was used outside of a Grails application. If running in the context of a test using the mocking API or bootstrap Grails correctly.
java.lang.IllegalStateException: Method on class [blah.Person] was used outside of a Grails application. If running in the context of a test using the mocking API or bootstrap Grails correctly.
	at blah.Person.currentGormInstanceApi(Person.groovy)
	at blah.Person.save(Person.groovy)
	at blah.Person$save.call(Unknown Source)
	at blah.PersonService.save(PersonService.groovy:9)
	at blah.PersonService$save.call(Unknown Source)
	at test.run(test.groovy:6)
```
