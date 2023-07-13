package w15d3prove.dao;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import w15d3prove.entities.Category;

public class CategoriesDao {
	private final EntityManager em;

	public CategoriesDao(EntityManager em) {
		this.em = em;
	}

	public void save(Category s) {
		EntityTransaction t = em.getTransaction();
		t.begin();

		em.persist(s);

		t.commit();

		System.out.println("Category salvato con successo!");
	}

	public Category searchById(long id) {
		Category found = em.find(Category.class, id);

		if (found != null) {
			return found;
		} else {
			System.out.println("Category non trovato");
		}

		return null;
	}

	public void searchAndDestroy(long id) {
		Category found = em.find(Category.class, id);

		if (found != null) {
			EntityTransaction t = em.getTransaction();

			t.begin();

			em.remove(found);

			t.commit();

			System.out.println("Category eliminato correttamente");
		} else {
			System.out.println("Category non trovato");
		}
	}

	public void insertMany(Set<String> categories) {
		for (String cat : categories) {
			EntityTransaction t = em.getTransaction();
			Category category = new Category(cat);
			t.begin();
			em.persist(category);
			t.commit();

		}
		System.out.println("Categorie inserite");
	}
}
