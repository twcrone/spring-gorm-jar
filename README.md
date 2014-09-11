FNS GORM POC
============

Very rough attempt at using GORM with minimal Spring/Hibernate support in
stand-alone JAR.

From project root, simply run:

`gradle run`

Out put should be:

```
Hello World!
Hello Groovy DSL!
Person with ID=1
Groovy Person with ID=2
```

Output illustrates:

1.  Spring core present for auto-wiring dependencies.
2.  Groovy DSL used for dependency injection
3.  GORM can persist `Person` in H2 and an `id` is assigned.
4.  A service that can be exposed outside JAR.

Much more to do...
