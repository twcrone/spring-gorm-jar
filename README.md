FNS GORM POC
============

Very rough attempt at using GORM with minimal Spring/Hibernate support in
stand-alone JAR.

From project root, simply run:

`gradle run`

Out put should be:

```
Hello World!
1
```

Output illustrates:

1.  Spring core present for auto-wiring dependencies.
2.  GORM can persist `Person` in H2 and an `id` is assigned.

Much more to do...
