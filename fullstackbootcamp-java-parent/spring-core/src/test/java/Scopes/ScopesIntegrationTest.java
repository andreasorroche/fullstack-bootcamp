package Scopes;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
public class ScopesIntegrationTest {

    private static final String NAME = "John Smith";
    private static final String NAME_OTHER = "Anna Jones";
    
    
    	private AnnotationConfigApplicationContext context;

        @BeforeEach
        void setUp() {
            context = new AnnotationConfigApplicationContext();
            context.scan("Scopes");
            context.refresh();
        }

    @Test
    public void givenSingletonScope_whenSetName_thenEqualNames() {
        //final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("scopes.xml");

        final Person personSingletonA = (Person) context.getBean("personSingleton");
        final Person personSingletonB = (Person) context.getBean("personSingleton");

        personSingletonA.setName(NAME);
        Assert.assertEquals(NAME, personSingletonB.getName());

        ((AbstractApplicationContext) context).close();
    }

    @Test
    public void givenPrototypeScope_whenSetNames_thenDifferentNames() {
        //final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("scopes.xml");

        final Person personPrototypeA = (Person) context.getBean("personPrototype");
        final Person personPrototypeB = (Person) context.getBean("personPrototype");

        personPrototypeA.setName(NAME);
        personPrototypeB.setName(NAME_OTHER);

        Assert.assertEquals(NAME, personPrototypeA.getName());
        Assert.assertEquals(NAME_OTHER, personPrototypeB.getName());

        ((AbstractApplicationContext) context).close();
    }

    }
