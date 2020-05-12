package will.seungho.jpashop;

import will.seungho.jpashop.domain.member.Member;
import will.seungho.jpashop.domain.order.Order;

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
			Order order = entityManager.find(Order.class, 1L);
			Long memberId = order.getMemberId();
			Member member = entityManager.find(Member.class, memberId);
			// 객체지향적이지 않다!

			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		entityManagerFactory.close();
	}

}
