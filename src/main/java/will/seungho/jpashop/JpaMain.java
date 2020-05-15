package will.seungho.jpashop;

import will.seungho.jpashop.domain.item.Album;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpashop");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		try {
			Album album = new Album();
			album.setName("name");
			album.setStockQuantity(1);
			album.setPrice(1000);
			album.setArtist("artist");
			album.setEtc("etc");

			entityManager.persist(album);

			entityManager.flush();
			entityManager.clear();

			Album findAlbum = entityManager.find(Album.class, album.getId());
			System.out.println(findAlbum.getName());

			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		entityManagerFactory.close();
	}

}
