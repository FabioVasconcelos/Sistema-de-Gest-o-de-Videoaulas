package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {
	private static final EntityManagerFactory emf = criar();
	
	private static EntityManagerFactory criar() {
		return Persistence.createEntityManagerFactory("meujpa");
	}

	public static EntityManagerFactory get() {
		return emf;
	}
}
