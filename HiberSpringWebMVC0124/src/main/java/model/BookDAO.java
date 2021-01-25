
package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class BookDAO {
	private SessionFactory sessionFactory;

	public void setup() {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure() // hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception ex) {
			StandardServiceRegistryBuilder.destroy(registry);
			System.out.println("Setup Failed:" + ex.getMessage());
		}
	}

	public void exit() {
	}

	public void create() {
		Book book = new Book();
		book.setBookId(1);
		book.setTitle("Effective Java");
		book.setAuthor("Joshua Bloch");
		book.setPrice(32.59f);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(book);
		session.getTransaction().commit();
		session.close();
	}

	public String read() {
		Session session = sessionFactory.openSession();
		int bookId = 1;
		Book book = session.get(Book.class, bookId);
		System.out.println("Title: " + book.getTitle());
		System.out.println("Author: " + book.getAuthor());
		System.out.println("Price: " + book.getPrice());
		String m = "Title: " + book.getTitle() + "<br>Author: " + book.getAuthor() + "<br>Price: " + book.getPrice();
		session.close();
		return m;
	}

	public void update() {
		Book book = new Book();
		book.setBookId(1);
		book.setTitle("Ultimate Java Programming");
		book.setAuthor("Nam Ha Minh");
		book.setPrice(19.99f);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(book);
		session.getTransaction().commit();
		session.close();
	}

	public void delete() {
		Book book = new Book();
		book.setBookId(1);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(book);
		session.getTransaction().commit();
		session.close();
	}
}