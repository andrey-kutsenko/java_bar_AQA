package ua.stqa.aqa.addressbook.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ua.stqa.aqa.addressbook.model.ContactData;
import ua.stqa.aqa.addressbook.model.GroupData;
import ua.stqa.aqa.addressbook.model.Groups;

import java.text.ParseException;
import java.util.List;

public class DbHelper {

  private final SessionFactory sessionFactory;

  public DbHelper(){
  final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
          .configure().build();    // configures settings from hibernate.cfg.xml
    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

  }
  public Groups groups() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<GroupData> result = session.createQuery("from GroupData").list();
    for (GroupData group :result) {
      System.out.println(group);
    }
    session.getTransaction().commit();
    session.close();
    return new Groups(result);
  }
}
