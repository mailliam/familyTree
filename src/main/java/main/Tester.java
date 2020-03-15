package main;

import config.DbConfig;
import config.HsqlDataSource;
import dao.PersonDao;
import model.Person;
import model.Sex;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Tester {

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx =
                new AnnotationConfigApplicationContext(
                        DbConfig.class, HsqlDataSource.class);

        try (ctx) {

            PersonDao dao = ctx.getBean(PersonDao.class);

            Person child = new Person("Mati", "Mets");
            Person mother = new Person("Kati", "Karu");
            Person father = new Person("Johannes", "Mets");
            child.setMother(mother);
            child.setFather(father);
            child.setSex(Sex.MALE);

            dao.save(mother);
            dao.save(father);
            dao.save(child);

            System.out.println(dao.findPersonByName("Mati").getFather());







            //Person person = dao.findPersonByName("Mati");
            //System.out.println(person.getChildren2().get(1));
            //System.out.println(person.getParent2().getFirstName());



        }
    }
}
