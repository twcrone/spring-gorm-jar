Spring GORM JAR
===============

Very rough attempt at using GORM with minimal Spring/Hibernate support in a JAR used by another application for its
persistence layer.

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

or for second step build the Java 'runner' file and run:
```
javac -cp build/libs/blah-gorm-1.0-SNAPSHOT.jar:. Test.java
java -cp build/libs/blah-gorm-1.0-SNAPSHOT.jar:. Test
```

Here is current stacktrace on this:

```
[main] INFO org.springframework.context.annotation.AnnotationConfigApplicationContext - Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@595c9dcd: startup date [Fri Sep 12 12:20:52 EDT 2014]; root of context hierarchy
Caught: org.springframework.beans.factory.parsing.BeanDefinitionParsingException: Configuration problem: No namespace handler found for URI: http://www.springframework.org/schema/context
Offending resource: Groovy
org.springframework.beans.factory.parsing.BeanDefinitionParsingException: Configuration problem: No namespace handler found for URI: http://www.springframework.org/schema/context
Offending resource: Groovy
	at org.springframework.beans.factory.groovy.GroovyBeanDefinitionReader.xmlns(GroovyBeanDefinitionReader.java:310)
	at org.grails.datastore.gorm.bootstrap.AbstractDatastoreInitializer$_getCommonConfiguration_closure1.doCall(AbstractDatastoreInitializer.groovy:134)
	at org.grails.datastore.gorm.bootstrap.AbstractDatastoreInitializer$_getCommonConfiguration_closure1.doCall(AbstractDatastoreInitializer.groovy)
	at grails.orm.bootstrap.HibernateDatastoreSpringInitializer$_getBeanDefinitions_closure1.doCall(HibernateDatastoreSpringInitializer.groovy:98)
	at grails.orm.bootstrap.HibernateDatastoreSpringInitializer$_getBeanDefinitions_closure1.doCall(HibernateDatastoreSpringInitializer.groovy)
	at org.springframework.beans.factory.groovy.GroovyBeanDefinitionReader.invokeBeanDefiningClosure(GroovyBeanDefinitionReader.java:423)
	at org.springframework.beans.factory.groovy.GroovyBeanDefinitionReader.beans(GroovyBeanDefinitionReader.java:247)
	at org.springframework.beans.factory.groovy.GroovyBeanDefinitionReader$beans.call(Unknown Source)
	at org.grails.datastore.gorm.bootstrap.AbstractDatastoreInitializer$GroovyBeanReaderInit.registerBeans(AbstractDatastoreInitializer.groovy:178)
	at org.grails.datastore.gorm.bootstrap.AbstractDatastoreInitializer.configureForBeanDefinitionRegistry(AbstractDatastoreInitializer.groovy:122)
	at org.grails.datastore.gorm.boot.autoconfigure.HibernateGormAutoConfiguration.registerBeanDefinitions(HibernateGormAutoConfiguration.groovy:84)
	at org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader.loadBeanDefinitionsFromRegistrars(ConfigurationClassBeanDefinitionReader.java:319)
	at org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader.loadBeanDefinitionsForConfigurationClass(ConfigurationClassBeanDefinitionReader.java:139)
	at org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader.loadBeanDefinitions(ConfigurationClassBeanDefinitionReader.java:116)
	at org.springframework.context.annotation.ConfigurationClassPostProcessor.processConfigBeanDefinitions(ConfigurationClassPostProcessor.java:324)
	at org.springframework.context.annotation.ConfigurationClassPostProcessor.postProcessBeanDefinitionRegistry(ConfigurationClassPostProcessor.java:243)
	at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanDefinitionRegistryPostProcessors(PostProcessorRegistrationDelegate.java:254)
	at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:94)
	at org.springframework.context.support.AbstractApplicationContext.invokeBeanFactoryPostProcessors(AbstractApplicationContext.java:609)
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:464)
	at org.springframework.context.annotation.AnnotationConfigApplicationContext.<init>(AnnotationConfigApplicationContext.java:84)
	at blah.App.getDefaultServiceContext(App.groovy:23)
	at blah.App$getDefaultServiceContext.call(Unknown Source)
	at test.run(test.groovy:4)
```
