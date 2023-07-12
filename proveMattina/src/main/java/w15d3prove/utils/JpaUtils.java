package w15d3prove.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {
	private static final EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("w15d3prove");
		} catch (Throwable ex) {
			System.err.println("Initial EntityManagerFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}

}
