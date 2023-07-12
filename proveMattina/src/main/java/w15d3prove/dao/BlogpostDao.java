package w15d3prove.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import w15d3prove.entities.Blogpost;

public class BlogpostDao {
	private final EntityManager em;

	public BlogpostDao(EntityManager em) {
		this.em = em;
	}

	public void save(Blogpost s) {
		EntityTransaction t = em.getTransaction();
		t.begin();

		em.persist(s);

		t.commit();

		System.out.println("Blogpost salvato con successo!");
	}

	public Blogpost searchById(long id) {
		Blogpost found = em.find(Blogpost.class, id);

		if (found != null) {
			return found;
		} else {
			System.out.println("Blogpost non trovato");
		}

		return null;
	}

	public void searchAndDestroy(long id) {
		Blogpost found = em.find(Blogpost.class, id);

		if (found != null) {
			EntityTransaction t = em.getTransaction();

			t.begin();

			em.remove(found);

			t.commit();

			System.out.println("Blogpost eliminato correttamente");
		} else {
			System.out.println("Blogpost non trovato");
		}
	}
}
