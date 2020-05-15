package will.seungho.jpashop.domain.delivery;

import lombok.Getter;
import lombok.NoArgsConstructor;
import will.seungho.jpashop.BaseEntity;
import will.seungho.jpashop.domain.order.Order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Getter
@NoArgsConstructor
@Entity
public class Delivery extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DELIVERY_ID")
	private Long id;

	private String city;

	private String street;

	private String zipCode;

	private DeliveryStatus status;

	@OneToOne(mappedBy = "delivery")
	private Order order;

}
