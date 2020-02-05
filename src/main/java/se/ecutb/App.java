package se.ecutb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.ecutb.config.AppConfig;
import se.ecutb.data.PersonRepository;
import se.ecutb.model.Address;
import se.ecutb.model.Person;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        PersonRepository personRepository = context.getBean(PersonRepository.class);

        personRepository.persist(new Person(1, "Peter", "Sundberg", "peter@gmail.com", new Address("Hemvägen 1", "371 62", "Lyckeby")));

    }
}
