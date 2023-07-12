package w15d3prove.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import w15d3prove.entities.User;

public class UserDao {
	private final EntityManager em;

	public UserDao(EntityManager em) {
		this.em = em;
	}

	public void save(User s) {
		EntityTransaction t = em.getTransaction();
		t.begin();

		em.persist(s);

		t.commit();

		System.out.println("Studente salvato con successo!");
	}

	public User searchById(long id) {
		User found = em.find(User.class, id);

		if (found != null) {
			return found;
		} else {
			System.out.println("Evento non trovato");
		}

		return null;
	}

	public void searchAndDestroy(long id) {
		User found = em.find(User.class, id);

		if (found != null) {
			EntityTransaction t = em.getTransaction();

			t.begin();

			em.remove(found);

			t.commit();

			System.out.println("Evento eliminato correttamente");
		} else {
			System.out.println("Evento non trovato");
		}
	}

//	public void refresh(UUID id) {
//		Student found = em.find(Student.class, id);
//
//		System.out.println("PRE REFRESH");
//		System.out.println(found);
//		em.refresh(found);
//
//		System.out.println("POST REFRESH");
//
//		System.out.println(found);
//
//	}
}
