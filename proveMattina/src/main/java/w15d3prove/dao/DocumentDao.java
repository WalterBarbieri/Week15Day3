package w15d3prove.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import w15d3prove.entities.Document;

public class DocumentDao {
	private final EntityManager em;

	public DocumentDao(EntityManager em) {
		this.em = em;
	}

	public void save(Document s) {
		EntityTransaction t = em.getTransaction();
		t.begin();

		em.persist(s);

		t.commit();

		System.out.println("Documento salvato con successo!");
	}

	public Document searchById(long id) {
		Document found = em.find(Document.class, id);

		if (found != null) {
			return found;
		} else {
			System.out.println("Evento non trovato");
		}

		return null;
	}

	public void searchAndDestroy(long id) {
		Document found = em.find(Document.class, id);

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
}
