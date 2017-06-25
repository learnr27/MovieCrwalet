package david.story;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;

public class JPAStory {

	private EntityManager manager;

	public JPAStory() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("david.jpa");
		manager = factory.createEntityManager();
	}

	public void story(List<MovieBean> list) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Session session = (Session) manager.getDelegate();
		for (int i = 0; i < list.size(); i++) {
			session.save(list.get(i));
		}
		session.flush();
		transaction.commit();
	}
}
