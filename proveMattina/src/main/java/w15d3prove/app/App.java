package w15d3prove.app;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import w15d3prove.dao.BlogpostDao;
import w15d3prove.dao.DocumentDao;
import w15d3prove.dao.UserDao;
import w15d3prove.entities.Blogpost;
import w15d3prove.entities.Document;
import w15d3prove.entities.User;
import w15d3prove.utils.JpaUtils;

public class App {

	private static EntityManagerFactory emf = JpaUtils.getEntityManagerFactory();

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();

		UserDao ud = new UserDao(em);

		DocumentDao dd = new DocumentDao(em);

		BlogpostDao bd = new BlogpostDao(em);

		User user = new User("PINO", "PINI");

		Document document = new Document("onetwothree", LocalDate.now(), "US");

		User u = ud.searchById(552);
		System.out.println(u);

		Blogpost blog = new Blogpost("Ciao", "ipse", u);

//		dd.save(document);
//		user.setDocument(document);
//		ud.save(user);

//		bd.save(blog);

		u.getBlogs().stream().forEach(el -> System.out.println(el));

		em.close();
		emf.close();

	}

}
