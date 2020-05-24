package will.seungho.jpashop.domain.delivery;

import lombok.Getter;
import lombok.NoArgsConstructor;
import will.seungho.jpashop.BaseEntity;
import will.seungho.jpashop.domain.common.Address;
import will.seungho.jpashop.domain.order.Order;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Delivery extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DELIVERY_ID")
	private Long id;

	@Embedded
	private Address address;

	private DeliveryStatus status;

	@OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
	private Order order;

}
